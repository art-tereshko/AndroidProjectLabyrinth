package game;

import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.Surface;

import com.artem_tereshko.androidproject.GameListener;

/**
 * Created by artem_000 on 11/11/2014.
 */
public class PhysicsEngine {

    Ball ball =null;
    Level lvl;

    GameListener gameListener;

    private SensorManager sensorManager = null;
    private Sensor mAccelerometre = null;
    int displayRotaion;

    private float x=0,y=0;

    public PhysicsEngine(SensorManager manager ,int displayRotaion){

        sensorManager = manager;
        mAccelerometre = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        this.displayRotaion =  displayRotaion;

    }
    public void setLevel(Level lvl){
        this.lvl = lvl;
    }
    public void setBall(Ball ball)
    {
        this.ball = ball;
    }


    private void Update(SensorEvent event){

        if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
            return;

        switch (displayRotaion) {
            case Surface.ROTATION_0:
                x = -event.values[0];
                y = event.values[1];
                break;
            case Surface.ROTATION_90:
                x = event.values[1];
                y = event.values[0];
                break;
            case Surface.ROTATION_180:
                x = event.values[0];
                y = -event.values[1];
                break;
            case Surface.ROTATION_270:
                x = -event.values[1];
                y = -event.values[0];
                break;
        }


        ball.setAcceleration(x,y);
        CollisionCheck();
        ball.Move();

        //Check for win
        for(Aim aim: lvl.getAims()){
            if (aim.isIntersect(ball.getDrawRectangle())){

                if(gameListener!=null){
                    Log.i("DEBUG", "onGameWin");
                    gameListener.onGameWin();
                }
                else
                    Log.i("DEBUG", "onGameWin, gameListener is null");
            }
        }


        for(Hole hole: lvl.getHoles()){
            if (hole.isIntersect(ball.getDrawRectangle())){
                if(gameListener!=null){
                    Log.i("DEBUG", "onGameLose");
                    gameListener.onGameLose();
                }
                else
                    Log.i("DEBUG", "onGameLose, gameListener is null");
            }
        }

        for (CircularWall w: lvl.getCircularWalls()){

            if( ball.intersects(w,ball.getDrawRectangle() )) {
                Log.i("DEBUG", "intersection of CircularWall with ball");
            }
        }
    }

    private void CollisionCheck(){

        /*detection bounds of */

        Rect bounds  = lvl.getMovementBounds();

        float speedY =  ball.getSpeedY();
        float speedX = ball.getSpeedX();
        float nextX = ball.getPositionX() + speedX;
        float nextY = ball.getPositionY() + speedY;
        float repulsion = ball.getRepultion();

            if (nextX < bounds.left) {
                nextX = bounds.left;
                speedX = -speedX / repulsion;

            } else if (nextX > bounds.right - ball.getDrawRectangle().width()) {
                nextX = bounds.right - ball.getDrawRectangle().width();
                speedX = -speedX / repulsion;
            }


            if (nextY < bounds.top)
            {
                nextY= bounds.top;
                speedY = -speedY / repulsion;
            }
            else if (nextY> bounds.bottom - ball.getDrawRectangle().height()){
                nextY = bounds.bottom - ball.getDrawRectangle().height();
                speedY = -speedY / repulsion;
            }


        //walls detection
        for (int i = 0; i < getLevel().getWalls().size() ; i++){

            Rect nextBall = new Rect((int)nextX, (int)nextY, (int)nextX + ball.getDrawRectangle().width(), (int)nextY+ball.getDrawRectangle().height() );

            Rect c  = getLevel().getWalls().get(i).getDrawRectangle();

            if( nextBall.intersects(c.left,c.top,c.right,c.bottom)){

                if (nextBall.left < c.right && nextBall.right > c.right  ) {
                    nextX = c.right;
                    speedX = -speedX / repulsion;

                } else if (nextBall.right > c.left && nextBall.left < c.left) {
                    nextX = c.left - ball.getDrawRectangle().width();
                    speedX = -speedX / repulsion;
                }

                if (nextBall.top < c.bottom && nextBall.bottom > c.bottom)
                {
                    nextY = c.bottom;
                    speedY = -speedY / repulsion;
                }
                else if (nextBall.bottom > c.top && nextBall.top <  c.top){
                    nextY =  c.top - ball.getDrawRectangle().height();
                    speedY = -speedY / repulsion;
                }

                Log.i("debugTest", "collision");
            }
        }


        ball.setSpeedY(speedY);
        ball.setSpeedX(speedX);

        ball.setPositionY((int) nextY);
        ball.setPositionX((int)nextX);
    }


    SensorEventListener mSensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
           Update(event);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    public void SetGameListener(GameListener l){
        gameListener = l;
    }
    public void DeleteGameListener(){
        gameListener = null;

    }
    public void Start(){
        sensorManager.registerListener(mSensorEventListener, mAccelerometre, SensorManager.SENSOR_DELAY_UI);
    }
    public  void Pause(){
        sensorManager.unregisterListener(mSensorEventListener);
    }
    public void Stop(){
        sensorManager.unregisterListener(mSensorEventListener);
    }


    public Ball getBall(){
        return ball;
    }
    public Level getLevel(){
        return lvl;
    }










}

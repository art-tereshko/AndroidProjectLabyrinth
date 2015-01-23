package game;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Surface;

import com.artem_tereshko.androidproject.GameListener;

import java.util.Vector;

import game.atitude.collision.ColLevelLose;
import game.atitude.collision.ColLevelWin;
import game.object.circle.Aim;
import game.object.circle.Hole;
import mesmaths.geometrie.base.Vecteur;

//import game.object.circle.Bullet;
//import game.object.rectangle.Cannon;


public class PhysicsEngine {
    Vector<AbstractGameObject> objets;
    Level lvl;
    GameListener gameListener;

    private SensorManager sensorManager = null;
    private Sensor mAccelerometre = null;
    int displayRotation;

    private double SensorX =0, SensorY =0;

    public PhysicsEngine(SensorManager manager ,int displayRotation){

        sensorManager = manager;
        mAccelerometre = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        this.displayRotation = displayRotation;
        this.objets= new Vector<AbstractGameObject>();


    }

    public GameListener getGameListener() {
        return gameListener;
    }

    public void setGameListener(GameListener gameListener) {
        this.gameListener = gameListener;
    }

    public Level getLevel(){
        return lvl;
    }

    public void setLevel(Level lvl){
        this.lvl = lvl;
        this.objets = getLevel().get_objets();

        //Initialisation des composants ayant un gameListener
        int i = 0;
        for (AbstractGameObject gameObject : objets) {
            if(gameObject.getAbstractGameObject() instanceof Aim) {
                gameObject = new ColLevelWin(gameObject, gameListener);
                objets.set(i, gameObject);
            }
            if(gameObject.getAbstractGameObject() instanceof Hole) {
                gameObject = new ColLevelLose(gameObject, gameListener);
                objets.set(i, gameObject);
            }
            i++;
        }
    }

    private void Update(SensorEvent event) {

        if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
            return;

        switch (displayRotation) {
            case Surface.ROTATION_0:
                SensorX = -event.values[0];
                SensorY = event.values[1];
                break;
            case Surface.ROTATION_90:
                SensorX = event.values[1];
                SensorY = event.values[0];
                break;
            case Surface.ROTATION_180:
                SensorX = event.values[0];
                SensorY = -event.values[1];
                break;
            case Surface.ROTATION_270:
                SensorX = -event.values[1];
                SensorY = -event.values[0];
                break;
        }

        this.objets = getLevel().get_objets();
        for (AbstractGameObject gameObject : objets) {
            gameObject.gestionMouvement(new Vecteur(SensorX, SensorY));
            gameObject.collisionContour(0, 0, lvl.getWorldWidth(), lvl.getWorldHeight());

            //collision avec les autres objets
            for (AbstractGameObject autreGameObject : objets) {
                if(!autreGameObject.equals(gameObject)) {
                    gameObject.collisionGameObject(autreGameObject);
                }
            }
            gameObject.move(lvl.getWorldWidth() / lvl.getWorldHeight());//mise à l'échelle
        }
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

    public void Start(){
        sensorManager.registerListener(mSensorEventListener, mAccelerometre, SensorManager.SENSOR_DELAY_GAME);
    }
    public  void Pause(){
        sensorManager.unregisterListener(mSensorEventListener);
    }
    public void Stop(){
        sensorManager.unregisterListener(mSensorEventListener);
    }
}

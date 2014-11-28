package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by artem_tereshko on 11/11/2014.
 */
public class Ball extends InteractiveGameObject implements Movable, Collisionable {

    /**
     * The Ball will be positioned in left top corner of the window
     * @param height height of Ball. Used for collision detection
     * @param width width of Ball. Used for collision detection
     */
    public Ball(int height, int width) {
        super(height, width);
    }

    /**
     *
     * @param coordinateX coordinate X of Ball when created
     * @param coordinateY coordinate X of Ball when created
     * @param height height of Ball. Used for collision detection
     * @param width width of Ball. Used for collision detection
     */
    public Ball(int coordinateX, int coordinateY, int height, int width){
        super(coordinateX, coordinateY, height, width);
    }


    @Override
    public float getSpeedX() {
        return speedX;
    }

    @Override
    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedX(float x){
        speedX = x;
    }
    public void setSpeedY(float y){
        speedY = y;
    }

    public int getPositionX(){
        return posX;
    }

    public int getPositionY(){
        return posY;
    }

    public float getRepultion(){return  repulsion;}
    @Override
    public void setAcceleration(float xA, float yA) {

        speedX += xA;
        if (speedX > maxSpeed)
            speedX = maxSpeed;
        if (speedX < -maxSpeed)
            speedX = -maxSpeed;

        speedY += yA;
        if (speedY > maxSpeed)
            speedY = maxSpeed;
        if (speedY < -maxSpeed)
            speedY = -maxSpeed;
    }

    @Override
    public void Move() {
       // setPositionX(posX + (int)speedX);
       // setPositionY(posY + (int)speedY);
        DrawRectangle = new Rect(posX,posY, posX + height, posY + width);
    }


    public void setPositionX(int x){

        this.posX = x;
    }
    public void setPositionY(int y){

        this.posY = y;
    }

    @Override
    public Rect getDrawRectangle() {
         return DrawRectangle;
    }

    @Override
    public void setTexture(Bitmap b) {
        texture = b;
    }

    @Override
    public void Draw(Canvas canvas) {
        canvas.drawBitmap ( texture, null, getDrawRectangle(), null );
    }

    @Override
    public boolean isIntersect(Rect r) {
       return  DrawRectangle.intersects(r.left, r.top,r.right, r.bottom);
    }
}

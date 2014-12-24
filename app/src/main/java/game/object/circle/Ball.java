package game.object.circle;

import android.graphics.Canvas;
import android.graphics.Rect;

import game.GameObjectInteractive;
import game.Movable;

public class Ball extends GameObjectInteractive implements Movable {



    public Ball(int radius, int x, int y){
        super(radius, x, y);
    }


    public void setAcceleration(float xA, float yA) {

        speedX += xA;
        if (speedX > maxSpeed)//droite
            speedX = maxSpeed;
        if (speedX < -maxSpeed)//gauche
            speedX = -maxSpeed;

        speedY += yA;
        if (speedY > maxSpeed)//haut
            speedY = maxSpeed;
        if (speedY < -maxSpeed)//bas
            speedY = -maxSpeed;
    }

    @Override
    public void Move() {
        // setPositionX(posX + (int)speedX);
        // setPositionY(posY + (int)speedY);
        this.drawRectangle = new Rect(posX , posY, posX + get_radius()*2, posY+ get_radius()*2);//left, tope, right, bottom
    }


    @Override
    public void Draw(Canvas canvas) {
        if ( texture!=null){
            canvas.drawBitmap ( texture, null, getDrawRectangle(), null );
        }
    }
    /*
    @Override
    public boolean isIntersect(Rect r) {
       return  drawRectangle.intersects(r.left, r.top,r.right, r.bottom);
    }*/

    //intersection with objects no-flat (CircularWall for example)
    /*public  boolean intersects(CircularWall circle, Rect rect)
    {
        //distance between rect(of the ball) and circle(of the circularwall)
        Point circleDistance= new Point();
        circleDistance.x = Math.abs(circle.posX - rect.left);
        circleDistance.y = Math.abs(circle.posY - rect.top);

        //
        if (circleDistance.x > (rect.width()/2 + circle.getRadius())) { return false; }
        if (circleDistance.y > (rect.height()/2 + circle.getRadius())) { return false; }

        if (circleDistance.x <= (rect.width()/2)) { return true; }
        if (circleDistance.y <= (rect.width()/2)) { return true; }
        //using the Pythagorean theorem to know if is in the circle or not
        int cornerDistance_sq = (circleDistance.x - rect.width() / 2) ^ 2 + (circleDistance.y - rect.height() / 2) ^ 2;

        return (cornerDistance_sq <= (circle.getRadius()^2));
    }*/

}

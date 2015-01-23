package game.object.circle;

import android.graphics.Rect;

import java.util.Vector;

import game.AbstractGameObject;
import game.shape.ShapeCircle;
import mesmaths.geometrie.base.Vecteur;

public class Ball extends ShapeCircle {

    private Vecteur _acceleration;

    public Ball(int radius, int x, int y, double masse){
        super(radius, x, y);
        this.masse = masse;
        this.acceleration = new Vecteur();
    }


    public void setAcceleration(double xA, double yA) {
        _speed.x += xA;
        if (_speed.x > maxSpeed)//droite
            _speed.x = maxSpeed;
        if (_speed.x < -maxSpeed)//gauche
            _speed.x = -maxSpeed;

        _speed.y += yA;
        if (_speed.y > maxSpeed)//haut
            _speed.y = maxSpeed;
        if (_speed.y < -maxSpeed)//bas
            _speed.y = -maxSpeed;
    }


    /*
    @Override
    public boolean isIntersect(Rect r) {
       return  _drawRectangle.intersects(r.left, r.top,r.right, r.bottom);
    }*/

    //intersection with objects no-flat (CircularWall for example)
    /*public  boolean intersects(CircularWall circle, Rect rect)
    {
        //distance between rect(of the ball) and circle(of the circularwall)
        Point circleDistance= new Point();
        circleDistance.x = Math.abs(circle._posX - rect.left);
        circleDistance.y = Math.abs(circle._posY - rect.top);

        //
        if (circleDistance.x > (rect._width()/2 + circle.getRadius())) { return false; }
        if (circleDistance.y > (rect._height()/2 + circle.getRadius())) { return false; }

        if (circleDistance.x <= (rect._width()/2)) { return true; }
        if (circleDistance.y <= (rect._width()/2)) { return true; }
        //using the Pythagorean theorem to know if is in the circle or not
        int cornerDistance_sq = (circleDistance.x - rect._width() / 2) ^ 2 + (circleDistance.y - rect._height() / 2) ^ 2;

        return (cornerDistance_sq <= (circle.getRadius()^2));
    }*/

}

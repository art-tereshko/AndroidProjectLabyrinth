package game.object.circle;


import android.graphics.Rect;

import game.GameObjectInteractive;
import game.Movable;

public class Bullet extends GameObjectInteractive implements Movable {

    private boolean _active;
    private float _angle;

    public Bullet(int radius, int x, int y, float angle) {
        super(radius, x, y);
        _active = true;
        _angle = angle;
    }

    public float get_angle() {
        return _angle;
    }

    public void set_angle(float _angle) {
        this._angle = _angle;
    }

    public boolean is_active() {
        return _active;
    }

    public void set_active(boolean _active) {
        this._active = _active;
    }

    @Override
    public void refreshDrawRectangle() {
        this._drawRectangle = new Rect(_posX, _posY, _posX + get_radius()*2, _posY + get_radius()*2);//left, tope, right, bottom
    }

    @Override
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

    public void nextPosition(float rapport) {//PointF center, float radius, float angle

        _posX -= speedX * Math.cos(Math.toRadians(_angle));
        _posY += speedY * Math.sin(Math.toRadians(_angle) * rapport);
        //        = new PointF((float) (center.x + radius * Math.cos(Math.toRadians(angle))),
          //      (float) (center.y + radius* Math.sin(Math.toRadians(angle))));
    }
}

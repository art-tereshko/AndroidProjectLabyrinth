package game.object.circle;


import android.graphics.Rect;

import game.Movable;

public class Bullet extends Ball implements Movable {

    private boolean _active;
    private int _rotate;

    public Bullet(int radius, int x, int y, int rotate) {
        super(radius, x, y);
        _active = true;
        _rotate = rotate;
    }

    public int get_rotate() {
        return _rotate;
    }

    public void set_rotate(int _rotate) {
        this._rotate = _rotate;
    }

    public boolean is_active() {
        return _active;
    }

    public void set_active(boolean _active) {
        this._active = _active;
    }
    @Override
    public void Move() {
        this._drawRectangle = new Rect(_posX, _posY, _posX + get_radius()*2, _posY + get_radius()*2);//left, tope, right, bottom
    }
}

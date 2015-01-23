package game.object.circle;


import game.object.rectangle.Cannon;
import game.shape.ShapeCircle;

public class Bullet  extends ShapeCircle{

    private Cannon _cannon;
    private boolean _active;

    public Bullet(int radius, int x, int y, float angle, Cannon cannon) {
        super(radius, x, y);
        _active = true;
        angleorientation = angle;
        _cannon = cannon;
    }

    public boolean is_active() {
        return _active;
    }

    public void set_active(boolean _active) {
        this._active = _active;
    }

    public Cannon get_cannon() {
        return _cannon;
    }
}
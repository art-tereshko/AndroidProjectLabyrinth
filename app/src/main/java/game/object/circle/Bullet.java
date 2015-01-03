package game.object.circle;


public class Bullet extends Ball {

    private boolean _active;
    private int _rotate;

    public Bullet(int radius, int x, int y, int rotate) {
        super(radius, x, y);
        _active = false;
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
}

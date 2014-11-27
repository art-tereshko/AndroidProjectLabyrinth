package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.List;

/**
 * Created by artem_000 on 11/11/2014.
 */
public class Cannon extends GameObject implements Collisionable {


    private List<Bullet> bullets;
    {
        bullets = null;
    }

    public Cannon(int height, int width) {
        super(height, width);
    }

    public Cannon(int coordinateX, int coordinateY, int height, int width) {
        super(coordinateX, coordinateY, height, width);
    }

    @Override
    public Rect getDrawRectangle() {
        return null;
    }

    @Override
    public void setTexture(Bitmap b) {

    }

    @Override
    public void Draw(Canvas canvas) {

    }

    @Override
    public boolean isIntersect(Rect r) {
        return  getDrawRectangle().intersects(r.left, r.top, r.right, r.bottom);
    }
}

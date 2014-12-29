package game.object.rectangle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.List;

import game.object.circle.Bullet;
import game.shape.ShapeRectangle;


public class Cannon extends ShapeRectangle {


    private List<Bullet> bullets;
    {
        bullets = null;
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
}

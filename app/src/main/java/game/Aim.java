package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by Artem Tereshko on 02/12/2014.
 * AndroidProject
 */
public class Aim extends GameObject implements Collisionable {
    Paint p = new Paint();
    public Aim(int coordinateX, int coordinateY, int height, int width) {
        super(coordinateX, coordinateY, height, width);
        p.setColor(Color.GREEN);
    }

    public Aim(int height, int width) {
        super(height, width);
        p.setColor(Color.GREEN);
    }

    @Override
    public boolean isIntersect(Rect r) {
        return  DrawRectangle.intersects(r.left, r.top,r.right, r.bottom);
    }

    @Override
    public Rect getDrawRectangle() {
        return DrawRectangle;
    }

    @Override
    public void setTexture(Bitmap t) {  this.texture = t;    }

    @Override
    public void Draw(Canvas canvas) {
        canvas.drawOval(new RectF(getDrawRectangle()),p);
    }
}

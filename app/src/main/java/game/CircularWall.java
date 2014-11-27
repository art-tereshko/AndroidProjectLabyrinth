package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by Artem Tereshko on 14/11/2014.
 * AndroidProject
 */
public class CircularWall extends GameObject implements Collisionable {

    private int R;

    Paint p;

    public CircularWall(int radius, int x, int y){
        super(x, y);
        if (radius<0)
            R =0;
        else
            R = radius;

        DrawRectangle = new Rect(x - radius, y -radius, x + radius, y+ radius);
        p=new Paint();
        p.setColor(Color.GREEN);

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
        canvas.drawOval(new RectF(getDrawRectangle()), p);
    }

    @Override
    public boolean isIntersect(Rect r) {
       return  getDrawRectangle().intersects(r.left, r.top, r.right, r.bottom);
    }
}

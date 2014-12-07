package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by artem_000 on 11/11/2014.
 */
public class Hole extends GameObject implements Collisionable {

    Paint p = new Paint();
    public Hole(int height, int width) {
        super(height, width);

        p.setColor(Color.DKGRAY);
    }

    public Hole(int posX, int posY, int height, int width) {
        super(posX, posY, height, width);

        p.setColor(Color.DKGRAY);
    }

    @Override
    public Rect getDrawRectangle() {
        return DrawRectangle;
    }

    @Override
    public void setTexture(Bitmap b) {
        this.texture = b;
    }

    @Override
    public void Draw(Canvas canvas) {

        if (texture!=null){
            canvas.drawBitmap(texture, null, getDrawRectangle(), null);
        }
        else
            canvas.drawOval(new RectF(getDrawRectangle()), p);
    }

    @Override
    public boolean isIntersect(Rect r) {
        return  getDrawRectangle().intersects(r.left, r.top, r.right, r.bottom);
    }
}

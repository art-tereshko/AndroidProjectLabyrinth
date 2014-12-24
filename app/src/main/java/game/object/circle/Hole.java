package game.object.circle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;

import game.shape.ShapeCircle;


public class Hole extends ShapeCircle {

    public Hole(int radius, int x, int y) {
        super(radius, x, y);

        p.setColor(Color.DKGRAY);
    }

    @Override
    public void Draw(Canvas canvas) {

        if (texture!=null){
            canvas.drawBitmap(texture, null, getDrawRectangle(), null);
        }
        else
            canvas.drawOval(new RectF(getDrawRectangle()), p);
    }
}

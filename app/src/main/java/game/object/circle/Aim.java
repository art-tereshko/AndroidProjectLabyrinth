package game.object.circle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;

import game.shape.ShapeCircle;

/**
 * Created by Artem Tereshko on 02/12/2014.
 * AndroidProject
 */
public class Aim extends ShapeCircle {

    public Aim(int radius, int x, int y) {
        super(radius, x, y);
        p.setColor(Color.GREEN);
    }

    @Override
    public void Draw(Canvas canvas) {
        canvas.drawOval(new RectF(getDrawRectangle()),p);
    }
}

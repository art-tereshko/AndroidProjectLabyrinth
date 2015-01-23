package game.object.circle;

import android.graphics.Color;

import game.shape.ShapeCircle;


public class Hole extends ShapeCircle {

    public Hole(int radius, int x, int y) {
        super(radius, x, y);

        paint.setColor(Color.DKGRAY);
    }
}

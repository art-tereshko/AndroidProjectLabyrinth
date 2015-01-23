package game.object.circle;

import android.graphics.Color;

import game.shape.ShapeCircle;


public class Aim extends ShapeCircle {

    public Aim(int radius, int x, int y) {
        super(radius, x, y);
        paint.setColor(Color.GREEN);
    }
}

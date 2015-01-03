package game.object.circle;

import android.graphics.Color;

import game.shape.ShapeCircle;

/**
 * Created by Artem Tereshko on 02/12/2014.
 * AndroidProject
 */
public class Aim extends ShapeCircle {

    public Aim(int radius, int x, int y) {
        super(radius, x, y);
        _p.setColor(Color.GREEN);
    }
}

package game.object.rectangle;

import android.graphics.Color;

import game.shape.ShapeRectangle;

public class Wall extends ShapeRectangle{

    public Wall(int x, int y, int height, int width) {
        super(x, y, height, width);

        this._p.setColor(Color.LTGRAY);
    }


}

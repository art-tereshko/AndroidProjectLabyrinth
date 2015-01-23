package game.object.rectangle;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import game.shape.ShapeRectangle;
import mesmaths.geometrie.base.Vecteur;

public class Wall extends ShapeRectangle{

    public Wall(int x, int y, int height, int width) {
        super(x, y, height, width);

        this.paint.setColor(Color.LTGRAY);
    }


}

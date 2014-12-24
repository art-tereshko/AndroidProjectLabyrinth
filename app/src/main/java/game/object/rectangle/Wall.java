package game.object.rectangle;

import android.graphics.Color;

import game.shape.ShapeRectangle;

public class Wall extends ShapeRectangle{

    //private int right;
    //private int bottom;


    public Wall(int x, int y, int height, int width) {
        super(x, y, height, width);

        //this.right = x + width;
        //this.bottom = y + height;

        this.p.setColor(Color.LTGRAY);
    }


}

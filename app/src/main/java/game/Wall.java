package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Artem Tereshko on 14/11/2014.
 * AndroidProject
 */
public class Wall extends GameObject implements  Collisionable{

    private int height;
    private int width;

    private int right;
    private int bottom;

    Paint p;

    public Wall(int x, int y, int width, int height) {
        super(x,y);

        this.posX = x;
        this.posY = y;
        this.height = height;
        this.width = width;

        this.right = x + width;
        this.bottom = y + height;

        this.DrawRectangle = new Rect(x,y, x+width, y+height);

        p = new Paint();
        p.setColor(Color.GREEN);
    }


    @Override
    public Rect getDrawRectangle() {
       return DrawRectangle;
    }

    @Override
    public void setTexture(Bitmap b) {
        b = null;
    }

    @Override
    public void Draw(Canvas canvas) {
        canvas.drawRect(getDrawRectangle(), p);
    }

    @Override
    public boolean isIntersect(Rect r) {
       return DrawRectangle.intersects( r.left, r.top, r.right, r.bottom);
    }
}

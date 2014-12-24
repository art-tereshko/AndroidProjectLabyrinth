package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;


public abstract class Drawable {

     protected Bitmap texture;

    abstract public Rect getDrawRectangle();
    abstract public void setTexture(Bitmap b);
    abstract public void Draw(Canvas canvas);



}

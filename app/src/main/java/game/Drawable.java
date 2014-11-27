package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by artem_000 on 11/11/2014.
 */
public abstract class Drawable {

     Bitmap texture;

    abstract public Rect getDrawRectangle();
    abstract public void setTexture(Bitmap b);
    abstract public void Draw(Canvas canvas);



}

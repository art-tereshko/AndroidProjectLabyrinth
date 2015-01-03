package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;


public abstract class Drawable {

     protected Bitmap _texture;

    abstract public Rect get_drawRectangle();
    abstract public void set_texture(Bitmap b);
    abstract public void Draw(Canvas canvas);



}

package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;


public abstract class Drawable {

     protected Bitmap _texture;

    public void set_texture(Bitmap b) {
        _texture = b;
    }

    public Bitmap get_texture() {
        return _texture;
    }

    abstract public Rect get_drawRectangle();
    abstract public void Draw(Canvas canvas);



}

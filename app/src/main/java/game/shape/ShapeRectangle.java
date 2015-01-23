package game.shape;

import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.Vector;

import game.AbstractGameObject;
import game.GameObject;

public abstract class ShapeRectangle extends GameObject {

    public ShapeRectangle(int coordinateX, int coordinateY, int height, int width) {
        super(coordinateX, coordinateY, height, width);
        this._drawRectangle = new Rect((int)_position.x, (int)_position.y, (int)_position.x + width,(int) _position.y +height );
    }

    @Override
    public void Draw(Canvas canvas) {
        if (_texture != null)
            canvas.drawBitmap(_texture, null, get_drawRectangle(), null);
        else
            canvas.drawRect(get_drawRectangle(), paint);
    }

    public void move(double coef) {
        //next position
        this._position.x += _speed.x ;
        this._position.y += _speed.y ;
        //draw the new rectangle
        this._drawRectangle = new Rect((int)this._position.x, (int)this._position.y, (int)this._position.x + _width, (int)this._position.y + _height);//left, tope, right, bottom
    }
}

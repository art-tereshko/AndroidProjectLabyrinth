package game.shape;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.Vector;

import game.AbstractGameObject;
import game.GameObject;
import mesmaths.geometrie.base.Vecteur;

public abstract class ShapeCircle extends GameObject {
//   # is the x and y point
//
//   -----*--*----
//   | *       * |
//   *           *
//   *     #     *
//   *           *
//   | *       * |
//   -----*--*----



    protected int _radius;
    private static double EPSILON = 1.0E-6;

    public ShapeCircle(int radius, int x, int y){
        super(x , y , radius*2, radius*2 );//x, y, _height, _width

        if (radius<0)
            _radius = 0;
        else
            _radius = radius;

        _drawRectangle = new Rect(x , y, x + radius*2, y + radius*2);//left, top, right, bottom
    }

    public int get_radius() {
        return _radius;
    }

    

    private double distance( int x1, int y1, int x2, int y2 )
    {
        //Return the distance between the two points
        return Math.sqrt( Math.pow( x2 - x1, 2 ) + Math.pow( y2 - y1, 2 ) );
    }

    @Override
    public void Draw(Canvas canvas) {
        if (_texture != null)
            canvas.drawBitmap(_texture, null, get_drawRectangle(), null);
        else
           canvas.drawOval(new RectF(get_drawRectangle()), paint);
    }

    public void move(double coef) {
        //next position
        this._position.x += _speed.x;
        this._position.y += _speed.y;
        //draw the new rectangle
        this._drawRectangle = new Rect((int)this._position.x, (int)this._position.y, (int)this._position.x + get_radius()*2, (int)this._position.y + get_radius()*2);//left, tope, right, bottom
    }
}

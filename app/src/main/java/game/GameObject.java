package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;


public abstract class GameObject extends Drawable implements ICollisionable{

    protected int _posX = 0;
    protected int _posY = 0;

    protected int _height;
    protected int _width;
    
    protected Rect _drawRectangle;
    protected Paint _p;

    public GameObject(int height, int width){
        this._posX = this._posY = 0;

        this._height = height;
        this._width = width;

        this._drawRectangle = new Rect(_posX, _posY, _posX + width, _posY +height );
        this._p = new Paint();
    }

    public GameObject(int coordinateX, int coordinateY, int height, int width){
        this._posX = coordinateX;
        this._posY = coordinateY;

        this._height = height;
        this._width = width;

        this._drawRectangle = new Rect(_posX, _posY, _posX + width, _posY +height );
        this._p = new Paint();
    }

    @Override
    public Rect get_drawRectangle() {
        return _drawRectangle;
    }

    public void set_drawRectangle(Rect _drawRectangle) {
        this._drawRectangle = _drawRectangle;
    }

    public int get_posX() {
        return _posX;
    }

    public void set_posX(int _posX) {
        this._posX = _posX;
    }

    public int get_posY() {
        return _posY;
    }

    public void set_posY(int _posY) {
        this._posY = _posY;
    }

    public int get_height() {
        return _height;
    }

    public void set_height(int _height) {
        this._height = _height;
    }

    public int get_width() {
        return _width;
    }

    public void set_width(int _width) {
        this._width = _width;
    }



    @Override
    public void set_texture(Bitmap b) {
        _texture = b;
    }
}

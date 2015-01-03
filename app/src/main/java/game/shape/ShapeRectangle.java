package game.shape;

import android.graphics.Canvas;

import game.GameObject;

public class ShapeRectangle extends GameObject {

    public ShapeRectangle(int coordinateX, int coordinateY, int height, int width) {
        super(coordinateX, coordinateY, height, width);
    }



    @Override
    public void Draw(Canvas canvas) {
        if (_texture != null)
            canvas.drawBitmap(_texture, null, get_drawRectangle(), null);
        else
            canvas.drawRect(get_drawRectangle(), _p);
    }

    @Override
    public boolean isIntersect(ShapeRectangle shapeRectangle) {
        return this._drawRectangle.intersects(shapeRectangle.get_drawRectangle().left, shapeRectangle.get_drawRectangle().top, shapeRectangle.get_drawRectangle().right, shapeRectangle.get_drawRectangle().bottom);
    }

    @Override
    public boolean isIntersect(ShapeCircle shapeCircle) {
        return shapeCircle.isIntersect(this);
    }
}

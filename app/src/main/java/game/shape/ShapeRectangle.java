package game.shape;

import android.graphics.Canvas;
import android.graphics.Rect;

import game.GameObjectCollisionable;

public class ShapeRectangle extends GameObjectCollisionable {

    public ShapeRectangle(int coordinateX, int coordinateY, int height, int width) {
        super(coordinateX, coordinateY, height, width);
    }



    @Override
    public void Draw(Canvas canvas) {
        canvas.drawRect(getDrawRectangle(), p);
    }

    @Override
    public boolean isIntersect(ShapeRectangle shapeRectangle) {
        return this.drawRectangle.intersects(shapeRectangle.getDrawRectangle().left, shapeRectangle.getDrawRectangle().top, shapeRectangle.getDrawRectangle().right, shapeRectangle.getDrawRectangle().bottom);
    }

    @Override
    public boolean isIntersect(ShapeCircle shapeCircle) {
        return shapeCircle.isIntersect(this);
    }
}

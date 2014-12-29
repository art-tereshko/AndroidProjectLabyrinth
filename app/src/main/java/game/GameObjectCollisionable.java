package game;

import android.graphics.Canvas;

import game.shape.ShapeCircle;
import game.shape.ShapeRectangle;


public abstract class GameObjectCollisionable extends GameObject implements ICollisionable {
    public GameObjectCollisionable(int height, int width) {
        super(height, width);
    }

    public GameObjectCollisionable(int coordinateX, int coordinateY, int height, int width) {
        super(coordinateX, coordinateY, height, width);
    }

    //@Override
    //maniere de calculer les intersections(défini par default comme un Rectangle)
    //public abstract boolean isIntersect(ShapeRectangle shapeRectangle);
        //return  false;//this.drawRectangle.intersects(shapeRectangle.getDrawRectangle().left, shapeRectangle.getDrawRectangle().top, shapeRectangle.getDrawRectangle().right, shapeRectangle.getDrawRectangle().bottom);

    //@Override
    //public abstract boolean isIntersect(ShapeCircle shapeCircle);

    //@Override
    //manière de dessiner sera redéfini dans les classes filles
    //public abstract void Draw(Canvas canvas);
}

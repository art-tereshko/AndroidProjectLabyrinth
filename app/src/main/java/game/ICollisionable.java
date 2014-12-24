package game;

import game.shape.ShapeCircle;
import game.shape.ShapeRectangle;

public interface ICollisionable {

    boolean isIntersect(ShapeCircle shapeCircle);
    boolean isIntersect(ShapeRectangle shapeRectangle);


}

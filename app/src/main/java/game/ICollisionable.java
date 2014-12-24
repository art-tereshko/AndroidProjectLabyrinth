package game;

import game.shape.ShapeCircle;
import game.shape.ShapeRectangle;

public interface ICollisionable {

    boolean isIntersect(ShapeCircle circle);
    boolean isIntersect(ShapeRectangle shapeRectangle);


}

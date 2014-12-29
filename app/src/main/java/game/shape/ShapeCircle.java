package game.shape;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.util.Log;

import game.GameObject;
import game.GameObjectCollisionable;
import game.tools.Vecteur;

public abstract class ShapeCircle extends GameObjectCollisionable {
//   # is the x and y point
//
//   -----*--*----
//   | *       * |
//   *           *
//   *     #     *
//   *           *
//   | *       * |
//   -----*--*----



    private int _radius;
    private static double EPSILON = 1.0E-6;

    public ShapeCircle(int radius, int x, int y){
        super(x - radius, y -radius, y+ radius, x + radius );//x, y, height, width

        if (radius<0)
            _radius =0;
        else
            _radius = radius;

        this.drawRectangle = new Rect(x - radius, y - radius, x + radius, y+ radius);//left, top, right, bottom
    }

    public int get_radius() {
        return _radius;
    }

    @Override
    public boolean isIntersect(ShapeCircle shapeCircle) {
        int dx = this.posX - shapeCircle.getPosX();
        int dy = this.posY - shapeCircle.getPosY();
        int dist = this._radius + shapeCircle.get_radius();

        //Log.i("DEBUG", "dx="+dx+" dy="+dy+" dist="+dist+"   x1="+posX+" y1="+posY+" radius1="+_radius+"       x2="+shapeCircle.posX+" y2="+shapeCircle.posY+" radius2="+shapeCircle.get_radius());
        return (dx * dx + dy * dy < dist * dist);

    }

    @Override
    public boolean isIntersect(ShapeRectangle shapeRectangle) {
        //this.drawRectangle.intersects(shapeRectangle.getDrawRectangle().left, shapeRectangle.getDrawRectangle().top, shapeRectangle.getDrawRectangle().right, shapeRectangle.getDrawRectangle().bottom);
        //distance between rect(of the ball) and circle(of the circularwall)
        Point circleDistance= new Point();
        circleDistance.x = Math.abs(this.posX - shapeRectangle.getDrawRectangle().left);
        circleDistance.y = Math.abs(this.posY - shapeRectangle.getDrawRectangle().top);

        //
        if (circleDistance.x > (shapeRectangle.getWidth()/2 + this._radius)) { return false; }
        if (circleDistance.y > (shapeRectangle.getHeight()/2 + this._radius)) { return false; }

        if (circleDistance.x <= (shapeRectangle.getHeight()/2)) { return true; }
        if (circleDistance.y <= (shapeRectangle.getWidth()/2)) { return true; }
        //using the Pythagorean theorem to know if is in the circle or not
        int cornerDistance_sq = (circleDistance.x - shapeRectangle.getWidth()/ 2) ^ 2 + (circleDistance.y - shapeRectangle.getHeight()/ 2) ^ 2;

        return (cornerDistance_sq <= (this._radius^2));
    }
}

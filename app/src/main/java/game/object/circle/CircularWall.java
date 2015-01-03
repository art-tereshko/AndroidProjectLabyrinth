package game.object.circle;

import android.graphics.Color;

import game.shape.ShapeCircle;


public class CircularWall extends ShapeCircle {

    public CircularWall(int radius, int x, int y){
        super(radius, x,y);

        _p.setColor(Color.LTGRAY);
    }

    /*@Override
    public boolean isIntersect(Rect rect) {
        return game.tools.
       //return  get_drawRectangle().intersects(r.left, r.top, r.right, r.bottom);



        //distance between rect(of the other object) and circle(of the circularwall)
        Point circleDistance= new Point();
        circleDistance.x = Math.abs(this._posX- rect.left);
        circleDistance.y = Math.abs(this._posY - rect.top);

        //
        if (circleDistance.x > (rect._width()/2 + this.getRadius())) { return false; }
        if (circleDistance.y > (rect._height()/2 + this.getRadius())) { return false; }

        if (circleDistance.x <= (rect._width()/2)) { return true; }
        if (circleDistance.y <= (rect._width()/2)) { return true; }
        //using the Pythagorean theorem to know if is in the circle or not
        int cornerDistance_sq = (circleDistance.x - rect._width() / 2) ^ 2 + (circleDistance.y - rect._height() / 2) ^ 2;

        return (cornerDistance_sq <= (this.getRadius()^2));
    }*/
}

package game.object.circle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;

import game.shape.ShapeCircle;


public class CircularWall extends ShapeCircle {

    public CircularWall(int radius, int x, int y){
        super(radius, x,y);

        p.setColor(Color.LTGRAY);
    }

    @Override
    public void Draw(Canvas canvas) {
        canvas.drawOval(new RectF(getDrawRectangle()), p);
    }

    /*@Override
    public boolean isIntersect(Rect rect) {
        return game.tools.
       //return  getDrawRectangle().intersects(r.left, r.top, r.right, r.bottom);



        //distance between rect(of the other object) and circle(of the circularwall)
        Point circleDistance= new Point();
        circleDistance.x = Math.abs(this.posX- rect.left);
        circleDistance.y = Math.abs(this.posY - rect.top);

        //
        if (circleDistance.x > (rect.width()/2 + this.getRadius())) { return false; }
        if (circleDistance.y > (rect.height()/2 + this.getRadius())) { return false; }

        if (circleDistance.x <= (rect.width()/2)) { return true; }
        if (circleDistance.y <= (rect.width()/2)) { return true; }
        //using the Pythagorean theorem to know if is in the circle or not
        int cornerDistance_sq = (circleDistance.x - rect.width() / 2) ^ 2 + (circleDistance.y - rect.height() / 2) ^ 2;

        return (cornerDistance_sq <= (this.getRadius()^2));
    }*/
}

package game.shape;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import game.GameObject;

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
            _radius =0;
        else
            _radius = radius;

        this._drawRectangle = new Rect(x, y , x + radius*2, y+ radius*2);//left, top, right, bottom
    }

    public int get_radius() {
        return _radius;
    }

    @Override
    public boolean isIntersect(ShapeCircle shapeCircle) {

        //If the distance between the centers of the circles is less than the sum of their radii
        if( distance( shapeCircle.get_drawRectangle().centerX(),shapeCircle.get_drawRectangle().centerY() , this.get_drawRectangle().centerX(), this.get_drawRectangle().centerY()) < shapeCircle.get_radius() + this.get_radius() )
        {

            //The circles have collided
            return true;
        }

        //If not
        return false;


        /*int dx = this._posX - shapeCircle.get_posX();
        int dy = this._posY - shapeCircle.get_posY();
        int dist = this._radius + shapeCircle.get_radius();

        //Log.i("DEBUG", "dx="+dx+" dy="+dy+" dist="+dist+"   x1="+_posX+" y1="+_posY+" radius1="+_radius+"       x2="+shapeCircle._posX+" y2="+shapeCircle._posY+" radius2="+shapeCircle.get_radius());
        return (dx * dx + dy * dy < dist * dist);*/

    }

    @Override
    public boolean isIntersect(ShapeRectangle shapeRectangle) {

         return shapeRectangle.get_drawRectangle().intersects(this.get_posX(),this.get_posY(),this.get_posX()+ this.get_radius()*2,this.get_posY()+ this.get_radius()*2  );

        //this._drawRectangle.intersects(shapeRectangle.get_drawRectangle().left, shapeRectangle.get_drawRectangle().top, shapeRectangle.get_drawRectangle().right, shapeRectangle.get_drawRectangle().bottom);
        //distance between rect(of the ball) and circle(of the circularwall)
        /*Point circleDistance= new Point();
        circleDistance.x = Math.abs(this._posX - shapeRectangle.get_drawRectangle().left);
        circleDistance.y = Math.abs(this._posY - shapeRectangle.get_drawRectangle().top);

        //
        if (circleDistance.x > (shapeRectangle.get_width()/2 + this._radius)) { return false; }
        if (circleDistance.y > (shapeRectangle.get_height()/2 + this._radius)) { return false; }

        if (circleDistance.x <= (shapeRectangle.get_height()/2)) { return true; }
        if (circleDistance.y <= (shapeRectangle.get_width()/2)) { return true; }
        //using the Pythagorean theorem to know if is in the circle or not
        int cornerDistance_sq = (circleDistance.x - shapeRectangle.get_width()/ 2) ^ 2 + (circleDistance.y - shapeRectangle.get_height()/ 2) ^ 2;

        return (cornerDistance_sq <= (this._radius^2));*/
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
           canvas.drawOval(new RectF(get_drawRectangle()), _p);
    }
}

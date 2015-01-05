package game.object.rectangle;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import game.GameObject;
import game.Level;
import game.object.circle.Bullet;
import game.shape.ShapeRectangle;

//http://furiouspixels.blogspot.fr/
public class Cannon extends ShapeRectangle {
    private int _orientation;
    private Bullet _bullet;
    private ArrayList<GameObject> _listGameObject;


    public Cannon(int coordinateX, int coordinateY, int height, int width, int orientation, ArrayList<GameObject> gameObjectArrayList) {
        super(coordinateX, coordinateY, height, width);
        _orientation = orientation;
        _listGameObject = gameObjectArrayList;
        ShootBullet();
        //orienté vers le haut
        //if(orientation >= 0 && orientation <= 180 || orientation >= 270 && orientation <= 360){

        //}
    }


    @Override
    public void Draw(Canvas canvas) {
        canvas.save();
        canvas.rotate(_orientation, _posX+_width/2, _posY+_height/2);

        if (_texture != null)
            canvas.drawBitmap(_texture, null, get_drawRectangle(), null);
        else
            canvas.drawRect(get_drawRectangle(), _p);

        if(_bullet.is_active())
            _bullet.Draw(canvas);
        else
            ShootBullet();

        canvas.restore();
    }

    public void ShootBullet(){

        if(_bullet == null || !_bullet.is_active()) {//On lance une nouvelle Bullet


            for (int i = 0; i<_listGameObject.size(); i++) {
                GameObject obj = _listGameObject.get(i);

                if (obj.equals(_bullet) ){
                    _listGameObject.remove(obj);
                    i--;
                    int startBulletX = _posX + _width/2;
                    int startBulletY = _posY;
                    _bullet = new Bullet(_height/6, startBulletX, startBulletY, _orientation);
                    _listGameObject.add(_bullet);
                }

            }

        }
    }

}

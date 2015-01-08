package game.object.rectangle;

import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import game.GameObject;
import game.object.circle.Bullet;
import game.shape.ShapeRectangle;

//http://furiouspixels.blogspot.fr/
public class Cannon extends ShapeRectangle {
    private float _orientation;
    private Bullet _bullet;
    private List<GameObject> _listGameObject;
    private int _targetX, _targetY;


    public Cannon(int coordinateX, int coordinateY, int height, int width, int targetX, int targetY, ArrayList<GameObject> gameObjectArrayList) {
        super(coordinateX, coordinateY, height, width);
        _targetX = targetX;
        _targetY = targetY;
        //calcul de l'angle d'orientation pour etre vers destination

        refreshRotation();
        if(_orientation < 0){
            _orientation += 360;
        }
        if(_orientation > 360){
            _orientation -= 360;
        }

        _listGameObject = gameObjectArrayList;
        ShootBullet();
        //orienté vers le haut
        //if(orientation >= 0 && orientation <= 180 || orientation >= 270 && orientation <= 360){

        //}
    }

    public int get_targetX() {
        return _targetX;
    }

    public void set_targetX(int _targetX) {
        this._targetX = _targetX;
    }

    public int get_targetY() {
        return _targetY;
    }

    public void set_targetY(int _targetY) {
        this._targetY = _targetY;
    }

    @Override
    public void Draw(Canvas canvas) {
        refreshRotation();
        canvas.save();
        canvas.rotate(_orientation, _posX+_width/2, _posY+_height/2);

        if (_texture != null)
            canvas.drawBitmap(_texture, null, get_drawRectangle(), null);
        else
            canvas.drawRect(get_drawRectangle(), _p);

        if(!_bullet.is_active())
            ShootBullet();//_bullet.Draw(canvas);
       // else


        canvas.restore();
    }

    private void refreshRotation()
    {
        double theta = Math.atan2(_targetY - _posY, _targetX - _posX);

        theta += Math.PI/2.0;
        _orientation = (float)Math.toDegrees(theta);
        if (_orientation < 0) {
            _orientation += 360;
        }
    }

    public void ShootBullet(){
        int startBulletX = _posX + _width/2;
        int startBulletY = _posY;

        if(_bullet == null) {//aucune Bullet existe, il faut juste en créé une
            Log.i("DEBUG", Integer.toString(startBulletX));
            _bullet = new Bullet(_height/6, startBulletX, startBulletY, _orientation);
            _listGameObject.add(_bullet);
        }
        else
            if(!_bullet.is_active()) {//On lance une nouvelle Bullet à la place de l'ancienne
                for (int i = 0; i<_listGameObject.size(); i++) {
                    GameObject obj = _listGameObject.get(i);

                    if (obj.equals(_bullet) ){
                        //_listGameObject.remove(obj);
                        _bullet = new Bullet(_height/6, startBulletX, startBulletY, _orientation);
                        _bullet.set_texture(obj.get_texture());
                        _listGameObject.set(i, _bullet);
                        //new Bullet(_height/6, startBulletX, startBulletY, _orientation);
                        //_listGameObject.add(_bullet);
                    }

                }

            }

    }

}


/*******************************************************
Enlever soit de la liste du niveau soit faire dans canon
*/
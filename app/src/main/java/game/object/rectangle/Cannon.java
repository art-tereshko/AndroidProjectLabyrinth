package game.object.rectangle;
import android.graphics.Canvas;

import java.util.Vector;

import game.AbstractGameObject;
import game.atitude.collision.ColDestructBullet;
import game.atitude.mouvement.MvtUniforme;
import game.object.circle.Bullet;
import game.shape.ShapeRectangle;

public class Cannon extends ShapeRectangle {
    private AbstractGameObject _bullet;
    private Vector<AbstractGameObject> _listGameObject;
    private int _targetX, _targetY;
    private int _wolrdWidth, _worldHeight;


    public Cannon(int coordinateX, int coordinateY, int height, int width, int targetX, int targetY, Vector<AbstractGameObject> gameObjectArrayList, int worldWidth, int worldHeight) {
        super(coordinateX, coordinateY, height, width);
        _targetX = targetX;
        _targetY = targetY;
        //calcul de l'angle d'orientation pour etre vers destination
        refreshRotation();
        _listGameObject = gameObjectArrayList;
        _wolrdWidth = worldWidth;
        _worldHeight = worldHeight;

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

    public void set_bullet(AbstractGameObject _bullet) {
        this._bullet = _bullet;
    }
    @Override
    public void Draw(Canvas canvas) {
        refreshRotation();
        canvas.save();
        canvas.rotate(angleorientation, (float)(_position.x+_width/2), (float)(_position.y+_height/2));

        if (_texture != null)
            canvas.drawBitmap(_texture, null, get_drawRectangle(), null);
        else
            canvas.drawRect(get_drawRectangle(), paint);

        canvas.restore();
    }

    private void refreshRotation()
    {
        double theta = Math.atan2(_targetY - _position.y, _targetX - _position.x);

        theta += Math.PI/2.0;
        angleorientation = (float)Math.toDegrees(theta);
    }

    public void ShootBullet(){
        double startBulletX = _position.x + _width/2;
        double startBulletY = _position.y;
        if(_bullet == null ) {//aucune Bullet existe, il faut en créer une
            _bullet = new Bullet(_height/6, (int)startBulletX, (int)startBulletY, angleorientation, this);
            _bullet = new MvtUniforme(_bullet, _wolrdWidth/(double)_worldHeight);
            _bullet = new ColDestructBullet(_bullet);
            _listGameObject.add(_bullet);
        }
        else{
            if( !((Bullet)_bullet.getAbstractGameObject()).is_active() ){
                //recherche l'emplacement dans la liste
                int num = 0;
                while(num < _listGameObject.size() && !_listGameObject.get(num).getAbstractGameObject().equals(_bullet)){
                        num ++;
                }

                AbstractGameObject copie =_bullet;//besoin de faire une copie pour ciper ensuite la texture

                _bullet = new Bullet(_height/6, (int)startBulletX, (int)startBulletY, angleorientation, this);
                _bullet = new MvtUniforme(_bullet, _wolrdWidth/(double)_worldHeight);
                _bullet = new ColDestructBullet(_bullet);
                _bullet.set_texture(copie.get_texture());
                _listGameObject.set(num, _bullet);
            }
        }
    }
}
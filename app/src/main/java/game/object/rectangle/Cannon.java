package game.object.rectangle;

import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;

import game.object.circle.Bullet;
import game.shape.ShapeRectangle;

//http://furiouspixels.blogspot.fr/
public class Cannon extends ShapeRectangle {
    private int _orientation;
    private int _sizeBullet;
    private int _munition;
    private ArrayList<Bullet> _listBullet=  new ArrayList<Bullet>() ;


    public Cannon(int coordinateX, int coordinateY, int height, int width, int orientation, int munition) {
        super(coordinateX, coordinateY, height, width);
        _orientation = orientation;
        _munition = munition;
        _listBullet = new ArrayList<Bullet>();

        int startBulletX = _posX + _width/2;
        int startBulletY = _posY;
        for(int i = 0; i < _munition;i++){
            _listBullet.add(new Bullet(height/2, startBulletX, startBulletY, _orientation));
        }
        //orienté vers le haut
        //if(orientation >= 0 && orientation <= 180 || orientation >= 270 && orientation <= 360){

        //}
    }
    public List<Bullet> get_listBullet() {
        return _listBullet;
    }

    @Override
    public void Draw(Canvas canvas) {
        canvas.save();
        canvas.rotate(_orientation, _posX+_width/2, _posY+_height/2);

        if (_texture != null)
            canvas.drawBitmap(_texture, null, get_drawRectangle(), null);
        else
            canvas.drawRect(get_drawRectangle(), _p);

        for(int i = 0; i < _munition;i++){
            _listBullet.get(i).Draw(canvas);
        }

        canvas.restore();
    }

    public void Shoot(){
        //On lance la prochaine Bullet non active
        int i = 0;
        while(i< _listBullet.size()){
            if(_listBullet.get(i).is_active())
                i++;
            else {
                _listBullet.get(i).Move();
                break;
            }
        }

    }

}

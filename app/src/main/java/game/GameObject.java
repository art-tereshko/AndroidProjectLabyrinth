package game;

import android.graphics.Rect;

/**
 * Created by artem_000 on 11/11/2014.
 */
public abstract class GameObject extends Drawable {

    protected int posX = 0;
    protected int posY = 0;

    protected int height;
    protected int width;
    
    protected Rect DrawRectangle;

    public GameObject(int height, int width){
        posX = posY = 0;
        this.height = height;
        this.width = width;
        DrawRectangle = new Rect(posX, posY,posX+ width, posY+height );
    }

    public GameObject(int coordinateX, int coordinateY, int height, int width){
        posX = coordinateX;
        posY = coordinateY;
        this.height = height;
        this.width = width;
        DrawRectangle = new Rect(posX, posY,posX+ width, posY+height );
    }

}

package game;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;


public abstract class GameObject extends Drawable {

    protected int posX = 0;
    protected int posY = 0;

    protected int height;
    protected int width;
    
    protected Rect drawRectangle;
    protected Paint p;

    public GameObject(int height, int width){
        this.posX = this.posY = 0;

        this.height = height;
        this.width = width;

        this.drawRectangle = new Rect(posX, posY, posX+ width, posY+height );
        this.p = new Paint();
    }

    public GameObject(int coordinateX, int coordinateY, int height, int width){
        this.posX = coordinateX;
        this.posY = coordinateY;

        this.height = height;
        this.width = width;

        this.drawRectangle = new Rect(posX, posY, posX+ width, posY+height );
        this.p = new Paint();
    }

    @Override
    public Rect getDrawRectangle() {
        return drawRectangle;
    }

    public void setDrawRectangle(Rect drawRectangle) {
        this.drawRectangle = drawRectangle;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }



    @Override
    public void setTexture(Bitmap b) {
        texture = b;
    }
}

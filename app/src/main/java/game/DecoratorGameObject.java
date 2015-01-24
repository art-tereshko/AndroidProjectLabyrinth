package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public abstract class DecoratorGameObject extends AbstractGameObject {

    protected AbstractGameObject _GameObjectDecorated; // la bille qui doit être décorée. c'est-à-dire l'objet dont on va compléter un traitement


    protected static double MAX_VITESSE = 15.0;//MvtSensor
    protected static double MIN_ACCEL = 0.05;//MvtSensor
    protected static double FREINS = 0.2;//MvtVitesseRalentieSiPasAcceleration
    protected static double VITESSE_UNFIFORME = 4.0;//MvtUniforme
    protected static double MIN_VITESSE = 3.0;//ColObjectAmorti


    public DecoratorGameObject(AbstractGameObject gameObjectDecorated) {
        this._GameObjectDecorated = gameObjectDecorated;
    }

    public Vecteur get_position() {
        return this._GameObjectDecorated.get_position();
    }

    public void set_Position(Vecteur position){this._GameObjectDecorated.set_Position(position);}

    public Vecteur get_speed() {
        return this._GameObjectDecorated.get_speed();
    }

    public void setSpeed(Vecteur speed){
        this._GameObjectDecorated.setSpeed(speed);
    }

    public Paint get_paint() {
        return this._GameObjectDecorated.get_paint();
    }

    public Vecteur getAcceleration() {
        return this._GameObjectDecorated.getAcceleration();
    }

    public void setAcceleration(Vecteur acceleration){
        this._GameObjectDecorated.setAcceleration(acceleration);
    }

    public double getMasse() {
        return this._GameObjectDecorated.getMasse();
    }

    public int getClef() {
        return this._GameObjectDecorated.getClef();
    }

    public double getRepulsion() {
        return this._GameObjectDecorated.getRepulsion();
    }

    public void set_repulsion(double repulsion) {
        this._GameObjectDecorated.set_repulsion(repulsion);
    }

    public int getMaxSpeed() {
        return this._GameObjectDecorated.getMaxSpeed();
    }

    public Bitmap get_texture() {
        return this._GameObjectDecorated.get_texture();
    }

    public void set_texture(Bitmap texture){this._GameObjectDecorated.set_texture(texture);}

    public void set_player(MediaPlayer player){ this._GameObjectDecorated.set_player(player);}
    public MediaPlayer get_player(){ return this._GameObjectDecorated.get_player();}

    public Rect get_drawRectangle() {
        return this._GameObjectDecorated.get_drawRectangle();
    }

    public int get_height() {
        return this._GameObjectDecorated.get_height();
    }

    public int get_width() {
        return this._GameObjectDecorated.get_width();
    }

    public float getAngleorientation() {
        return this._GameObjectDecorated.getAngleorientation();
    }

    public void setAngleorientation(float angleorientation) {
        this._GameObjectDecorated.setAngleorientation(angleorientation);
    }

    public void Draw(Canvas canvas) {
        this._GameObjectDecorated.Draw(canvas);
    }

    /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
    @Override
    public String toString() {
        return this._GameObjectDecorated.toString();
    }

    @Override
    public void move(double coef) {
        this._GameObjectDecorated.move(coef);
    }

    /**
     * A ce niveau on ne sait ni gérer les collisions ni la gestion de l'Accélération
     * cela dépendra des caractéristiques associées à l'objet décoré
     */

    public abstract void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur);

    public abstract void collisionGameObject(AbstractGameObject gameObject);

    public abstract void gestionAccélération(Vector<AbstractGameObject> abstractGameObjectVector);

    public abstract void gestionMouvement(Vecteur mouvement);

    public AbstractGameObject getAbstractGameObject() {
        return this._GameObjectDecorated.getAbstractGameObject();
    }

}
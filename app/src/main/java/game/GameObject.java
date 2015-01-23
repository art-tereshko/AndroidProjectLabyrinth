package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Vector;

import game.shape.ShapeCircle;
import game.shape.ShapeRectangle;
import mesmaths.geometrie.base.Vecteur;


public class GameObject extends AbstractGameObject{

    protected Vecteur _position;   // position de l'objet
    protected int _height;
    protected int _width;
    protected Bitmap _texture;
    protected Vecteur _speed = new Vecteur(0.0, 0.0);;
    protected Rect _drawRectangle;
    protected Paint paint;
    protected Vecteur acceleration;
    protected double masse;
    protected float angleorientation;
    protected int clef;                // identifiant unique de cet objet

    protected double repulsion = 1.1;
    protected int maxSpeed = 15;

    private static int prochaineClef = 0;

    protected GameObject() {
    }

    public GameObject(int coordinateX, int coordinateY, int height, int width){
        this._position = new Vecteur(coordinateX, coordinateY);
        this._height = height;
        this._width = width;
        this.angleorientation = 0;
        if (angleorientation < 0) {
            angleorientation += 360;
        }
        if(angleorientation > 360){
            angleorientation -= 360;
        }

        this.paint = new Paint();

        this.clef = GameObject.prochaineClef ++;
    }


    public Vecteur get_position() {
        return _position;
    }

    public void set_Position(Vecteur position){this._position = position;}

    public Vecteur get_speed() {
        return _speed;
    }

    public void setSpeed(Vecteur speed){
        this._speed= speed;
    }

    public Paint get_paint() {
        return paint;
    }

    public Vecteur getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vecteur acceleration){
        this.acceleration = acceleration;
    }

    public double getMasse() {
        return masse;
    }

    public int getClef() {
        return clef;
    }

    public double getRepulsion() {
        return repulsion;
    }

    public void set_repulsion(double repulsion) {
        this.repulsion = repulsion;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public Bitmap get_texture() {
        return _texture;
    }

    public void set_texture(Bitmap _texture) {
        this._texture = _texture;
    }

    public Rect get_drawRectangle() {
        return _drawRectangle;
    }

    public int get_height() {
        return _height;
    }

    public int get_width() {
        return _width;
    }

    public float getAngleorientation() {
        return angleorientation;
    }

    public void setAngleorientation(float angleorientation) {
        this.angleorientation = angleorientation;
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
        // Volontairement on ne fait rien, cela sera géré par les décorateurs
    }

    @Override
    public void collisionGameObject(AbstractGameObject gameObject) {
        // Volontairement on ne fait rien, cela sera géré par les décorateurs
    }

    @Override
    public void gestionAccélération(Vector<AbstractGameObject> abstractGameObjectVector) {
        // Volontairement on ne fait rien, cela sera géré plus tard
    }

    @Override
    public void gestionMouvement(Vecteur mouvement){
        // Volontairement on ne fait rien, cela sera géré plus tard
    }

    @Override
    public void Draw(Canvas canvas) {
        // Volontairement on ne fait rien, cela sera géré plus tard
    }

    @Override
    public void move(double coef){
        // Volontairement on ne fait rien, cela sera géré plus tard
    }

}
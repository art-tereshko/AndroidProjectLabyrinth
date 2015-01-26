package game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public abstract class AbstractGameObject{

    public abstract Vecteur get_position();

    public abstract void set_Position(Vecteur position);

    public abstract Vecteur get_speed();

    public abstract void setSpeed(Vecteur speed);

    public abstract Paint get_paint();

    public abstract Vecteur getAcceleration();

    public abstract void setAcceleration(Vecteur acceleration);

    public abstract double getMasse();

    public abstract void setMasse(double masse);

    public abstract int getClef();

    public abstract double getRepulsion();

    public abstract void set_repulsion(double repulsion);

    public abstract int getMaxSpeed();

    public abstract Bitmap get_texture();

    public abstract void set_texture(Bitmap texture);

    public abstract void set_player(MediaPlayer player);

    public abstract MediaPlayer get_player();

    public abstract Rect get_drawRectangle();

    public abstract int get_height();

    public abstract int get_width();

    public abstract float getAngleorientation();

    public abstract void setAngleorientation(float angleorientation);

    /**
     * gestion de l'éventuelle collision de l'objet (this) avec le contour rectangulaire de l'écran défini par (abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur)
     *
     * détecte si il y a collision et le cas échéant met à jour position et vitesse
     *
     * La nature du comportement de la bille en réponse à cette collision est définie dans les classes dérivées
     * */

    public abstract void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur);

    //Manière dont est gérée la collision avec un autre object
    public abstract void collisionGameObject(AbstractGameObject gameObject);

    /**
     * calcul (c-à-d mise à jour) éventuel  du vecteur accélération.
     * objets est la liste de tous les objets du niveau
     * Cette méthode peut avoir besoin de "objets" si this subit des actions des autres objets
     * La nature du calcul du vecteur accélération de l'objet est définie dans les classes dérivées
     * A ce niveau le vecteur accélération est mis à zéro (c'est à dire pas d'accélération)
     * */

    public abstract void gestionAccélération(Vector<AbstractGameObject> abstractGameObjectVector);

    public abstract void gestionMouvement(Vecteur mouvement);

    //On ne sait pas encore, à voir dans les classes dérivées
    public abstract void Draw(Canvas canvas);
    public abstract void move(double coef);

    public AbstractGameObject getAbstractGameObject()
    {
        return this;
    }
}

package game.atitude.collision;

import android.graphics.Canvas;

import game.AbstractGameObject;
import game.GameObject;
import game.shape.ShapeCircle;
import game.shape.ShapeRectangle;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

public class ColRebondBord extends Collision {

    public ColRebondBord(AbstractGameObject gameObjectDecorated)
    {
        super(gameObjectDecorated);
    }

    @Override
    public void collisionGameObject(AbstractGameObject gameObject) {

    }

    @Override
    public void Draw(Canvas canvas) {

    }
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur)
    {
        this._GameObjectDecorated.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);

        if(_GameObjectDecorated instanceof ShapeCircle) {
            //HEIGHT is the RADIUS
            Collisions.collisionBilleContourAvecRebond(this.get_position(), (double)this.get_height(), this.get_speed(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
        }
        //this.bruitage(Bille.bruitchoc);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Collision Rebond Bord, "+ this._GameObjectDecorated.toString();
    }
}

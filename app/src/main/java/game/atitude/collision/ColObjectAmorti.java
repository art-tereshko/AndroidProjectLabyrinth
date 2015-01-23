package game.atitude.collision;


import game.AbstractGameObject;
import game.object.circle.Aim;
import game.object.circle.Hole;
import mesmaths.geometrie.base.Vecteur;

public class ColObjectAmorti extends Collision {


    public ColObjectAmorti(AbstractGameObject abstractGameObject) {
        super(abstractGameObject);
    }

    @Override
    public void collisionGameObject(AbstractGameObject abstractGameObject) {
        this._GameObjectDecorated.collisionGameObject(abstractGameObject);
        //rebondi pas contre les Aim, Hole
        if(!(abstractGameObject.getAbstractGameObject() instanceof Aim) && !(abstractGameObject.getAbstractGameObject() instanceof Hole) && this.isIntersectBy(abstractGameObject)) {
            Vecteur vitesse = new Vecteur(_GameObjectDecorated.get_speed());

            if(_GameObjectDecorated.get_position().x + _GameObjectDecorated.get_speed().x + _GameObjectDecorated.get_width() > abstractGameObject.get_position().x || //on vient par la GAUCHE
                    _GameObjectDecorated.get_position().x + _GameObjectDecorated.get_speed().x < abstractGameObject.get_position().x + abstractGameObject.get_width() //on vient par la DROITE
                    )
                vitesse.x = -vitesse.x;

            if(_GameObjectDecorated.get_position().y + _GameObjectDecorated.get_speed().y + _GameObjectDecorated.get_height() > abstractGameObject.get_position().y || //on vient par le HAUT
                    _GameObjectDecorated.get_position().y + _GameObjectDecorated.get_speed().y  < abstractGameObject.get_position().y + abstractGameObject.get_height() //on vient par le BAS
                    )
                vitesse.y = -vitesse.y;

            _GameObjectDecorated.setSpeed(vitesse);
        }
    }



    @Override//Collision avec le bord
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur)
    {
        this._GameObjectDecorated.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString()
    {
        return "Collision Amortie entre Objects, "+ this._GameObjectDecorated.toString();
    }

}
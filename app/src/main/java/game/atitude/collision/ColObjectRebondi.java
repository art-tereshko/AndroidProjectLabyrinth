package game.atitude.collision;


import game.AbstractGameObject;
import game.object.circle.Aim;
import game.object.circle.Hole;
import mesmaths.geometrie.base.Vecteur;

public class ColObjectRebondi extends Collision {


    public ColObjectRebondi(AbstractGameObject abstractGameObject) {
        super(abstractGameObject);
    }

    @Override
    public void collisionGameObject(AbstractGameObject abstractGameObject) {
        this._GameObjectDecorated.collisionGameObject(abstractGameObject);

        if(!(abstractGameObject.getAbstractGameObject() instanceof Aim) && !(abstractGameObject.getAbstractGameObject() instanceof Hole) && this.isIntersectBy(abstractGameObject)) {
            Vecteur vitesse = _GameObjectDecorated.get_speed();

            vitesse.produitScalaire(abstractGameObject.get_speed());


            //Recherche du point de collision
            if(_GameObjectDecorated.get_position().x  - _GameObjectDecorated.get_speed().x < abstractGameObject.get_position().x) {//touche GAUCHE de abstract
               if(Math.abs(vitesse.x) < MIN_ACCEL)
                   vitesse.x = 0;
               else
                   vitesse.x = _GameObjectDecorated.getMasse() > 0 ? -vitesse.x / (1 + 1/_GameObjectDecorated.getMasse()) : -vitesse.x;
            }
            else if(_GameObjectDecorated.get_position().x  - _GameObjectDecorated.get_speed().x > abstractGameObject.get_position().x + abstractGameObject.get_width()){//touche DROITE de abstract
                if(Math.abs(vitesse.x) < MIN_ACCEL)
                    vitesse.x = 0;
                else
                   vitesse.x = _GameObjectDecorated.getMasse() > 0 ? -vitesse.x / (1 + 1/_GameObjectDecorated.getMasse()) : -vitesse.x;
            }

            if(_GameObjectDecorated.get_position().y - _GameObjectDecorated.get_speed().y < abstractGameObject.get_position().y) {//touche DESSUS de abstract
               if(Math.abs(vitesse.y) < MIN_ACCEL)
                   vitesse.y = 0;
               else
                    vitesse.y = _GameObjectDecorated.getMasse() > 0 ? -vitesse.y / (1 + 1/_GameObjectDecorated.getMasse()) : -vitesse.y;
            }
            else if(_GameObjectDecorated.get_position().y  - _GameObjectDecorated.get_speed().y > abstractGameObject.get_position().y + abstractGameObject.get_height()){//touche DESSOUS de abstract
               if(Math.abs(vitesse.y) < MIN_ACCEL)
                   vitesse.y = 0;
               else
               vitesse.y = _GameObjectDecorated.getMasse() > 0 ? -vitesse.y / (1 + 1/_GameObjectDecorated.getMasse()) : -vitesse.y;
            }

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
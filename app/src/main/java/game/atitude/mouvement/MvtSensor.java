package game.atitude.mouvement;

import java.util.Vector;

import game.AbstractGameObject;
import mesmaths.geometrie.base.Vecteur;


public class MvtSensor extends Mouvement {

    public MvtSensor(AbstractGameObject abstractGameObject)
    {
        super(abstractGameObject);
    }

    @Override
    public void gestionAccélération(Vector<AbstractGameObject> abstractGameObjectVector) {
        this._GameObjectDecorated.gestionAccélération(abstractGameObjectVector);

    }
    @Override
    public void gestionMouvement(Vecteur mouvement) {
        this._GameObjectDecorated.gestionMouvement(mouvement);

        if(Math.abs(mouvement.x) > MIN_ACCEL || Math.abs(mouvement.y) > MIN_ACCEL) {//si le mouvement recu par le SENSOR est suffisant pour faire bouger la bille
            this._GameObjectDecorated.setAcceleration(mouvement.produit(1 / _GameObjectDecorated.getMasse()));

            Vecteur mvt = new Vecteur();
            //-------X
            if (this.get_speed().x < -MAX_VITESSE)
                mvt.x = -MAX_VITESSE;
            else {
                if (this.get_speed().x > MAX_VITESSE)
                    mvt.x = MAX_VITESSE;
                else
                    mvt.x = this.get_speed().x + _GameObjectDecorated.getAcceleration().x;
            }

            //-------Y
            if (this.get_speed().y < -MAX_VITESSE)
                mvt.y = -MAX_VITESSE;
            else {
                if (this.get_speed().y > MAX_VITESSE)
                    mvt.y = MAX_VITESSE;
                else
                    mvt.y = this.get_speed().y + _GameObjectDecorated.getAcceleration().y;
            }

            this.setSpeed(new Vecteur(mvt));
        }
    }
}


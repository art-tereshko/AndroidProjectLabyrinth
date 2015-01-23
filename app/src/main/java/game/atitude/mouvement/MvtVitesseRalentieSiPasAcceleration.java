package game.atitude.mouvement;


import java.util.Vector;

import game.AbstractGameObject;
import mesmaths.geometrie.base.Vecteur;

public class MvtVitesseRalentieSiPasAcceleration extends Mouvement{


    public MvtVitesseRalentieSiPasAcceleration(AbstractGameObject gameObjectDecorated) {
        super(gameObjectDecorated);
    }

    @Override
    public void gestionAccélération(Vector<AbstractGameObject> abstractGameObjectVector) {

    }

    @Override
    public void gestionMouvement(Vecteur mouvement) {
        this._GameObjectDecorated.gestionMouvement(mouvement);

        Vecteur speed = new Vecteur(_GameObjectDecorated.get_speed());
        if(Math.abs(_GameObjectDecorated.getAcceleration().x) < MIN_ACCEL) {
            if (Math.abs(speed.x) < FREINS)
                speed.x = 0;
            else {
                if (speed.x > 0)
                    speed.x -= FREINS;
                else
                    speed.x += FREINS;
            }
        }
        if(Math.abs(_GameObjectDecorated.getAcceleration().y) < MIN_ACCEL) {
            if (Math.abs(speed.y) < FREINS)
                speed.y = 0;
            else {
                if (speed.y > 0)
                    speed.y -= FREINS;
                else
                    speed.y += FREINS;
            }
        }

        _GameObjectDecorated.setSpeed(speed);
    }
}

package game.atitude.mouvement;


import java.util.Vector;

import game.AbstractGameObject;
import mesmaths.geometrie.base.Vecteur;

public class MvtUniforme extends Mouvement {

    private double _rapport;//mise à l'échelle

    public MvtUniforme(AbstractGameObject gameObjectDecorated, double rapport) {
        super(gameObjectDecorated);
        _rapport = rapport;
    }

    @Override
    public void gestionAccélération(Vector<AbstractGameObject> abstractGameObjectVector) {
        this._GameObjectDecorated.gestionAccélération(abstractGameObjectVector);
    }

    @Override
    public void gestionMouvement(Vecteur mouvement) {
        this._GameObjectDecorated.gestionMouvement(mouvement);

        Vecteur deplacementAFaire = new Vecteur();
        deplacementAFaire.x = -(_GameObjectDecorated.get_position().x * Math.cos(Math.toRadians(_GameObjectDecorated.getAngleorientation())));
        deplacementAFaire.y = _GameObjectDecorated.get_position().y * Math.sin(Math.toRadians(_GameObjectDecorated.getAngleorientation()) * _rapport);

        Vecteur speed = new Vecteur();
        if(deplacementAFaire.x != 0 && deplacementAFaire.y != 0){
            double rapport = deplacementAFaire.x / deplacementAFaire.y;
            double vitesseX = deplacementAFaire.x > 0 ? VITESSE_UNFIFORME : -VITESSE_UNFIFORME;
            double vitesseY = deplacementAFaire.y > 0 ? VITESSE_UNFIFORME : -VITESSE_UNFIFORME;
            speed.y = vitesseY;
            speed.x = vitesseX * rapport;
        }
        this._GameObjectDecorated.setSpeed(speed);
    }
}

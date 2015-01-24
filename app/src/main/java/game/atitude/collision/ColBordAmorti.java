package game.atitude.collision;

import game.AbstractGameObject;
import mesmaths.geometrie.base.Vecteur;


public class ColBordAmorti extends Collision{

    public ColBordAmorti(AbstractGameObject abstractGameObject)
    {
        super(abstractGameObject);
    }

    @Override
    public void collisionGameObject(AbstractGameObject gameObject) {
        this._GameObjectDecorated.collisionGameObject(gameObject);
    }

    @Override//Collision avec le bord
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur)
    {
        this._GameObjectDecorated.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);

        //GAUCHE ou DROITE
        if (this.get_position().x + this.get_speed().x < abscisseCoinHautGauche || this.get_position().x + this.get_speed().x > (abscisseCoinHautGauche+largeur) - this.get_drawRectangle().width()) {
            this.setSpeed(new Vecteur(0, this.get_speed().y));
            //PlayCollisionSound();

        }
        //HAUT et BAS
        if (this.get_position().y + this.get_speed().y< ordonnéeCoinHautGauche || this.get_position().y + this.get_speed().y > (ordonnéeCoinHautGauche + hauteur) - this.get_drawRectangle().height())
        {
            this.setSpeed(new Vecteur(this.get_speed().x, 0));
          //  PlayCollisionSound();
        }

    }
    public void PlayCollisionSound() {
        if (_GameObjectDecorated.get_player().isPlaying())
            _GameObjectDecorated.get_player().seekTo(0);
        else
            _GameObjectDecorated.get_player().start();
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Collision Amortie Bord, "+ this._GameObjectDecorated.toString();
    }

}

package game.atitude.mouvement;

import game.AbstractGameObject;
import game.DecoratorGameObject;

public abstract class Mouvement extends DecoratorGameObject{

    public Mouvement(AbstractGameObject gameObjectDecorated) {
            super(gameObjectDecorated);
        }

    @Override
    public void collisionGameObject(AbstractGameObject gameObject) {
        // rien a decorer, on appelle les methodes des autres décorateurs, au cas où ils gèrent ca
        this._GameObjectDecorated.collisionGameObject(gameObject);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
        // rien a decorer, on appelle les methodes des autres décorateurs, au cas où ils gèrent ca
        this._GameObjectDecorated.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
    }
}

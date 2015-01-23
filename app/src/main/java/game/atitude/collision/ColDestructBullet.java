package game.atitude.collision;

import game.AbstractGameObject;
import game.atitude.mouvement.MvtUniforme;
import game.object.circle.Aim;
import game.object.circle.Bullet;
import game.object.circle.Hole;
import game.object.rectangle.Cannon;
import mesmaths.geometrie.base.Vecteur;

public class ColDestructBullet extends Collision {

    public ColDestructBullet(AbstractGameObject abstractGameObject) {
        super(abstractGameObject);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
        this._GameObjectDecorated.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);

        if (this.get_position().x == abscisseCoinHautGauche ||//GAUCHE
                this.get_position().x == (abscisseCoinHautGauche+largeur) - this.get_drawRectangle().width() ||//DROITE
                this.get_position().y == ordonnéeCoinHautGauche || //HAUT
                this.get_position().y == (ordonnéeCoinHautGauche + hauteur) - this.get_drawRectangle().height())//BAS
        {
            if(this._GameObjectDecorated.getAbstractGameObject() instanceof Bullet){
                //On lance une nouvelle Bullet à la place de l'ancienne qui s'est détruite
                ((Bullet)this._GameObjectDecorated.getAbstractGameObject()).set_active(false);
                ((Bullet) this._GameObjectDecorated.getAbstractGameObject()).get_cannon().set_bullet(_GameObjectDecorated.getAbstractGameObject());
                ((Bullet) this._GameObjectDecorated.getAbstractGameObject()).get_cannon().ShootBullet();
            }

        }
    }

    @Override
    public void collisionGameObject(AbstractGameObject abstractGameObject) {
        this._GameObjectDecorated.collisionGameObject(abstractGameObject);

        if(!(abstractGameObject.getAbstractGameObject() instanceof Cannon) && this.isIntersectBy(abstractGameObject)) {
            Vecteur vitesse = _GameObjectDecorated.get_speed();
            vitesse.produitScalaire(abstractGameObject.get_speed());

            if(this._GameObjectDecorated.getAbstractGameObject() instanceof Bullet){
                //On lance une nouvelle Bullet à la place de l'ancienne qui s'est détruite
                ((Bullet)this._GameObjectDecorated.getAbstractGameObject()).set_active(false);
                ((Bullet) this._GameObjectDecorated.getAbstractGameObject()).get_cannon().set_bullet(_GameObjectDecorated.getAbstractGameObject());
                ((Bullet) this._GameObjectDecorated.getAbstractGameObject()).get_cannon().ShootBullet();
            }
        }

    }
}

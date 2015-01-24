package game.atitude.collision;


import game.AbstractGameObject;
import game.object.circle.Aim;
import game.object.circle.Hole;
import mesmaths.geometrie.base.Vecteur;

public class ColObjectRenbondiRalenti extends Collision {


    public ColObjectRenbondiRalenti(AbstractGameObject abstractGameObject) {
        super(abstractGameObject);
    }

    @Override
    public void collisionGameObject(AbstractGameObject abstractGameObject) {
        this._GameObjectDecorated.collisionGameObject(abstractGameObject);

        if(!(abstractGameObject.getAbstractGameObject() instanceof Aim) && !(abstractGameObject.getAbstractGameObject() instanceof Hole) && this.isIntersectBy(abstractGameObject)) {
            Vecteur vitesse = _GameObjectDecorated.get_speed();

            vitesse.produitScalaire(abstractGameObject.get_speed());


            //gestion des différents endroits de collision
            //AXE DES X
            if (_GameObjectDecorated.get_position().x + _GameObjectDecorated.get_width() - _GameObjectDecorated.get_speed().x < abstractGameObject.get_position().x &&
                    _GameObjectDecorated.get_position().x + _GameObjectDecorated.get_width() + _GameObjectDecorated.get_speed().x > abstractGameObject.get_position().x) {
                //touche le bord GAUCHE de abstract
                if (Math.abs(vitesse.x) < MIN_VITESSE) {
                    _GameObjectDecorated.set_Position(new Vecteur(abstractGameObject.get_position().x - _GameObjectDecorated.get_width(), _GameObjectDecorated.get_position().y));
                    vitesse.x = 0;
                } else
                    vitesse.x = _GameObjectDecorated.getMasse() > 0 ? -vitesse.x / (1 + 2 / _GameObjectDecorated.getMasse()) : -vitesse.x;
            } else {
                if (_GameObjectDecorated.get_position().x - _GameObjectDecorated.get_speed().x > abstractGameObject.get_position().x + abstractGameObject.get_width() &&
                        _GameObjectDecorated.get_position().x + _GameObjectDecorated.get_speed().x < abstractGameObject.get_position().x + abstractGameObject.get_width()) {
                    //touche le bord DROITE de abstract
                    if (Math.abs(vitesse.x) < MIN_VITESSE) {
                        _GameObjectDecorated.set_Position(new Vecteur(abstractGameObject.get_position().x + abstractGameObject.get_width(), _GameObjectDecorated.get_position().y));
                        vitesse.x = 0;
                    } else
                        vitesse.x = _GameObjectDecorated.getMasse() > 0 ? -vitesse.x / (1 + 2 / _GameObjectDecorated.getMasse()) : -vitesse.x;
                }
            }

            //AXE DES Y
            if (_GameObjectDecorated.get_position().y + _GameObjectDecorated.get_height() - _GameObjectDecorated.get_speed().y < abstractGameObject.get_position().y &&
                    _GameObjectDecorated.get_position().y + _GameObjectDecorated.get_height() + _GameObjectDecorated.get_speed().y > abstractGameObject.get_position().y) {
                //touche le bord DESSUS de abstract
                if (Math.abs(vitesse.y) < MIN_VITESSE) {
                    _GameObjectDecorated.set_Position(new Vecteur(_GameObjectDecorated.get_position().x, abstractGameObject.get_position().y - _GameObjectDecorated.get_height()));
                    vitesse.y = 0;
                } else
                    vitesse.y = _GameObjectDecorated.getMasse() > 0 ? -vitesse.y / (1 + 2 / _GameObjectDecorated.getMasse()) : -vitesse.y;
            } else {
                if (_GameObjectDecorated.get_position().y - _GameObjectDecorated.get_speed().y > abstractGameObject.get_position().y + abstractGameObject.get_height() &&
                        _GameObjectDecorated.get_position().y + _GameObjectDecorated.get_speed().y < abstractGameObject.get_position().y + abstractGameObject.get_height()) {
                    //touche le bord DESSOUS de abstract
                    if (Math.abs(vitesse.y) < MIN_VITESSE) {
                        _GameObjectDecorated.set_Position(new Vecteur(_GameObjectDecorated.get_position().x, abstractGameObject.get_position().y + abstractGameObject.get_height()));
                        vitesse.y = 0;
                    } else
                        vitesse.y = _GameObjectDecorated.getMasse() > 0 ? -vitesse.y / (1 + 2 / _GameObjectDecorated.getMasse()) : -vitesse.y;
                }
            }


            //GESTION DES COINS
            //si on est sur les X dans l'intervalle des bords DROITE et GAUCHE de abstract
            if (_GameObjectDecorated.get_position().x > abstractGameObject.get_position().x && _GameObjectDecorated.get_position().x < abstractGameObject.get_position().x + abstractGameObject.get_width() ||
                    _GameObjectDecorated.get_position().x + _GameObjectDecorated.get_width() > abstractGameObject.get_position().x && _GameObjectDecorated.get_position().x + _GameObjectDecorated.get_width() < abstractGameObject.get_position().x + abstractGameObject.get_width())
                //si on est sur les Y dans l'intervalle des bords BAS et HAUT de abstract
                if (_GameObjectDecorated.get_position().y > abstractGameObject.get_position().y && _GameObjectDecorated.get_position().y < abstractGameObject.get_position().y + abstractGameObject.get_height() ||
                        _GameObjectDecorated.get_position().y + _GameObjectDecorated.get_height() > abstractGameObject.get_position().y && _GameObjectDecorated.get_position().y + _GameObjectDecorated.get_height() < abstractGameObject.get_position().y + abstractGameObject.get_height())
                    //nous sommes dans le rectangle de abstract. il faut gérer les rebonds si nous sommes un cercle sinon NON (mais nous resterons enfermé)

                    //touche COIN BAS DROITE de abstract
                    if (_GameObjectDecorated.get_position().x > abstractGameObject.get_position().x && _GameObjectDecorated.get_position().x < abstractGameObject.get_position().x + abstractGameObject.get_width() &&
                            _GameObjectDecorated.get_position().y > abstractGameObject.get_position().y && _GameObjectDecorated.get_position().y < abstractGameObject.get_position().y + abstractGameObject.get_height()) {
                        if (Math.abs(vitesse.x) < MIN_VITESSE) {
                            _GameObjectDecorated.set_Position(new Vecteur(abstractGameObject.get_position().x + abstractGameObject.get_width(), abstractGameObject.get_position().y + abstractGameObject.get_height()));
                            vitesse.x = 0;
                            vitesse.y = 0;
                        }
                        else {
                            vitesse.x = _GameObjectDecorated.getMasse() > 0 ? -vitesse.x / (1 + 2 / _GameObjectDecorated.getMasse()) : -vitesse.x;
                            vitesse.y = _GameObjectDecorated.getMasse() > 0 ? -vitesse.y / (1 + 2 / _GameObjectDecorated.getMasse()) : -vitesse.y;
                        }
                    }

                    //touche COIN BAS GAUCHE de abstract
                    if (_GameObjectDecorated.get_position().x + _GameObjectDecorated.get_width() > abstractGameObject.get_position().x && _GameObjectDecorated.get_position().x + _GameObjectDecorated.get_width() < abstractGameObject.get_position().x + abstractGameObject.get_width() &&
                            _GameObjectDecorated.get_position().y > abstractGameObject.get_position().y && _GameObjectDecorated.get_position().y < abstractGameObject.get_position().y + abstractGameObject.get_height()) {
                        if (Math.abs(vitesse.x) < MIN_VITESSE) {
                            _GameObjectDecorated.set_Position(new Vecteur(abstractGameObject.get_position().x - _GameObjectDecorated.get_width(), abstractGameObject.get_position().y + abstractGameObject.get_height()));
                            vitesse.x = 0;
                            vitesse.y = 0;
                        }
                        else {
                            vitesse.x = _GameObjectDecorated.getMasse() > 0 ? -vitesse.x / (1 + 2 / _GameObjectDecorated.getMasse()) : -vitesse.x;
                            vitesse.y = _GameObjectDecorated.getMasse() > 0 ? -vitesse.y / (1 + 2 / _GameObjectDecorated.getMasse()) : -vitesse.y;
                        }
                    }

                    //touche COIN HAUT GAUCHE de abstract
                    if (_GameObjectDecorated.get_position().x + _GameObjectDecorated.get_width() > abstractGameObject.get_position().x && _GameObjectDecorated.get_position().x + _GameObjectDecorated.get_width() < abstractGameObject.get_position().x + abstractGameObject.get_width() &&
                            _GameObjectDecorated.get_position().y + _GameObjectDecorated.get_height() > abstractGameObject.get_position().y && _GameObjectDecorated.get_position().y + _GameObjectDecorated.get_height() < abstractGameObject.get_position().y + abstractGameObject.get_height()) {
                        if (Math.abs(vitesse.x) < MIN_VITESSE) {
                            _GameObjectDecorated.set_Position(new Vecteur(abstractGameObject.get_position().x - _GameObjectDecorated.get_width(), abstractGameObject.get_position().y - _GameObjectDecorated.get_height()));
                            vitesse.x = 0;
                            vitesse.y = 0;
                        }
                        else {
                            vitesse.x = _GameObjectDecorated.getMasse() > 0 ? -vitesse.x / (1 + 2 / _GameObjectDecorated.getMasse()) : -vitesse.x;
                            vitesse.y = _GameObjectDecorated.getMasse() > 0 ? -vitesse.y / (1 + 2 / _GameObjectDecorated.getMasse()) : -vitesse.y;
                        }
                    }

                    //touche COIN HAUT DROITE de abstract
                    if (_GameObjectDecorated.get_position().x  > abstractGameObject.get_position().x && _GameObjectDecorated.get_position().x  < abstractGameObject.get_position().x + abstractGameObject.get_width() &&
                            _GameObjectDecorated.get_position().y + _GameObjectDecorated.get_height() > abstractGameObject.get_position().y && _GameObjectDecorated.get_position().y + _GameObjectDecorated.get_height() < abstractGameObject.get_position().y + abstractGameObject.get_height()) {
                        if (Math.abs(vitesse.x) < MIN_VITESSE) {
                            _GameObjectDecorated.set_Position(new Vecteur(abstractGameObject.get_position().x + abstractGameObject.get_width(), abstractGameObject.get_position().y - _GameObjectDecorated.get_height()));
                            vitesse.x = 0;
                            vitesse.y = 0;
                        }
                        else {
                            vitesse.x = _GameObjectDecorated.getMasse() > 0 ? -vitesse.x / (1 + 2 / _GameObjectDecorated.getMasse()) : -vitesse.x;
                            vitesse.y = _GameObjectDecorated.getMasse() > 0 ? -vitesse.y / (1 + 2 / _GameObjectDecorated.getMasse()) : -vitesse.y;
                        }
                    }

            ///il faut gerer hautdroite haut gauche

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
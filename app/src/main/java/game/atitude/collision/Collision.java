package game.atitude.collision;

import java.util.Vector;

import game.AbstractGameObject;
import game.DecoratorGameObject;
import game.shape.ShapeCircle;
import game.shape.ShapeRectangle;
import mesmaths.geometrie.base.Vecteur;

public abstract class Collision extends DecoratorGameObject {

    public Collision(AbstractGameObject gameObjectDecorated) {
        super(gameObjectDecorated);
    }


    @Override
    //on définit ici car toutes les classes derivées ne gèreront pas ça, donc évite le copier coller
    public void gestionAccélération(Vector<AbstractGameObject> abstractGameObjectVector) {
        // rien a decorer, on appelle les methodes des autres décorateurs, au cas où ils gèrent ca
        this._GameObjectDecorated.gestionAccélération(abstractGameObjectVector);
    }

    @Override
    public void gestionMouvement(Vecteur mouvement) {
        // rien a decorer, on appelle les methodes des autres décorateurs, au cas où ils gèrent ca
        this._GameObjectDecorated.gestionMouvement(mouvement);
    }


    public boolean isIntersectBy(AbstractGameObject abstractGameObject) {
        if (this.equals(abstractGameObject))
            return false;
        else {
            boolean result = false;
            double bordLEFT, bordRIGHT, bordUP, bordDOWN;

            //Rectangle avec Rectangle
            if (this._GameObjectDecorated.getAbstractGameObject() instanceof ShapeRectangle &&
                    abstractGameObject.getAbstractGameObject() instanceof ShapeRectangle) {
                result = this._GameObjectDecorated.get_drawRectangle().intersect(abstractGameObject.get_drawRectangle());
            }
            //Circle avec Circle
            if (this._GameObjectDecorated.getAbstractGameObject() instanceof ShapeCircle &&
                    abstractGameObject.getAbstractGameObject() instanceof ShapeCircle) {

                int radius1 = _GameObjectDecorated.get_width() / 2;
                Vecteur centre1 = new Vecteur(_GameObjectDecorated.get_position().x + radius1, _GameObjectDecorated.get_position().y + radius1);
                int radius2 = abstractGameObject.get_width() / 2;
                Vecteur centre2 = new Vecteur(abstractGameObject.get_position().x + radius2, abstractGameObject.get_position().y + radius2);

                result = Math.pow(centre2.x - centre1.x, 2) + Math.pow(centre2.y - centre1.y, 2) < Math.pow(radius1 + radius2, 2);
            }

            //Circle avec Rectangle
            if (this._GameObjectDecorated.getAbstractGameObject() instanceof ShapeCircle &&
                    abstractGameObject.getAbstractGameObject() instanceof ShapeRectangle) {
                result = circleIntersectRectangle(_GameObjectDecorated, abstractGameObject);
            }
            //Rectangle avec Circle
            if (this._GameObjectDecorated.getAbstractGameObject() instanceof ShapeRectangle &&
                    abstractGameObject.getAbstractGameObject() instanceof ShapeCircle) {
                result = circleIntersectRectangle(abstractGameObject, _GameObjectDecorated);
            }
            return result;
        }
    }

    private boolean circleIntersectRectangle(AbstractGameObject circle, AbstractGameObject rect){
            int radius = circle.get_width()/2;
            Vecteur c = new Vecteur(circle.get_position().x + radius + circle.get_speed().x, circle.get_position().y + radius + circle.get_speed().y);//rajoute la position next pour anticiper
            double closestX, closestY;
        // Find the closest point to the circle within the rectangle
        if (c.x < rect.get_position().x)//a gauche
            closestX = rect.get_position().x;
        else if (c.x  > rect.get_position().x + rect.get_width())//a droite
                closestX = rect.get_position().x + rect.get_width();
            else
                closestX = c.x ;
        if (c.y < rect.get_position().y)//au dessus
            closestY = rect.get_position().y;
        else if (c.y  > rect.get_position().y + rect.get_height())//en dessous
            closestY = rect.get_position().y + rect.get_height();
        else
            closestY = c.y ;

        // Calculate the distance between the circle's center and this closest point
        double distanceX = c.x - closestX;
        double distanceY = c.y - closestY;

        // If the distance is less than the circle's radius, an intersection occurs
        double distanceSquared = (distanceX * distanceX) + (distanceY * distanceY);
        return distanceSquared <(radius*radius);
    }


}

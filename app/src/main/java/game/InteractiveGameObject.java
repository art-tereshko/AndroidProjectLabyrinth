package game;

/**
 * Created by artem_000 on 11/11/2014.
 */
public abstract class InteractiveGameObject  extends  GameObject{

    protected float speedX =10;
    protected float speedY = 10;

    protected float repulsion = 1.2f;
    protected int maxSpeed = 15;


    public InteractiveGameObject(int height, int width) {
        super(height, width);
    }

    public InteractiveGameObject(int coordinateX, int coordinateY, int height, int width){
        super(coordinateX,coordinateY, height,width);

    }


}

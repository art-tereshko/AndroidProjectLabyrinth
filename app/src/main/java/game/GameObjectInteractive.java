package game;

import game.shape.ShapeCircle;

public abstract class GameObjectInteractive extends ShapeCircle{

    protected float speedX = 10;
    protected float speedY = 10;

    protected float repulsion = 1.2f;
    protected int maxSpeed = 8;

    public GameObjectInteractive(int radius, int x, int y) {
        super(radius, x, y);
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public float getRepulsion() {
        return repulsion;
    }

    public void setRepulsion(float repulsion) {
        this.repulsion = repulsion;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

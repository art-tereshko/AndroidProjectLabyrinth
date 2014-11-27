package game;

/**
 * Created by Artem Tereshko on 11/11/2014.
 * ${PROJECT_NAME}
 */
public interface Movable {

    float getSpeedX();
    float getSpeedY();
    void setAcceleration(float x , float y);
    void Move();
    void SetMovementBounds(int x, int y, int height, int width);

}
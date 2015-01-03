package game;

import android.graphics.Rect;

import java.util.ArrayList;

import game.object.circle.Aim;
import game.object.circle.Bullet;
import game.object.circle.CircularWall;
import game.object.circle.Hole;
import game.object.rectangle.Cannon;
import game.object.rectangle.Wall;

public class Level {

    private ArrayList<GameObject> _gameObjectArrayList;
    private Rect movementBounds;

    private int worldHeight;
    private int worldWidth;

    public ArrayList<GameObject> get_gameObjectArrayList() {
        return _gameObjectArrayList;
    }

    public void set_gameObjectArrayList(ArrayList<GameObject> _gameObjectArrayList) {
        this._gameObjectArrayList = _gameObjectArrayList;
    }

    public Rect getMovementBounds() {
        return this.movementBounds;
    }

   /**
     * @param height Height of level in pixels
     * @param width  Width of level in pixels
     */
    public Level(int height, int width) {
        this.worldHeight = height;
        this.worldWidth = width;
        this._gameObjectArrayList = new ArrayList<GameObject>();
        movementBounds = new Rect(0, 0, width, height);

    }

    /**
     * @param height Height of level in pixels
     * @param width  Width of level in pixels
     */
    public static Level Level1(int height, int width) {

        int wallWidth = width / 100 * 5; // 5%
        int holeSize =  height/100*5;
        int aimSize = height / 100 * 5;
        Level lvl = new Level(height, width);

        lvl.add(new Wall(width / 2 - (wallWidth / 2), height / 100 * 30, height, wallWidth));
        lvl.add(new Wall(width / 4 - (wallWidth / 2), 0, height / 100 * 70, wallWidth));
        lvl.add(new Wall(width / 4 * 3 - (wallWidth / 2), 0, height / 100 * 70, wallWidth));
        lvl.add(new Hole(holeSize, width/3, height/2));
        lvl.add(new Hole(holeSize, width/3*2, height/2));
        lvl.add(new Aim(aimSize, width - aimSize * 2, aimSize));

        return lvl;
    }

    /**
     * @param height Height of level in pixels
     * @param width  Width of level in pixels
     */
    public static Level Level2(int height, int width) {
        Level lvl = new Level(height, width);
        int wallWidth = height / 100 * 5;
        lvl.add(new CircularWall(wallWidth, width / 4, 0 - wallWidth));//1
        lvl.add(new Wall(0, height / 7, wallWidth, width / 2));//2
        lvl.add(new CircularWall(wallWidth / 2, width / 2 - wallWidth, height / 7 + wallWidth / 2 - wallWidth));//3
        lvl.add(new Wall(width / 8 * 5, 0, height / 7 * 2, wallWidth));//4
        lvl.add(new CircularWall(wallWidth, width / 8 * 5 + wallWidth / 2 - wallWidth, height / 7 + wallWidth));//5
        lvl.add(new Wall(width / 8 * 6, height / 7, wallWidth, width / 7));//6
        lvl.add(new Wall(0, height / 2, wallWidth, width / 8 * 7));//7
       // lvl.addWall(new Wall(_width / 8 * 7 - wallWidth, wallWidth, _height / 16 * 13, _height / 16 * 5));//8
        lvl.add(new CircularWall(wallWidth + (wallWidth / 2), width / 8 * 7 - wallWidth * 2, height / 16 * 7));//9
        lvl.add(new Hole(wallWidth, width / 8 * 7 - wallWidth, height / 16 * 4));//10
        lvl.add(new Wall(0, height / 16 * 5, wallWidth, width / 8 * 2));//11
        lvl.add(new Wall(width / 8 * 2 + wallWidth * 2, height / 16 * 5, wallWidth, width / 16 * 3));//12
        lvl.add(new Hole(wallWidth, width / 8 * 2, height / 16 * 5));//13
        lvl.add(new Wall(width / 8 * 5, height / 14 * 10, wallWidth, width));//14
       // lvl.addCircularWall(new CircularWall(wallWidth + (wallWidth / 2), _width, _height / 14 * 10 + wallWidth / 2));//15
        lvl.add(new CircularWall(wallWidth + (wallWidth / 2), width / 2, height / 14 * 13));//16
        lvl.add(new Aim(wallWidth, width / 16 * 15, height / 14 * 12));//17
        lvl.add(new Hole(wallWidth, width / 8 * 5, height / 14 * 13));//18
        lvl.add(new Hole(wallWidth, width / 16 * 14, height / 14 * 11 - wallWidth / 2));//19
        lvl.add(new Aim(wallWidth, width / 16, height / 14 * 12));//20
        lvl.add(new Hole(wallWidth, width / 16 - wallWidth, height / 14 * 10));//21
        lvl.add(new Hole(wallWidth, width / 16 * 3, height / 14 * 13 - wallWidth / 2));//22
        lvl.add(new Wall(width / 16 * 5, height / 14 * 10, height, wallWidth));//23
        lvl.add(new CircularWall(wallWidth + wallWidth / 2, width / 16 * 5 - wallWidth, height / 14 * 10));//24
        return lvl;
    }

    /**
     * @param height Height of level in pixels
     * @param width  Width of level in pixels
     */
    public static Level Level3(int height, int width) {
        Level lvl = new Level(height, width);
        int wallWidth = width / 100 * 5; // 5%
        int cannonWidth = width / 100 * 10; // 10%
        int cannonHeight =cannonWidth /2;
        int aimSize = height / 100 * 5;
        int bulletSize = height / 100 * 2;


        lvl.add(new Wall(width / 2 - (wallWidth / 2), height / 100 * 30, height, wallWidth));
        lvl.add(new Cannon(width /3, height/ 2, cannonWidth, cannonHeight, 280, 10));
        lvl.add((new Bullet(cannonHeight/4, width/3, height/2, 280)));
        lvl.add(new Aim(aimSize, width - aimSize * 2, aimSize));

        return lvl;
    }

    public void add(GameObject gameObject){
        _gameObjectArrayList.add(gameObject);
    }
}

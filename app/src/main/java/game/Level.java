package game;

import android.graphics.Rect;

import java.util.ArrayList;

import game.object.circle.Aim;
import game.object.circle.CircularWall;
import game.object.circle.Hole;
import game.object.rectangle.Cannon;
import game.object.rectangle.Wall;

public class Level {

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public ArrayList<CircularWall> getCircularWalls() {
        return circularWalls;
    }

    public ArrayList<Cannon> getCannons() {
        return cannons;
    }

    public ArrayList<Hole> getHoles() {
        return holes;
    }

    public ArrayList<Aim> getAims() {
        return aims;
    }

    private ArrayList<Wall> walls;
    private ArrayList<CircularWall> circularWalls;
    private ArrayList<Cannon> cannons;
    private ArrayList<Hole> holes;
    private ArrayList<Aim> aims;


    private Rect movementBounds;

    private int worldHeight;
    private int worldWidth;

    /**
     * @param height Height of level in pixels
     * @param width  Width of level in pixels
     */
    public Level(int height, int width) {
        this.worldHeight = height;
        this.worldWidth = width;

        circularWalls = new ArrayList<CircularWall>();
        cannons = new ArrayList<Cannon>();
        walls = new ArrayList<Wall>();
        holes = new ArrayList<Hole>();
        aims = new ArrayList<Aim>();
        movementBounds = new Rect(0, 0, width, height);

    }

    /**
     * @param height Height of level in pixels
     * @param width  Width of level in pixels
     */
    public static Level Level1(int height, int width) {

        int wallWidth = width / 100 * 5; // 5%
        Level lvl = new Level(height, width);


        lvl.addWall(new Wall(width / 2 - (wallWidth / 2), height / 100 * 30, height, wallWidth));
        lvl.addWall(new Wall(width / 4 - (wallWidth / 2), 0, height / 100 * 70, wallWidth));
        lvl.addWall(new Wall(width / 4 * 3 - (wallWidth / 2), 0, height / 100 * 70, wallWidth));
        int holeSize =  height/100*5;
        //lvl.addHole(new Hole(width/2,holeSize,holeSize,holeSize));
         lvl.addHole(new Hole(holeSize, width/3, height/2));
        lvl.addHole(new Hole(holeSize, width/3*2, height/2));


        int aimSize = height / 100 * 5;
        lvl.addAim(new Aim(aimSize, width - aimSize * 2, aimSize));


        return lvl;
    }

    /**
     * @param height Height of level in pixels
     * @param width  Width of level in pixels
     */
    public static Level Level2(int height, int width) {
        Level lvl = new Level(height, width);
        int wallWidth = height / 100 * 5;
        lvl.addCircularWall(new CircularWall(wallWidth, width / 4, 0));//1
        lvl.addWall(new Wall(0, height / 7, wallWidth, width / 2));//2
        lvl.addCircularWall(new CircularWall(wallWidth / 2, width / 2, height / 7 + wallWidth / 2));//3
        lvl.addWall(new Wall(width / 8 * 5, 0, height / 7 * 2, wallWidth));//4
        lvl.addCircularWall(new CircularWall(wallWidth, width / 8 * 5 + wallWidth / 2, height / 7 + wallWidth / 2));//5
        lvl.addWall(new Wall(width / 8 * 6, height / 7, wallWidth, width / 7));//6
        lvl.addWall(new Wall(0, height / 2, wallWidth, width / 8 * 7));//7
        lvl.addWall(new Wall(width / 8 * 7 - wallWidth, wallWidth, height / 16 * 3, height / 16 * 5));//8
        lvl.addCircularWall(new CircularWall(wallWidth + (wallWidth / 2), width / 8 * 7 - wallWidth / 2, height / 16 * 7));//9
        lvl.addHole(new Hole(wallWidth, width / 8 * 7 - wallWidth, height / 16 * 4));//10
        lvl.addWall(new Wall(0, height / 16 * 5, wallWidth, width / 8 * 2));//11
        lvl.addWall(new Wall(width / 8 * 2 + wallWidth * 2, height / 16 * 5, wallWidth, width / 16 * 3));//12
        lvl.addHole(new Hole(wallWidth, width / 8 * 2 + wallWidth / 2, height / 16 * 5));//13
        lvl.addWall(new Wall(width / 8 * 5, height / 14 * 10, wallWidth, width));
        ;//14
        lvl.addCircularWall(new CircularWall(wallWidth + (wallWidth / 2), width, height / 14 * 10 + wallWidth / 2));//15
        lvl.addCircularWall(new CircularWall(wallWidth + (wallWidth / 2), width / 2, height / 14 * 13));//16
        lvl.addAim(new Aim(wallWidth * 2, width / 16 * 15, height / 14 * 12));//17
        lvl.addHole(new Hole(wallWidth, width / 8 * 5, height / 14 * 13));//18
        lvl.addHole(new Hole(wallWidth, width / 16 * 14, height / 14 * 11));//19
        lvl.addAim(new Aim(wallWidth * 2, width / 16, height / 14 * 12));//20
        lvl.addHole(new Hole(wallWidth, width / 16, height / 14 * 10));//21
        lvl.addHole(new Hole(wallWidth, width / 16 * 3, height / 14 * 13));//22
        lvl.addWall(new Wall(width / 16 * 5, height / 14 * 10, height, wallWidth));
        ;//23
        lvl.addCircularWall(new CircularWall(wallWidth + wallWidth / 2, width / 16 * 5 + wallWidth / 2, height / 14 * 10));//24
        return lvl;
    }

    /**
     * @param height Height of level in pixels
     * @param width  Width of level in pixels
     */
    public static Level Level3(int height, int width) {
        Level lvl = new Level(height, width);
        int wallWidth = width / 100 * 5; // 5%
        lvl.addWall(new Wall(width / 2 - (wallWidth / 2), height / 100 * 30, height, wallWidth));
        int aimSize = height / 100 * 5;
        lvl.addAim(new Aim(aimSize, width - aimSize * 2, aimSize));
        return lvl;
    }

    public void addWall(Wall w) {
        walls.add(w);
    }

    public void addCircularWall(CircularWall cw) {
        circularWalls.add(cw);
    }

    public void addCannon(Cannon c) {
        cannons.add(c);
    }

    public void addAim(Aim c) {
        aims.add(c);
    }

    public void addHole(Hole h) {
        holes.add(h);
    }

    public Rect getMovementBounds() {
        return this.movementBounds;
    }

}

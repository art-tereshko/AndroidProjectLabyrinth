package game;

import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by artem_tereshko on 11/11/2014.
 */
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
     *
     * @param height Height of level in pixels
     * @param width Width of level in pixels
     */
    public Level(int height, int width) {
        this.worldHeight = height;
        this.worldWidth = width;

        circularWalls = new ArrayList<CircularWall>();
        cannons = new ArrayList<Cannon>();
        walls = new ArrayList<Wall>();
        holes = new ArrayList<Hole>();
        aims = new ArrayList<Aim>();
        movementBounds = new Rect(0,0, width, height);

    }
    /**
     *
     * @param height Height of level in pixels
     * @param width Width of level in pixels
     */
    public static Level Level1(int height, int width){

        int wallWidth = width/100 * 5; // 5%
        Level lvl = new Level(height, width);


        lvl.addWall(new Wall(width/2 -(wallWidth/2), height/100*30, wallWidth, height));
        lvl.addWall(new Wall(width/4-(wallWidth/2), 0, wallWidth, height/100*70));
        lvl.addWall(new Wall(width/4*3-(wallWidth/2), 0, wallWidth, height/100*70));
       // lvl.addWall(new Wall(width-10,0, 10, height));
       // lvl.addWall(new Wall(400,70,50,500));

     //   lvl.addWall(new Wall(700,400,50,500));

      //  lvl.addCircularWall(new CircularWall(50, 300,150));

        lvl.addHole(new Hole(1000,300,50,50));

        int aimSize = height/100*5;
        lvl.addAim(new Aim(width-aimSize*2,0,aimSize, aimSize));



        return lvl;
    }
    /**
     *
     * @param height Height of level in pixels
     * @param width Width of level in pixels
     */
    public static Level Level2(int height, int width){
        return null;
    }
    /**
     *
     * @param height Height of level in pixels
     * @param width Width of level in pixels
     */
    public static Level Level3(int height, int width){
        return null;
    }

    public void addWall(Wall w){
        walls.add(w);
    }

    public void addCircularWall(CircularWall cw){
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

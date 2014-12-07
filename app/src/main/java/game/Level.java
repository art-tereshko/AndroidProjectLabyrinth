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

        int holeSize =  height/100*5;
      //lvl.addHole(new Hole(width/2,holeSize,holeSize,holeSize));
        lvl.addHole(new Hole(width/3,height/2,holeSize,holeSize));
        lvl.addHole(new Hole(width/3*2,height/2,holeSize,holeSize));

        int aimSize = height/100*5;
        lvl.addAim(new Aim(width-aimSize*2,aimSize,aimSize, aimSize));

        return lvl;
    }
    /**
     *
     * @param height Height of level in pixels
     * @param width Width of level in pixels
     */
    public static Level Level2(int height, int width){
        Level lvl = new Level(height, width);
        int wallWidth = height/100*5;

        lvl.addCircularWall(new CircularWall(wallWidth, width/4, 0));//1

        lvl.addWall(new Wall(0, height/7,width/2, wallWidth ));//2
        lvl.addCircularWall(new CircularWall(wallWidth/2, width/2, height/7+wallWidth/2));//3

        lvl.addWall(new Wall(width/8*5, 0, wallWidth,  height/7*2));//4
        lvl.addCircularWall(new CircularWall(wallWidth, width/8*5+wallWidth/2, height/7+wallWidth/2));//5

        lvl.addWall(new Wall(width/8*6, height/7, width/7,  wallWidth));//6

        lvl.addWall(new Wall(0, height/2, width/8*7,wallWidth));//7
        lvl.addWall(new Wall(width/8*7-wallWidth, height/16*5, wallWidth, height/16*3));//8
        lvl.addCircularWall(new CircularWall(wallWidth+(wallWidth/2) ,width/8*7 - wallWidth/2, height/16*7));//9

        lvl.addHole(new Hole(width/8*7-wallWidth,height/16*4,wallWidth,wallWidth));//10

        lvl.addWall(new Wall(0, height/16*5, width/8*2,wallWidth));//11
        lvl.addWall(new Wall(width/8*2+wallWidth*2, height/16*5, width/16*3,wallWidth));//12

        lvl.addHole(new Hole(width/8*2+wallWidth/2, height/16*5,wallWidth,wallWidth));//13

        lvl.addWall(new Wall(width/8*5, height/14*10, width, wallWidth ));;//14
        lvl.addCircularWall(new CircularWall(wallWidth+(wallWidth/2) ,width, height/14*10+wallWidth/2));//15

        lvl.addCircularWall(new CircularWall(wallWidth+(wallWidth/2) ,width/2, height/14*13));//16

        lvl.addAim(new Aim( width/16*15, height/14*12,wallWidth*2, wallWidth*2));//17

        lvl.addHole(new Hole(width/8*5, height/14*13,wallWidth,wallWidth));//18
        lvl.addHole(new Hole(width/16*14, height/14*11,wallWidth,wallWidth));//19

        lvl.addAim(new Aim( width/16, height/14*12,wallWidth*2, wallWidth*2));//20
        lvl.addHole(new Hole(width/16, height/14*10,wallWidth,wallWidth));//21
        lvl.addHole(new Hole(width/16*3, height/14*13,wallWidth,wallWidth));//22

        lvl.addWall(new Wall(width/16*5, height/14*10, wallWidth, height ));;//23
        lvl.addCircularWall(new CircularWall(wallWidth +wallWidth/2,width/16*5+wallWidth/2,height/14*10 ));//24

        return lvl;
    }
    /**
     *
     * @param height Height of level in pixels
     * @param width Width of level in pixels
     */
    public static Level Level3(int height, int width){
        Level lvl = new Level(height, width);
        int wallWidth = width/100 * 5; // 5%
        lvl.addWall(new Wall(width/2 -(wallWidth/2), height/100*30, wallWidth, height));
        int aimSize = height/100*5;
        lvl.addAim(new Aim(width-aimSize*2,aimSize,aimSize, aimSize));
        return lvl;
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

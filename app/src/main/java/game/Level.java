package game;

import android.graphics.Rect;

import java.util.Vector;

import game.atitude.collision.ColBordAmorti;
import game.atitude.collision.ColObjectAmorti;
import game.atitude.collision.ColObjectRebondi;
import game.atitude.mouvement.MvtSensor;
import game.atitude.mouvement.MvtVitesseRalentieSiPasAcceleration;
import game.object.circle.Aim;
import game.object.circle.Ball;
import game.object.circle.CircularWall;
import game.object.circle.Hole;
//import game.object.rectangle.Cannon;
import game.object.rectangle.Cannon;
import game.object.rectangle.Wall;

public class Level {

    private Vector<AbstractGameObject> _objets;
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
        this._objets = new Vector<AbstractGameObject>();
        movementBounds = new Rect(0, 0, width, height);
    }

    //objets
    public Vector<AbstractGameObject> get_objets() {
        return _objets;
    }

    public void set_objets(Vector<AbstractGameObject> _objets) {
        this._objets = _objets;
    }
    //MovementsBounds
    public Rect getMovementBounds() {
        return this.movementBounds;
    }
    //WorldHeight
    public int getWorldHeight() {
        return worldHeight;
    }

    public void setWorldHeight(int worldHeight) {
        this.worldHeight = worldHeight;
    }
    //WorldWidth
    public int getWorldWidth() {
        return worldWidth;
    }

    public void setWorldWidth(int worldWidth) {
        this.worldWidth = worldWidth;
    }

    public void add(AbstractGameObject abstractGameObject){
        _objets.add(abstractGameObject);
    }

    /**
     * @param height Height of level in pixels
     * @param width  Width of level in pixels
     */
    public static Level Level1(int height, int width) {

        int pHeight = height / 100;
        int pWidth = width / 100;

        Level lvl = new Level(height, width);


        AbstractGameObject ball = new Ball(pHeight*5, 0, 0, 5.0);
        ball = new MvtSensor(ball);
        ball = new MvtVitesseRalentieSiPasAcceleration(ball);
        ball = new ColBordAmorti(ball);
        ball = new ColObjectAmorti(ball);
        lvl.add(ball);

        //x, y, height, width



        //                  posX                posY                    height              width
        lvl.add(new Wall(   pWidth*20,          0,                      pHeight*70,         pWidth*5));
        lvl.add(new Wall(   pWidth*80,          height-pHeight*70,      pHeight*70,         pWidth*5));
        //                  radius              posX                    posY
        lvl.add(new Hole(   pHeight*5,          pWidth*30,              pHeight*50));
        lvl.add(new Hole(   pHeight*5,          pWidth*60,              pHeight*50));
        lvl.add(new Aim(    pHeight * 5,        width - pHeight * 15,   height - pHeight * 15));
        return lvl;
    }

    /**
     * @param height Height of level in pixels
     * @param width  Width of level in pixels
     */
    public static Level Level2(int height, int width) {
        int pHeight = height / 100;
        int pWidth = width / 100;

        Level lvl = new Level(height, width);

        AbstractGameObject ball = new Ball(pHeight*3, 0, 0, 5.0);//radius, x, y, masse
        ball = new MvtSensor(ball);
       ball = new MvtVitesseRalentieSiPasAcceleration(ball);
        ball = new ColBordAmorti(ball);
        ball = new ColObjectAmorti(ball);
        lvl.add(ball);

        int wallWidth = pHeight * 5;
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
        //
        return lvl;
    }

    /**
     * @param height Height of level in pixels
     * @param width  Width of level in pixels
     */
    public static Level Level3(int height, int width) {
        int pHeight = height / 100;
        int pWidth = width / 100;

        Level lvl = new Level(height, width);
        int wallWidth = width / 100 * 5; // 5%
        int cannonWidth = width / 100 * 10; // 10%
        int cannonHeight =cannonWidth /2;
        int aimSize = height / 100 * 5;
        int aimX = width - aimSize * 2;
        int aimY = aimSize;


        AbstractGameObject ball = new Ball(pHeight*3, 0, 0, 5.0);//radius, x, y, masse
        ball = new MvtSensor(ball);
        ball = new MvtVitesseRalentieSiPasAcceleration(ball);
        ball = new ColBordAmorti(ball);
        ball = new ColObjectAmorti(ball);
        lvl.add(ball);

        lvl.add(new Wall(width / 2 - (wallWidth / 2), height / 100 * 30, height, wallWidth));
        lvl.add(new Aim(aimSize, aimX, aimY));
        lvl.add(new Cannon(width /3, height/ 2, cannonWidth, cannonHeight, 0, 0 , lvl.get_objets(), width, height));//posX, posY, width, height, cibleX, cibleY
        return lvl;
    }
}

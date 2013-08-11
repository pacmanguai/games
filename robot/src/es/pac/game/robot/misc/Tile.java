package es.pac.game.robot.misc;

import java.awt.Image;

import es.pac.game.robot.Background;
import es.pac.game.robot.StartingClass;

public class Tile {

    private int tileX, tileY, speedX;
    private final int type;
    public Image tileImage;

    private final Background bg = StartingClass.getBg1();

    public Tile(int x, int y, int typeInt) {
        tileX = x * 40;
        tileY = y * 40;

        type = typeInt;

        switch (type) {
        case 5:
            tileImage = StartingClass.tiledirt;
            break;
        case 8:
            tileImage = StartingClass.tilegrassTop;
            break;
        case 4:
            tileImage = StartingClass.tilegrassLeft;
            break;
        case 6:
            tileImage = StartingClass.tilegrassRight;
            break;
        case 2:
            tileImage = StartingClass.tilegrassBot;
        }

    }

    public void update() {
        // TODO Auto-generated method stub
        if (type == 1) {
            if (bg.getSpeedX() == 0) {
                speedX = -1;
            } else {
                speedX = -2;
            }

        } else {
            speedX = bg.getSpeedX() * 5;
        }

        tileX += speedX;
    }

    public int getTileX() {
        return tileX;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }

    public Image getTileImage() {
        return tileImage;
    }

    public void setTileImage(Image tileImage) {
        this.tileImage = tileImage;
    }

}
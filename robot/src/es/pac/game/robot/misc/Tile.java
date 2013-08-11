package es.pac.game.robot.misc;

import java.awt.Image;
import java.awt.Rectangle;

import es.pac.game.robot.Background;
import es.pac.game.robot.StartingClass;
import es.pac.game.robot.character.Robot;

public class Tile {

	private int tileX, tileY, speedX;
	private int type;
	public Image tileImage;

	private final Background bg = StartingClass.getBg1();

	private Robot robot = StartingClass.getRobot();

	private Rectangle r;

	public Tile(int x, int y, int typeInt) {
		tileX = x * 40;
		tileY = y * 40;

		type = typeInt;

		r = new Rectangle();

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
			break;	
		default:
			type = 0;
		}
		
			

	}

	public void update() {
		speedX = bg.getSpeedX() * 5;

		tileX += speedX;

		r.setBounds(tileX, tileY, 40, 40);

		if (r.intersects(Robot.yellowRed) && type != 0) {
			checkVerticalCollision(Robot.rect, Robot.rect2);
			checkSideCollision(Robot.rect3, Robot.rect4, Robot.footleft, Robot.footright);
		}
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

	public void checkVerticalCollision(Rectangle rtop, Rectangle rbot) {
        if (rtop.intersects(r)) {
            
        }

        if (rbot.intersects(r) && type == 8) {
            robot.setJumped(false);
            robot.setSpeedY(0);
            robot.setCenterY(tileY - 63);
        }
    }
	
	public void checkSideCollision(Rectangle rleft, Rectangle rright, Rectangle leftfoot, Rectangle rightfoot) {
        if (type != 5 && type != 2 && type != 0){
            if (rleft.intersects(r)) {
                robot.setCenterX(tileX + 102);
    
                robot.setSpeedX(0);
    
            }else if (leftfoot.intersects(r)) {
                robot.setCenterX(tileX + 85);
                robot.setSpeedX(0);
            }
            
            if (rright.intersects(r)) {
                robot.setCenterX(tileX - 62);
    
                robot.setSpeedX(0);
            }
            
            else if (rightfoot.intersects(r)) {
                robot.setCenterX(tileX - 45);
                robot.setSpeedX(0);
            }
        }	
	}

}
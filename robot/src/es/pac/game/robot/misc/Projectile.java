package es.pac.game.robot.misc;

import java.awt.Rectangle;

import es.pac.game.robot.StartingClass;

public class Projectile {

    private int x;
    private final int y;
    private final int speedX;
    private boolean visible;
    private Rectangle r;

    public Projectile(int startX, int startY) {
        x = startX;
        y = startY;
        speedX = 7;
        visible = true;
        
        r = new Rectangle(0, 0, 0, 0);
    }

    public void update() {
        x += speedX;
        r.setBounds(x, y, 10, 5);
        if (x > 800) {
            visible = false;
            r = null;
        }
        if (x < 800){
			checkCollision();
		}

    }
    
    private void checkCollision() {
		if(r.intersects(StartingClass.hb.r)){
			visible = false;
			if (StartingClass.hb.health > 0) {
				StartingClass.hb.health -= 1;
			}
			if (StartingClass.hb.health == 0) {
				StartingClass.hb.setCenterX(-100);
				StartingClass.score += 5;


			}			
		}
		
		if (r.intersects(StartingClass.hb2.r)){
			visible = false;
			if (StartingClass.hb2.health > 0) {
				StartingClass.hb2.health -= 1;
			}
			if (StartingClass.hb2.health == 0) {
				StartingClass.hb2.setCenterX(-100);
				StartingClass.score += 5;


			}



		}
	}


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getY() {
        return y;
    }

    public int getSpeedX() {
        return speedX;
    }

}

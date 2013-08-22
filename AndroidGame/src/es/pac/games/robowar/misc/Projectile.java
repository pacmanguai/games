package es.pac.games.robowar.misc;

import java.util.List;

import android.graphics.Rect;
import es.pac.games.robowar.character.Character;
import es.pac.games.robowar.character.Enemy;
import es.pac.games.robowar.screens.GameScreen;


public class Projectile {

	private int x, y, speedX;
	private boolean visible;
	private int targetX, targetY;

	private Rect r;

	public Projectile(int startX, int startY, int targetX, int targetY) {
		x = startX;
		y = startY;
		this.targetX = targetX;
		this.targetY = targetY;
		speedX = 7;
		visible = true;

		r = new Rect(0, 0, 0, 0);
	}

	public void update(Character target) {
		// y=(Q.y-P.y)/(Q.x-P.x)*(x-P.x)+P.y
		int posX = (x > targetX?x -speedX:x+speedX);		
		int posY = (targetY-y) / (targetX-x) * (posX-x) + y;	
		x = posX;
		y = posY;
				
		r.set(x, y, x + 10, y + 5);
		if (x > 800) {
			visible = false;
			r = null;
		}
		if (x < 800) {
			checkCollision(target);
		}
	}
	
	public void update(List<Enemy> targets) {
		for (Character target:targets) {
			// y=(Q.y-P.y)/(Q.x-P.x)*(x-P.x)+P.y
			int posX = (x > targetX?x -speedX:x+speedX);		
			int posY = (targetY-y) / (targetX-x) * (posX-x) + y;	
			x = posX;
			y = posY;
					
			r.set(x, y, x + 10, y + 5);
			if (x > 800) {
				visible = false;
				r = null;
			}
			if (x < 800) {
				checkCollision(target);
			}
		}
	}

	private void checkCollision(List<Character> targets) {
				
		for (Character target:targets) {
			
			if (Rect.intersects(r, target.getRect())) {
				visible = false;

				if (target.getHealth() > 0) {
					target.setHealth(target.getHealth() - 1);
				}
				if (target.getHealth() == 0) {
					target.setCenterX(-100);

				}

			}
			
		}
		
	}
	
	private void checkCollision(Character target) {
		
		if (Rect.intersects(r, target.getRect())) {
			visible = false;

			if (target.getHealth() > 0) {
				target.setHealth(target.getHealth() - 1);
			}
			if (target.getHealth() == 0) {
				target.setCenterX(-100);

			}

		}
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getTargetX() {
		return targetX;
	}

	public void setTargetX(int targetX) {
		this.targetX = targetX;
	}

	public int getTargetY() {
		return targetY;
	}

	public void setTargetY(int targetY) {
		this.targetY = targetY;
	}		

}

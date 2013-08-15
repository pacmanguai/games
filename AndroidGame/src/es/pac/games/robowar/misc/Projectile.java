package es.pac.games.robowar.misc;

import android.graphics.Rect;
import es.pac.games.robowar.character.Enemy;
import es.pac.games.robowar.screens.GameScreen;

public class Projectile {

	private int x, y, speedX;
	private boolean visible;

	private Rect r;

	public Projectile(int startX, int startY) {
		x = startX;
		y = startY;
		speedX = 7;
		visible = true;

		r = new Rect(0, 0, 0, 0);
	}

	public void update() {
		x += speedX;
		r.set(x, y, x + 10, y + 5);
		if (x > 800) {
			visible = false;
			r = null;
		}
		if (x < 800) {
			checkCollision();
		}
	}

	private void checkCollision() {
		
		
		for (Enemy enemy:GameScreen.enemies) {
			
			if (Rect.intersects(r, enemy.r)) {
				visible = false;

				if (enemy.health > 0) {
					enemy.health -= 1;
				}
				if (enemy.health == 0) {
					enemy.setCenterX(-100);

				}

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

}

package es.pac.games.robowar.character;

import java.util.ArrayList;

import android.graphics.Rect;
import es.pac.games.robowar.Background;
import es.pac.games.robowar.misc.Projectile;
import es.pac.games.robowar.screens.GameScreen;

public class Robot extends Character {
	// Constants are Here
	final static int JUMPSPEED = -15;
	final static int MOVESPEED = 5;
	final static int X_BOUND = 2000;
	
	private boolean jumped = false;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean ducked = false;
	private boolean readyToFire = true;
	
	public Rect rect2 = new Rect(0, 0, 0, 0);
	public Rect rect3 = new Rect(0, 0, 0, 0);
	public Rect rect4 = new Rect(0, 0, 0, 0);
	public Rect yellowRed = new Rect(0, 0, 0, 0);
	public Rect footleft = new Rect(0, 0, 0, 0);
	public Rect footright = new Rect(0, 0, 0, 0);

	private Background bg1 = GameScreen.getBg1();
	private Background bg2 = GameScreen.getBg2();

	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	public Robot() {
		centerX = 100;
		centerY = 377;
		speedX = 0;
		speedY = 0;
	}

	public void update() {
		// Moves Character or Scrolls Background accordingly.

		if (speedX < 0) {
			centerX += speedX;
		}
		if (speedX == 0 || speedX < 0) {
			bg1.setSpeedX(0);
			bg2.setSpeedX(0);

		}
		if (centerX <= 200 && speedX > 0) {
			centerX += speedX;
		}
		if (speedX > 0 && centerX > 200) {
			bg1.setSpeedX(-MOVESPEED / 5);
			bg2.setSpeedX(-MOVESPEED / 5);
		}

		// Updates Y Position
		centerY += speedY;

		// Handles Jumping

		speedY += 1;

		if (speedY > 3) {
			jumped = true;
		}

		// Prevents going beyond X coordinate of 0
		if (centerX + speedX <= 60) {
			centerX = 61;
		}

		rect.set(centerX - 34, centerY - 63, centerX + 34, centerY);
		rect2.set(rect.left, rect.top + 63, rect.left + 68, rect.top + 128);
		rect3.set(rect.left - 26, rect.top + 32, rect.left, rect.top + 52);
		rect4.set(rect.left + 68, rect.top + 32, rect.left + 94, rect.top + 52);
		yellowRed.set(centerX - 110, centerY - 110, centerX + 70, centerY + 70);
		footleft.set(centerX - 50, centerY + 20, centerX, centerY + 35);
		footright.set(centerX, centerY + 20, centerX + 50, centerY + 35);

	}

	public void moveRight() {
		if (ducked == false) {
			speedX = MOVESPEED;
		}
	}

	public void moveLeft() {
		if (ducked == false) {
			speedX = -MOVESPEED;
		}
	}

	public void stopRight() {
		setMovingRight(false);
		stop();
	}

	public void stopLeft() {
		setMovingLeft(false);
		stop();
	}

	private void stop() {
		if (isMovingRight() == false && isMovingLeft() == false) {
			speedX = 0;
		}

		if (isMovingRight() == false && isMovingLeft() == true) {
			moveLeft();
		}

		if (isMovingRight() == true && isMovingLeft() == false) {
			moveRight();
		}

	}

	public void jump() {
		if (jumped == false) {
			speedY = JUMPSPEED;
			jumped = true;
		}

	}

	public void shoot() {
		if (readyToFire) {
			Projectile p = new Projectile(centerX + 50, centerY - 25, centerX + X_BOUND, centerY - 25);
			projectiles.add(p);
		}
	}

	public boolean isJumped() {
		return jumped;
	}


	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public boolean isDucked() {
		return ducked;
	}

	public void setDucked(boolean ducked) {
		this.ducked = ducked;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public ArrayList getProjectiles() {
		return projectiles;
	}

	public boolean isReadyToFire() {
		return readyToFire;
	}

	public void setReadyToFire(boolean readyToFire) {
		this.readyToFire = readyToFire;
	}

	public Rect getRect2() {
		return rect2;
	}

	public void setRect2(Rect rect2) {
		this.rect2 = rect2;
	}

	public Rect getRect3() {
		return rect3;
	}

	public void setRect3(Rect rect3) {
		this.rect3 = rect3;
	}

	public Rect getRect4() {
		return rect4;
	}

	public void setRect4(Rect rect4) {
		this.rect4 = rect4;
	}

	public Rect getYellowRed() {
		return yellowRed;
	}

	public void setYellowRed(Rect yellowRed) {
		this.yellowRed = yellowRed;
	}

	public Rect getFootleft() {
		return footleft;
	}

	public void setFootleft(Rect footleft) {
		this.footleft = footleft;
	}

	public Rect getFootright() {
		return footright;
	}

	public void setFootright(Rect footright) {
		this.footright = footright;
	}	

}

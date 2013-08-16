package es.pac.games.robowar.character;

import java.util.ArrayList;

import android.graphics.Rect;
import es.pac.games.framework.Graphics;
import es.pac.games.robowar.Background;
import es.pac.games.robowar.misc.Projectile;
import es.pac.games.robowar.screens.GameScreen;

public class Enemy {
		
	private int power, centerX, speedX, centerY;
	private Background bg = GameScreen.getBg1();
	private Robot robot = GameScreen.getRobot();

	public Rect r = new Rect(0, 0, 0, 0);
	public int health = 5;

	private int movementSpeed;

	protected ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	protected boolean readyToAtack = true;
	protected boolean isShooter = false;

	// Behavioral Methods
	public void update() {
		follow();
		centerX += speedX;
		speedX = bg.getSpeedX() * 5 + movementSpeed;
		r.set(centerX - 25, centerY - 25, centerX + 25, centerY + 35);

		if (Rect.intersects(r, Robot.yellowRed)) {
			checkCollision();			
		}				

	}

	private void checkCollision() {
		if (Rect.intersects(r, Robot.rect) || Rect.intersects(r, Robot.rect2)
				|| Rect.intersects(r, Robot.rect3)
				|| Rect.intersects(r, Robot.rect4)) {

		}
	}

	public void follow() {

		if (centerX < -95 || centerX > 810) {
			movementSpeed = 0;
		}

		else if (Math.abs(robot.getCenterX() - centerX) < 5) {
			movementSpeed = 0;
		}

		else {

			if (robot.getCenterX() >= centerX) {
				movementSpeed = 1;
			} else {
				movementSpeed = -1;
			}
		}

	}

	public void die() {
	}

	public void attack() {		

	}
	
	public void paintProjectil(Graphics g) {
		
	}		
	

	public int getPower() {
		return power;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public Background getBg() {
		return bg;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

	public boolean isReadyToAtack() {
		return readyToAtack;
	}

	public void setReadyToAtack(boolean readyToAtack) {
		this.readyToAtack = readyToAtack;
	}

	public boolean isShooter() {
		return isShooter;
	}

	public void setShooter(boolean isShooter) {
		this.isShooter = isShooter;
	}

	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}

	public void setProjectiles(ArrayList<Projectile> projectiles) {
		this.projectiles = projectiles;
	}

	

}

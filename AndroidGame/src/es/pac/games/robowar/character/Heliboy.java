package es.pac.games.robowar.character;

import java.util.ArrayList;

import android.graphics.Color;

import es.pac.games.framework.Graphics;
import es.pac.games.robowar.misc.Projectile;

public class Heliboy extends Enemy {

	private static final int ATACK_RANGE = 100;

	public Heliboy(int centerX, int centerY) {
		setCenterX(centerX);
		setCenterY(centerY);
		setShooter(true);
	}

	@Override
	public void attack() {

		// Check range with Robot
		if (Math.abs(Robot.rect.centerX() - this.getCenterX()) < ATACK_RANGE) {
			readyToAtack = true;
		} else {
			readyToAtack = false;
		}

		if (readyToAtack) {
			if (isShooter) {
				Projectile p = new Projectile(getCenterX() + 50,
						getCenterY() - 25);
				projectiles.add(p);
			}
		}
		
		super.attack();

	}

	@Override
	public void update() {

		if (readyToAtack) {
			ArrayList projectiles = getProjectiles();
			for (int i = 0; i < projectiles.size(); i++) {
				Projectile p = (Projectile) projectiles.get(i);
				if (p.isVisible() == true) {
					p.update();
				} else {
					projectiles.remove(i);
				}
			}
		}

		super.update();
	}

	@Override
	public void paintProjectil(Graphics g) {
		ArrayList enemyProjectiles = getProjectiles();
		for (int i = 0; i < enemyProjectiles.size(); i++) {
			Projectile p = (Projectile) enemyProjectiles.get(i);
			g.drawRect(p.getX(), p.getY(), 10, 5, Color.BLUE);
		}
		super.paintProjectil(g);
	}
	
	

}

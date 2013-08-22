package es.pac.games.robowar.character;

import java.util.ArrayList;

import android.graphics.Color;

import es.pac.games.framework.Graphics;
import es.pac.games.robowar.misc.Projectile;

public class Heliboy extends Enemy {

	private static final int ATACK_RANGE = 200;
	private static final int MAX_PROJECTILE = 1;

	public Heliboy(int centerX, int centerY) {
		setCenterX(centerX);
		setCenterY(centerY);
		setShooter(true);
        setHealth(5);
	}

	@Override
	public void attack(Character target) {

		// Check range with Robot
		if (Math.abs(target.rect.centerX() - this.getCenterX()) < ATACK_RANGE) {
			readyToAtack = true;
		} else {
			readyToAtack = false;
		}

		if (readyToAtack) {
			if (isShooter && projectiles.size() <= MAX_PROJECTILE) {
				Projectile p = new Projectile(getCenterX() + 50,
						getCenterY() - 25, target.rect.centerX(),
						target.rect.centerY());
				projectiles.add(p);
			}
		}

		super.attack(target);

	}

	@Override
	public void update(Character target) {

		if (readyToAtack) {
			ArrayList projectiles = getProjectiles();
			for (int i = 0; i < projectiles.size(); i++) {
				Projectile p = (Projectile) projectiles.get(i);
				if (p.isVisible() == true) {
					p.update(target);
				} else {
					projectiles.remove(i);
				}
			}
		}

		super.update(target);
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

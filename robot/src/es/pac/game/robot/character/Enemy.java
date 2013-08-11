package es.pac.game.robot.character;

import es.pac.game.robot.Background;
import es.pac.game.robot.StartingClass;

public class Enemy {

    private int maxHealth;
    private int currentHealth;
    private int power;
    private int speedX;
    private int centerX;
    private int centerY;

    private final Background bg = StartingClass.getBg1();

    // Behavioral Methods
    public void update() {
        centerX += speedX;
        speedX = bg.getSpeedX() * 5;
    }

    public void die() {
    }

    public void attack() {
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public Background getBg() {
        return bg;
    }

}

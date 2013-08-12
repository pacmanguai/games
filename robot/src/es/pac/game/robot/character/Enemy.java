package es.pac.game.robot.character;

import java.awt.Rectangle;

import es.pac.game.robot.Background;
import es.pac.game.robot.StartingClass;

public class Enemy {

    private int power;
    private int speedX;
    private int centerX;
    private int centerY;

    private final Background bg = StartingClass.getBg1();
    private final Robot robot = StartingClass.getRobot();

    private int movementSpeed;

    public int health = 5;

    public Rectangle r = new Rectangle(0, 0, 0, 0);

    // Behavioral Methods
    public void update() {
        follow();
        centerX += speedX;
        speedX = bg.getSpeedX() * 5 + movementSpeed;

        r.setBounds(centerX - 25, centerY - 25, 50, 60);

        if (r.intersects(Robot.yellowRed)) {
            checkCollision();
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

    private void checkCollision() {
        if (r.intersects(Robot.rect) || r.intersects(Robot.rect2) || r.intersects(Robot.rect3)
                || r.intersects(Robot.rect4)) {
            System.out.println("collision");

        }
    }

    public void die() {
    }

    public void attack() {
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

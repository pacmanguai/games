package es.pac.game.robot.misc;

public class Projectile {

    private int x;
    private final int y;
    private final int speedX;
    private boolean visible;

    public Projectile(int startX, int startY) {
        x = startX;
        y = startY;
        speedX = 7;
        visible = true;
    }

    public void update() {
        x += speedX;
        if (x > 800) {
            visible = false;
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

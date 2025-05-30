import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    private int x;
    private int y;
    private int radius;
    private int dx;
    private int dy;

    public Ball(int x, int y, int radius, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.dx = dx;
        this.dy = dy;
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}

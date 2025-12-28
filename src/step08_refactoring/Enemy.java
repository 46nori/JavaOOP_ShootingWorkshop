package step08_refactoring;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
    // 定数 (Constant): マジックナンバーを排除
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    private double x;
    private double y;
    private double angle;
    private double speed;
    private int size = 40;

    public Enemy(double startX, double startY, double startAngle, double startSpeed) {
        this.x = startX;
        this.y = startY;
        this.angle = startAngle;
        this.speed = startSpeed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Setterに「保護」のロジックを追加
    public void setX(double x) {
        if (x < 0) {
            this.x = 0;
        } else if (x > WINDOW_WIDTH) {
            this.x = WINDOW_WIDTH;
        } else {
            this.x = x;
        }
    }

    public void setY(double y) {
        if (y < 0) {
            this.y = 0;
        } else if (y > WINDOW_HEIGHT) {
            this.y = WINDOW_HEIGHT;
        } else {
            this.y = y;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)x, (int)y, size, size);
    }

    public void erase(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int)x, (int)y, size, size);
    }

    public void move() {
        double rad = Math.toRadians(angle);
        x += Math.cos(rad) * speed;
        y += Math.sin(rad) * speed;

        // 定数を使って判定
        if (x > WINDOW_WIDTH) x = 0;
        if (y > WINDOW_HEIGHT) y = 0;
    }
}

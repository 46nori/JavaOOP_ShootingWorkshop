package step06_polymorphism;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
    double x;
    double y;
    double angle;
    double speed;
    int size = 40;

    public Enemy(double startX, double startY, double startAngle, double startSpeed) {
        x = startX;
        y = startY;
        angle = startAngle;
        speed = startSpeed;
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

        if (x > 800) x = 0;
        if (y > 600) y = 0;
    }
}

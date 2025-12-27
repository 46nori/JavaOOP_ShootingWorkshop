package step06_polymorphism;

import java.awt.Color;
import java.awt.Graphics;

public class WavyEnemy extends Enemy {

    public WavyEnemy(double startX, double startY, double startAngle, double startSpeed) {
        super(startX, startY, startAngle, startSpeed);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval((int)x, (int)y, size, size);
    }

    @Override
    public void move() {
        super.move();
        y += Math.sin(x * 0.05) * 5;
    }
}

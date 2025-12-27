package step06_polymorphism;

import java.awt.Color;
import java.awt.Graphics;

public class StraightEnemy extends Enemy {

    public StraightEnemy(double startX, double startY, double startAngle, double startSpeed) {
        super(startX, startY, startAngle, startSpeed);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval((int)x, (int)y, size, size);
    }
}

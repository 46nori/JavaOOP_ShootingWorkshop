package step07_encapsulation;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
    // フィールドをprivateにして、外部から勝手に書き換えられないようにする
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

    // Getter (値を取得するメソッド)
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Setter (値を設定するメソッド)
    // 必要なければ作らないことで、読み取り専用にできる
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
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

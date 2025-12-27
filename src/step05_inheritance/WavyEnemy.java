package step05_inheritance;

import java.awt.Color;
import java.awt.Graphics;

public class WavyEnemy extends Enemy {

    public WavyEnemy(double startX, double startY, double startAngle, double startSpeed) {
        super(startX, startY, startAngle, startSpeed);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN); // 波打つ敵は緑
        g.fillOval((int)x, (int)y, size, size);
    }

    @Override
    public void move() {
        // 親クラスのmove（直進）を呼び出しつつ、独自の動きを追加
        // ここでは単純にY座標を揺らしてみます
        super.move();
        y += Math.sin(x * 0.05) * 5; // 波打つ動き
    }
}

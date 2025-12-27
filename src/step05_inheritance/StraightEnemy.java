package step05_inheritance;

import java.awt.Color;
import java.awt.Graphics;

public class StraightEnemy extends Enemy {

    public StraightEnemy(double startX, double startY, double startAngle, double startSpeed) {
        // 親クラス(Enemy)のコンストラクタを呼び出す
        super(startX, startY, startAngle, startSpeed);
    }

    // moveメソッドは親クラスのものをそのまま使うので、書かなくてもOK
    // 色を変えたい場合はdrawをオーバーライドできます
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE); // 直進する敵は青
        g.fillOval((int)x, (int)y, size, size);
    }
}

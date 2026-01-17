package step09_advanced_challenge;

import java.awt.Color;

public class StraightEnemy extends Enemy {

    public StraightEnemy(double x, double y, double angle, double speed, double radius) {
        super(x, y, angle, speed, radius);
        this.color = Color.CYAN; // 色を変える
    }

    // 直進する敵は、基本の物理挙動(Enemy.move)だけでOK
    // 特別な動きを追加したい場合はここに書く
}

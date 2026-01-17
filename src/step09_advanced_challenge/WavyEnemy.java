package step09_advanced_challenge;

import java.awt.Color;

public class WavyEnemy extends Enemy {
    
    private int frameCount = 0;

    public WavyEnemy(double x, double y, double angle, double speed, double radius) {
        super(x, y, angle, speed, radius);
        this.color = Color.MAGENTA;
    }

    @Override
    public void move() {
        // 進行方向を揺らす（スネーク運動）
        frameCount++;
        
        // 1. 現在の速度ベクトルから、速さと角度を求める
        double speed = Math.sqrt(vx * vx + vy * vy);
        double currentAngle = Math.atan2(vy, vx);
        
        // 2. 角度に周期的な変化を加える
        // sinの値によって、左に曲がったり右に曲がったりする
        double angleChange = Math.sin(frameCount * 0.1) * 0.1; // 振幅を調整
        
        double newAngle = currentAngle + angleChange;
        
        // 3. 速度ベクトルを再計算して更新
        vx = Math.cos(newAngle) * speed;
        vy = Math.sin(newAngle) * speed;

        // 4. 親クラスの移動処理（位置更新＋壁反射）を実行
        super.move();
    }
}

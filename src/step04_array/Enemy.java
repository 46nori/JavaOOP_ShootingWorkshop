package step04_array;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
    // フィールド (メンバ変数)
    // ここで初期値を入れることもできます
    double x;
    double y;
    double angle;
    double speed;
    int size = 40; // 円のサイズ

    // コンストラクタ (初期化メソッド)
    // クラス名と同じ名前にします。戻り値は書きません。
    public Enemy(double startX, double startY, double startAngle, double startSpeed) {
        x = startX;
        y = startY;
        angle = startAngle;
        speed = startSpeed;
    }

    // 表示メソッド
    // Graphicsという「絵筆」を受け取って描画します
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        // fillOval(x, y, width, height)
        // 座標はint型(整数)である必要があるため、(int)をつけて変換します
        g.fillOval((int)x, (int)y, size, size);
    }

    // 消去メソッド
    // 背景色(白)で上書きして消します
    public void erase(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int)x, (int)y, size, size);
    }

    // 移動メソッド
    public void move() {
        // 角度(度数法)をラジアンに変換
        double rad = Math.toRadians(angle);
        
        // 三角関数で成分分解し、移動距離(speed)を掛けて、次の表示位置(座標)を更新
        x += Math.cos(rad) * speed;
        y += Math.sin(rad) * speed;

        // 画面端での跳ね返りなどを追加しても良いですね
        if (x > 800) x = 0;
        if (y > 600) y = 0;
    }
}

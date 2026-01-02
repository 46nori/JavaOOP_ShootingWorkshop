package advanced_challenge;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
    // 定数
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    // フィールド (物理演算のためにベクトル vx, vy で管理)
    protected double x;
    protected double y;
    protected double vx; // X方向の速度
    protected double vy; // Y方向の速度
    protected double radius; // 半径
    protected double mass;   // 質量 (半径の2乗に比例)
    protected Color color;

    public Enemy(double x, double y, double angle, double speed, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        
        // 角度と速さから、速度ベクトル(vx, vy)を計算
        double rad = Math.toRadians(angle);
        this.vx = Math.cos(rad) * speed;
        this.vy = Math.sin(rad) * speed;

        // 質量は面積（半径×半径）に比例させると自然な挙動になる
        this.mass = radius * radius;
        
        this.color = Color.RED;
    }

    public void move() {
        // 1. 移動
        x += vx;
        y += vy;

        // 2. 壁での反射 (要件2)
        // 左端
        if (x < radius) {
            x = radius;      // めり込み補正
            vx = -vx;        // 速度反転
        }
        // 右端
        if (x > WINDOW_WIDTH - radius) {
            x = WINDOW_WIDTH - radius;
            vx = -vx;
        }
        // 上端
        if (y < radius) {
            y = radius;
            vy = -vy;
        }
        // 下端
        if (y > WINDOW_HEIGHT - radius) {
            y = WINDOW_HEIGHT - radius;
            vy = -vy;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        // fillOvalは左上の座標を指定するので、中心座標から半径分ずらす
        int drawX = (int)(x - radius);
        int drawY = (int)(y - radius);
        int diameter = (int)(radius * 2);
        g.fillOval(drawX, drawY, diameter, diameter);
    }

    // 衝突判定と応答 (要件3)
    public void collideWith(Enemy other) {
        // 1. 距離の計算
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        // 2. 衝突判定 (2つの半径の和より距離が近ければ衝突)
        if (distance < this.radius + other.radius) {
            
            // 3. 物理演算による反発 (完全弾性衝突)
            
            // 法線ベクトル (衝突軸)
            double nx = dx / distance;
            double ny = dy / distance;

            // 接線ベクトル (法線に垂直)
            double tx = -ny;
            double ty = nx;

            // 現在の速度を、法線方向と接線方向に分解 (内積)
            double v1n = this.vx * nx + this.vy * ny;
            double v1t = this.vx * tx + this.vy * ty;
            
            double other_v2n = other.vx * nx + other.vy * ny;
            double other_v2t = other.vx * tx + other.vy * ty;

            // 1次元の衝突式を法線成分に適用
            // v1' = ((m1 - m2)v1 + 2m2v2) / (m1 + m2)
            double m1 = this.mass;
            double m2 = other.mass;

            double v1n_new = ((m1 - m2) * v1n + 2 * m2 * other_v2n) / (m1 + m2);
            double v2n_new = ((m2 - m1) * other_v2n + 2 * m1 * v1n) / (m1 + m2);

            // 接線成分は変わらない (摩擦なし)
            
            // 新しい速度ベクトルを合成
            this.vx = v1n_new * nx + v1t * tx;
            this.vy = v1n_new * ny + v1t * ty;
            
            other.vx = v2n_new * nx + other_v2t * tx;
            other.vy = v2n_new * ny + other_v2t * ty;

            // 4. めり込み防止 (位置補正)
            // 衝突した瞬間、少し重なっているので、重なった分だけお互いを押し戻す
            double overlap = (this.radius + other.radius) - distance;
            double moveX = overlap * nx / 2;
            double moveY = overlap * ny / 2;

            this.x -= moveX;
            this.y -= moveY;
            other.x += moveX;
            other.y += moveY;
        }
    }
}

package step09_advanced_challenge;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class GameMain extends JFrame {
    
    // ダブルバッファリング用
    private Image offScreenImage;
    private Graphics offScreenGraphics;

    public static void main(String[] args) {
        new GameMain();
    }

    public GameMain() {
        this.setTitle("Shooting Game - Advanced Challenge (Physics)");
        this.setSize(Enemy.WINDOW_WIDTH, Enemy.WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // 敵の生成
        int enemyCount = 15;
        Enemy[] enemies = new Enemy[enemyCount];

        for (int i = 0; i < enemies.length; i++) {
            // ランダムな初期値
            double x = Math.random() * (Enemy.WINDOW_WIDTH - 100) + 50;
            double y = Math.random() * (Enemy.WINDOW_HEIGHT - 100) + 50;
            double angle = Math.random() * 360;
            double speed = 2.0 + Math.random() * 4.0;
            
            // 要件1: サイズの初期値はランダム (10〜40)
            double radius = 10 + Math.random() * 30;

            // 半分は直進、半分は波打ち（今回は色違い程度）
            if (i % 2 == 0) {
                enemies[i] = new StraightEnemy(x, y, angle, speed, radius);
            } else {
                enemies[i] = new WavyEnemy(x, y, angle, speed, radius);
            }
        }

        // ゲームループ
        while (true) {
            // 1. 移動 (Move)
            for (Enemy e : enemies) {
                e.move();
            }

            // 2. 衝突判定 (Collision) - 要件3
            // 全ての組み合わせをチェック (自分自身とは判定しない)
            for (int i = 0; i < enemies.length; i++) {
                for (int j = i + 1; j < enemies.length; j++) {
                    enemies[i].collideWith(enemies[j]);
                }
            }

            // 3. 描画 (Draw) - ダブルバッファリングでチラつき防止
            if (offScreenImage == null) {
                offScreenImage = createImage(getWidth(), getHeight());
                offScreenGraphics = offScreenImage.getGraphics();
            }
            
            // 背景クリア
            offScreenGraphics.setColor(Color.BLACK);
            offScreenGraphics.fillRect(0, 0, getWidth(), getHeight());

            // 敵の描画
            for (Enemy e : enemies) {
                e.draw(offScreenGraphics);
            }

            // 画面に反映
            Graphics g = getGraphics();
            if (g != null) {
                g.drawImage(offScreenImage, 0, 0, this);
            }

            // 4. 待機
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

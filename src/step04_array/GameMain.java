package step04_array;

import javax.swing.JFrame;
import java.awt.Graphics;

public class GameMain extends JFrame {
    
    public static void main(String[] args) {
        new GameMain();
    }

    public GameMain() {
        // ウィンドウの設定
        this.setTitle("Shooting Game Step 4");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // 描画用のGraphicsオブジェクトを取得
        // (本来Swingでは非推奨ですが、学習のために一時的に使用します)
        Graphics g = this.getGraphics();

        // 配列の確保
        // これは「敵を入れる箱」を10個用意しただけです
        Enemy[] enemies = new Enemy[10];

        // 各要素のインスタンス化
        // 箱の一つ一つに、新しい敵を作って入れます
        for (int i = 0; i < enemies.length; i++) {
            double startX = Math.random() * 800;
            double startY = Math.random() * 600;
            double angle = Math.random() * 360; // 0〜360度のランダム
            double speed = 1.0 + Math.random() * 3.0; // ランダムな速度
            
            enemies[i] = new Enemy(startX, startY, angle, speed);
        }

        // ゲームループ
        while (true) {
            try {
                // 全員を動かす
                for (int i = 0; i < enemies.length; i++) {
                    enemies[i].erase(g);
                    enemies[i].move();
                    enemies[i].draw(g);
                }

                // 待機 (約60fps)
                Thread.sleep(16); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package step03_animation;

import javax.swing.JFrame;
import java.awt.Graphics;

public class GameMain extends JFrame {
    
    public static void main(String[] args) {
        new GameMain();
    }

    public GameMain() {
        // ウィンドウの設定
        this.setTitle("Shooting Game Step 3");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // 描画用のGraphicsオブジェクトを取得
        // (本来Swingでは非推奨ですが、学習のために一時的に使用します)
        Graphics g = this.getGraphics();

        // 1. インスタンス生成 (new)
        // ここで敵キャラが1体生まれます
        Enemy enemy = new Enemy(100, 100, 45, 2.0);

        // ゲームループ
        while (true) {
            try {
                // 2. 消去 (前のフレームの絵を消す)
                enemy.erase(g);

                // 3. 移動 (座標更新)
                enemy.move();

                // 4. 描画 (新しい位置に描く)
                enemy.draw(g);

                // 待機 (約60fps)
                Thread.sleep(16); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

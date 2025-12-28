package step08_refactoring;

import javax.swing.JFrame;
import java.awt.Graphics;

public class GameMain extends JFrame {
    
    public static void main(String[] args) {
        new GameMain();
    }

    public GameMain() {
        this.setTitle("Shooting Game Step 8 - Refactoring");
        // Enemyクラスの定数を利用してサイズを設定
        this.setSize(Enemy.WINDOW_WIDTH, Enemy.WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Graphics g = this.getGraphics();

        Enemy enemy = new Enemy(100, 100, 45, 2.0);

        // Setterの保護機能を確認
        enemy.setX(-999); // 0に補正されるはず
        System.out.println("補正後のX座標: " + enemy.getX());

        while (true) {
            enemy.erase(g);
            enemy.move();
            enemy.draw(g);

            // メソッド抽出によりスッキリした呼び出し
            sleep();
        }
    }

    // メソッド抽出 (Extract Method)
    // 例外処理などの「おまじない」を隠蔽して、メインの処理を読みやすくする
    private void sleep() {
        try {
            Thread.sleep(16); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

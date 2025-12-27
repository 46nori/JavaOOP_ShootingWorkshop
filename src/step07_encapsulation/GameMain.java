package step07_encapsulation;

import javax.swing.JFrame;
import java.awt.Graphics;

public class GameMain extends JFrame {
    
    public static void main(String[] args) {
        new GameMain();
    }

    public GameMain() {
        this.setTitle("Shooting Game Step 7 - Encapsulation");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Graphics g = this.getGraphics();

        Enemy enemy = new Enemy(100, 100, 45, 2.0);

        // カプセル化の確認
        // enemy.x = 200; // コンパイルエラー！ privateなので直接アクセスできない
        
        // 正しい方法：Setterを使う
        enemy.setX(200);
        
        // 値を見る時もGetterを使う
        System.out.println("現在のX座標: " + enemy.getX());

        while (true) {
            try {
                enemy.erase(g);
                enemy.move();
                enemy.draw(g);

                Thread.sleep(16); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

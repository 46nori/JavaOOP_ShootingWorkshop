package step06_polymorphism;

import javax.swing.JFrame;
import java.awt.Graphics;

public class GameMain extends JFrame {
    
    public static void main(String[] args) {
        new GameMain();
    }

    public GameMain() {
        this.setTitle("Shooting Game Step 6 - Polymorphism");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Graphics g = this.getGraphics();

        // ポリモーフィズム：異なる子クラスを親クラスの配列でまとめて管理
        Enemy[] enemies = new Enemy[20];

        for (int i = 0; i < enemies.length; i++) {
            double startX = Math.random() * 800;
            double startY = Math.random() * 600;
            double angle = Math.random() * 360;
            double speed = 1.0 + Math.random() * 3.0;

            // ランダムに種類を決める
            if (Math.random() < 0.5) {
                enemies[i] = new StraightEnemy(startX, startY, angle, speed);
            } else {
                enemies[i] = new WavyEnemy(startX, startY, angle, speed);
            }
        }

        while (true) {
            try {
                for (Enemy e : enemies) {
                    e.erase(g);
                    e.move(); // ここで、実体に応じたmoveが呼ばれる（多態性）
                    e.draw(g);
                }

                Thread.sleep(16); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

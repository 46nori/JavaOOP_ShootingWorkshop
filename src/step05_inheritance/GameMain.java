package step05_inheritance;

import javax.swing.JFrame;
import java.awt.Graphics;

public class GameMain extends JFrame {
    
    public static void main(String[] args) {
        new GameMain();
    }

    public GameMain() {
        this.setTitle("Shooting Game Step 5 - Inheritance");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Graphics g = this.getGraphics();

        // 直進する敵
        StraightEnemy sEnemy = new StraightEnemy(100, 100, 0, 3.0);
        // 波打つ敵
        WavyEnemy wEnemy = new WavyEnemy(100, 300, 0, 3.0);

        while (true) {
            try {
                sEnemy.erase(g);
                wEnemy.erase(g);

                sEnemy.move();
                wEnemy.move();

                sEnemy.draw(g);
                wEnemy.draw(g);

                Thread.sleep(16); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

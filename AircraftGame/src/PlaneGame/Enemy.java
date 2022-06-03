package PlaneGame;

import javax.swing.*;
import java.awt.*;

public class Enemy extends Thread {
    GameFrame gameFrame;
    int x;
    int y;
    int width = 50;
    int height = 50;
    int speed = 2;

    Image img = new ImageIcon("img/Enemy_Plane.png").getImage();

    public Enemy(GameFrame gameFrame, int x, int y) {
        this.gameFrame = gameFrame;
        this.x = x;
        this.y = y;
    }

    public Enemy(GameFrame gameFrame, int x, int y, int width, int height) {
        this.gameFrame = gameFrame;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void run() {
        while (true) {
            if (hit()) {
                //speed decreases to 0
                this.speed = 0;
                //change image to new one with explosion
                this.img = new ImageIcon("img/explosion.jfif").getImage();

                try {
                    this.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gameFrame.enemys.remove(this);
                break;
            }
            if (this.y >= 760) {
                break;
            }
            try {
                this.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //bullets hit enemy
    public boolean hit() {
        Rectangle myRect = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle rect = null;

        for (int i = 0; i < gameFrame.bullets.size(); i++) {
            Bullet bullet = gameFrame.bullets.get(i);
            rect = new Rectangle(bullet.x, bullet.y, bullet.width, bullet.height);

            if (rect.intersects(myRect)) {
                return true;
            }
        }
        return false;
    }
    //enemy hits player's plane

}

package Game;

import javax.swing.*;
import java.awt.*;

public class EnemyPlane extends Thread {
    public GameFrame gf;
    public int x;
    public int y;
    public int width = 50;
    public int height = 50;
    public int speed = 2;

    public Image img = new ImageIcon("img/Enemy_Plane.png").getImage();

    public EnemyPlane(GameFrame gf, int x, int y) {
        super();
        this.gf = gf;
        this.x = x;
        this.y = y;
    }

    public EnemyPlane(GameFrame gf, int x, int y, int width, int height) {
        super();
        this.gf = gf;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void run() {
        while (true) {
            if (hit()) {
                System.out.println("hit..................");
                //speed will be 0
                this.speed = 0;
                //explosion, changed enemy pics to another pics showing explosion
                this.img = new ImageIcon("img/explosion.jfif").getImage();
                //check evey 500 millis
                try {
                    this.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gf.enemys.remove(this);
                //gone after explosion
                break;
            }
            //when enemy planes reach to the boundary, then break
            if (this.y >= 760) {
                break;
            }
            try {
                this.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //check if planes are collided
    public boolean hit() {
        //It is provided in Swing
        Rectangle myRect = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle rect = null;

        for (int i = 0; i < gf.bullets.size(); i++) {
            Bullet bullet = gf.bullets.get(i);
            System.out.println("test hit");
            rect = new Rectangle(bullet.x, bullet.y - 1, bullet.width, bullet.height);
            //check if it has intersection
            if (myRect.intersects(rect)) {
                return true;
            }
        }
        return false;
    }
}

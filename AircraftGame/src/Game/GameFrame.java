package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

public class GameFrame extends JFrame {
    Airplane airplane;
    //Define the set of the bullets
    //the size of a Vector can grow or shrink as needed to accommodate
    //adding and removing items after the Vector has been created. 可以同時處理adding removing
    Vector<Bullet> bullets = new Vector<>();

    Vector<EnemyPlane> enemys = new Vector<>();
    GameFrame frame;
    public GameFrame() {
        frame = this;
        //build an airplane
        airplane = new Airplane();
        //activate the thread to make the plane move
        airplane.start();
        //Set the width and height
        this.setSize(500, 760);
        //title
        this.setTitle("Killer Aircraft");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //可見窗口
        this.setVisible(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //Generate a new enemy plane's new thread
        new Thread(new Runnable() {
            Random r = new Random();
            @Override
            public void run() {
                while (true) {
                    //make x show up randomly using Random class
                    EnemyPlane enemyPlane = new EnemyPlane(frame, r.nextInt(500), 0);
                    //activate the enemy
                    enemyPlane.start();
                    enemys.add(enemyPlane);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void paint(Graphics g) {
//        System.out.println("Draw the panel");
        //draw the background
        BufferedImage image = (BufferedImage)this.createImage(this.getSize().width, this.getSize().height);
        Graphics bi = image.getGraphics();
        //Draw an background, (0, 0) is coordination
        bi.drawImage(new ImageIcon("img/Airplane_background.png").getImage(), 0, 0, null);
        //Draw the airplane
        bi.drawImage(airplane.img, airplane.x, airplane.y, airplane.width, airplane.height, null);
        //Draw the bullets, and traverse the bullets list
        for (int i = 0; i < bullets.size(); i++) {
//            System.out.println(bullets);
            Bullet bullet = bullets.get(i);
            if (bullet.y > 0) {
                //Draw the bullets, including moving up the bullet by changing y coordination
                bi.drawImage(bullet.image, bullet.x - 25, bullet.y -= bullet.speed, bullet.width, bullet.height, null);
                bi.drawImage(bullet.image, bullet.x, bullet.y -= bullet.speed, bullet.width, bullet.height, null);
                bi.drawImage(bullet.image, bullet.x + 25, bullet.y -= bullet.speed, bullet.width, bullet.height, null);
            } else {
                //remove when the bullets are out of graphics
                bullets.remove(bullet);
            }
        }
        //Draw the enemy plane
        for (int i = 0; i < enemys.size(); i++) {
//            System.out.println(bullets);
            EnemyPlane ep = enemys.get(i);

            if (ep.y < 760) {
                //Draw the bullets, including moving up the bullet by changing y coordination
                bi.drawImage(ep.img, ep.x, ep.y += ep.speed, ep.width, ep.height, null);
            } else {
                //remove when the bullets are out of graphics
                bullets.remove(ep);
            }
        }
        //generator
        g.drawImage(image, 0, 0, null);
    }
    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        Player player = new Player(frame);
        frame.addKeyListener(player);

    }
}

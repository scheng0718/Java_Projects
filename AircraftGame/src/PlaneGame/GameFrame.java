package PlaneGame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

public class GameFrame extends JFrame {
    Plane plane;
    GameFrame frame;
    //Save the list of bullets
    Vector<Bullet> bullets = new Vector<>();
    Vector<Enemy> enemys = new Vector<>();
    //Constructor
    public GameFrame() {
        frame = this;
        plane = new Plane();
        plane.start();

        this.setSize(500, 760);
        this.setTitle("Killer Air Game");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //the window is placed in the center
        this.setLocationRelativeTo(null);
        //make the window visible
        this.setVisible(true);

        //keep painting
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

        //Generate enemy's thread
        new Thread(new Runnable() {
            Random r = new Random();
            @Override
            public void run() {
                while (true) {
                    Enemy ep = new Enemy(frame, r.nextInt(500), 0);
                    ep.start();
                    //add new enemy planes to vector
                    enemys.add(ep);
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
        BufferedImage image = (BufferedImage)this.createImage(this.getWidth(), this.getHeight());
        Graphics bi = image.getGraphics();
        //Draw the background
        bi.drawImage(new ImageIcon("img/Airplane_background.png").getImage(), 0, 0, null);
        //Draw the plane
        bi.drawImage(plane.img, plane.x, plane.y, plane.width, plane.height, null);
        //Draw the bullet
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if (bullet.y > 0) {
                bi.drawImage(bullet.img, bullet.x, bullet.y -= bullet.speed, bullet.width, bullet.height, null);
            } else {
                bullets.remove(bullet);
            }
        }
        //Draw the enemy plane
        for (int i = 0; i < enemys.size(); i++) {
            Enemy ep = enemys.get(i);
            if (ep.y < 760) {
                bi.drawImage(ep.img, ep.x, ep.y += ep.speed, ep.width, ep.height, null);
            } else {
                enemys.remove(ep);
            }
        }
        g.drawImage(image, 0, 0, null);
    }
    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        Player player = new Player(frame);
        frame.addKeyListener(player);
    }
}

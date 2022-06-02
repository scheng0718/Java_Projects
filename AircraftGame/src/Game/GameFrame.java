package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameFrame extends JFrame {
    Airplane airplane;
    //define the set of the bullets
    //the size of a Vector can grow or shrink as needed to accommodate adding and removing items after the Vector has been created.
    Vector<Bullet> bullets = new Vector<>();

    public GameFrame() {
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
        //Draw the bullets
        for (int i = 0; i < bullets.size(); i++) {
//            System.out.println(bullets);
            Bullet bullet = bullets.get(i);
            if (bullet.y > 0) {
                bi.drawImage(bullet.image, bullet.x, bullet.y -= bullet.speed, bullet.width, bullet.height, null);
            } else {
                //remove when the bullets are out of bound
                bullets.remove(bullet);
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

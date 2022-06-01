package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameFrame extends JFrame {
    //constructor
    public GameFrame() {
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
        System.out.println("Draw the panel");
        //draw the background
        BufferedImage image = (BufferedImage)this.createImage(this.getSize().width, this.getSize().height);
        Graphics bi = image.getGraphics();

        bi.drawImage(new ImageIcon("aircraft.png").getImage(), 0, 0, null);

        g.drawImage(image, 0, 0, null);
    }
    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
    }
}

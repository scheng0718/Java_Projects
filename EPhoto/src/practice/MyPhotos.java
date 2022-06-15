package practice;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyPhotos extends JPanel {
    //Create an object to store 4 photos
    BufferedImage[] images = new BufferedImage[4];
    BufferedImage bgImage;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        //set the frame's title
        jFrame.setTitle("My Memory");
        //set the frame's size
        jFrame.setSize(1300, 800);
        //set when close the frame, and exit the program
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //set the frame to the middle, value would be null to set in the center
        jFrame.setLocationRelativeTo(null);


        //create a JPanel class to add background to the frame
//        JPanel bg = new JPanel();
        MyPhotos myImage = new MyPhotos();
        //add JPanel object to the frame
        jFrame.add(myImage);
        //initialize the photos
        myImage.initialImages();
        //draw to the frame
//        myImage.repaint();
        //repaint 4 times
        myImage.begin();
        //set the frame to visible
        jFrame.setVisible(true);

    }
    public void initialImages() {
        try {
            for (int i = 1; i <= 4; i++) {
                BufferedImage image = ImageIO.read(new File("C:/Users/schen/Dropbox/Software_Engineer/Java_Project/EPhoto/src/images/bg" + i + ".png"));
                images[i - 1] = image;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    float ff = 0;
    //Redefine father class's method, ctrl + o
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setComposite(AlphaComposite.SrcOver.derive(ff / 100f));
        if (bgImage != null) {
            g2D.drawImage(bgImage, 0, 0, bgImage.getWidth(), bgImage.getHeight(), null);
        }
    }
    int num = 0;
    public void begin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    bgImage = images[num++];
                    if (num == 4) {
                        num = 0;
                    }
                    while (true) {
                        if (ff < 100) {
                            ff += 2;
                            repaint();
                        } else {
                            ff = 0;
                            break;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}

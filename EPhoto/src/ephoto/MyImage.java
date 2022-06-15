package ephoto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

//extends the father class JPanel
public class MyImage extends JPanel {
    //Define member object
    BufferedImage bgImage;
    //Define images list
    BufferedImage[] images = new BufferedImage[4];

    //load pictures from images, save them to a data structure.
    public void initImages() {
        try {
            //write a for loop
            for (int i = 1; i <= 4; i++) {
                //load images
                BufferedImage image = ImageIO.read(MyImage.class.getResource("/images/bg" + i + ".png"));
                images[i - 1] = image;
            }
            //display the images on the windows
            bgImage = images[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //percentage of transparency
    float ff = 0f;
    //represents the index of the BufferedImages
    int num = 0;
    /**
     *
     */
    public void begin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //keep changing ff value
                while (true) {
                    //Get the images
                    bgImage = images[num++];
                    if (num == 4) {
                        num = 0;
                    }
                    while (true) {
                        //paint
                        if (ff < 100f) {
                            ff += 2f;
                            //call repaint()
                            repaint();
                        } else {
                            ff = 0f;
                            break;
                        }
                        //add sleeping time
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

    //redefine the methods from father class ctrl + o
    //Graphics g is a pen
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //Convert to child class object, which provides more methods to use
        Graphics2D graphics2D = (Graphics2D)g;

        if (bgImage != null) {
            //add the effects, set up the percentage of acquiring the image, 0 -> 10-> 20-> 30->...>100
            graphics2D.setComposite(AlphaComposite.SrcOver.derive(ff/ 100f));
            //draw the pictures
            graphics2D.drawImage(bgImage, 0, 0, bgImage.getWidth(), bgImage.getHeight(), null);
        }
    }

    public static void main(String[] args) {
        //create a windows
        JFrame frame = new JFrame();
        //set the size
        frame.setSize(1000, 700);
        //set the title
        frame.setTitle("Java E-Photo");
        //set location in the middle
        frame.setLocationRelativeTo(null);
        //close the windows and jvm stops too
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //int = 3

        //create a panel object, since we will need to use the api from this class
//        JPanel jPanel = new JPanel();
        //create a panel object
        MyImage myImage = new MyImage();
        //put panel to the windows
        frame.add(myImage);
        //call the method, read 4 images and put into array
        myImage.initImages();
        //draw again, call override paint() method
//        myImage.repaint();
        //write a method, turn on a new thread
        myImage.begin();
        //display the windows
        frame.setVisible(true);
    }
}
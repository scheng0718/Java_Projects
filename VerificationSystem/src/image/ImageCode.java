package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ImageCode {
    //"l" "1" "o" "0" are not included to prevent the confusion. Improve the user experience.
    static String[] strings = {"a", "b", "c", "d", "e", "f", "g", "h",
                        "i", "j", "k", "m", "n", "p",
                        "q", "r", "s", "t", "u", "v", "w", "x",
                        "y", "z", "2", "3", "4", "5", "6",
                        "7", "8", "9"};

    public static void main(String[] args) throws IOException {
        //Requirement: generate the pictures through Java, the picture includes number or lines

        //Painting:
        /** 1. board and paper
         *  2. prepare the pen
         *  3. prepare the data of string array, get the 4 strings from the data randomly
         *  4. Paint 4 numbers to the board.
         *  5. Generate a real picture.
         */
        //define width
        int width = 150;
        //define height
        int height = 50;
        //image type, RGB (made of red, green, blue)
        //int imageType = BufferedImage.TYPE_INT_RGB;
        int imageType = 1;

        //1. board or paper: JDK provides a class, new an object, ctrl + p to see the arguments
        BufferedImage image = new BufferedImage(width, height, imageType);

        //2. Get the pen object
        Graphics g = image.getGraphics();
        // change the color, by default is black
        g.setColor(Color.yellow);
        //fill the rectangle, starting from x, y coordinate
        g.fillRect(0, 0, width, height);

        //3. prepare the data and get 4 strings randomly using Random class
        //reset the color
        g.setColor(Color.red);
        //adjust the font, name, style, and size
        g.setFont(new Font("Times New Roman", Font.BOLD, 25));
        //Use random class
        Random random = new Random();
        int x = 25;
        int y = 25;

        //4. paint the 4 string to the board, and set the x, y coordinate
        for (int i = 0; i < 4; i++) {
            int num = random.nextInt(strings.length);
            String str = strings[num];
            g.drawString(str, x, y);
            //update x to make sure the position is different
            x += 25;
        }
        //set the color of the line
        g.setColor(Color.green);
        //Draw the 10 lines randomly, and set the coordinate
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(30);
            int y1 = random.nextInt(50);

            int x2 = random.nextInt(30) + 120;
            int y2 = random.nextInt(50);
            //Draw a line to the picture
            g.drawLine(x1, y1, x2, y2);
        }

        //5. Generate a picture to local disk through ImageIO.write method
        ImageIO.write(image, "jpg", new File("C:\\Users\\schen\\Dropbox\\Software_Engineer\\Java_Project\\VerificationSystem\\src\\image\\image.jpg"));
    }
}

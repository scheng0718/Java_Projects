package practice;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ImageGenerator {
    //no need to use 1, l, o, 0 in order to improve user experiences
    static String[] strings = {"a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "m", "n", "p",
            "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "2", "3", "4", "5", "6",
            "7", "8", "9"};
    public static void main(String[] args) throws IOException {
        int width = 240;
        int height = 100;
        int imageType = BufferedImage.TYPE_INT_RGB;
        //1. Generate a board
        BufferedImage image = new BufferedImage(width, height, imageType);

        //2. Get the pen and draw the image to the board
        Graphics g = image.getGraphics();
        //2.1 Draw the background
        g.drawImage(image, 0, 0, width, height,  null);
        //2.2 change the color to green
        g.setColor(Color.green);
        //2.3 fill the board
        g.fillRect(0, 0, width, height);

        //3. Draw 4 strings from String[] to the board.
        //3.1 set the font, change the name, style, and size
        g.setFont(new Font("Times New Roman", Font.BOLD|Font.ITALIC, 25));
        //3.2 Use random class to set color and strings
        Random random = new Random();
        int w = 80;
        int h = 60;
        for (int i = 0; i < 4; i++) {
            //3.3 set the random color
            float red = random.nextFloat();
            float green = random.nextFloat();
            float blue = random.nextFloat();
            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);

            int num = random.nextInt(strings.length);
            String str = strings[num];
            g.drawString(str, w, h);
            w += 25;
        }

        //4. Provide multiple lines on the board
        for (int i = 0; i < 5; i++) {
            //4.1 Set the random color (RGB)
            float red = random.nextFloat();
            float green = random.nextFloat();
            float blue = random.nextFloat();
            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);

            //4.2 Draw multiples lines
            int x1 = random.nextInt(30);
            int y1 = random.nextInt(100);
            int x2 = random.nextInt(30) + 180;
            int y2 = random.nextInt(100);
            g.drawLine(x1, y1, x2, y2);
        }

        //5. Generate a picture as output and save it in the local folder
        ImageIO.write(image, "png", new File("C:\\Users\\schen\\Dropbox\\Software_Engineer\\Java_Project\\VerificationSystem\\src\\practice\\image.png"));
    }
}

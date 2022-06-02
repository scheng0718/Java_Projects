package Game;

import javax.swing.*;
import java.awt.*;

public class Airplane extends Thread {
    //the starting location of the plane
    int x = 220;
    int y = 680;
    //the size of the airplane
    int width = 50;
    int height = 50;

    //Speed of the airplane
    int speed = 10;

    Image img = new ImageIcon("img/plane.png").getImage();

    //Define direction: up, down, left, right
    boolean up, down, left, right;



    public Airplane() {
    }

    public Airplane(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void run() {
        while (true) {
            if (up) {
                y -= speed;
            }
            if (down) {
                y += speed;
            }
            if (left) {
                x -= speed;
            }
            if (right) {
                x += speed;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

package PlaneGame;

import javax.swing.*;
import java.awt.*;

public class Plane extends Thread {
    //fields
    int x = 220;
    int y = 700;
    int width = 50;
    int height = 50;
    Image img = new ImageIcon("img/plane.png").getImage();
    int speed = 10;
    boolean up, down, left, right;
    //Methods and constructor
    public Plane() {
    }
    public Plane(int x, int y, int width, int height) {
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

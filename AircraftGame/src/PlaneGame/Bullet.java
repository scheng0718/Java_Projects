package PlaneGame;

import javax.swing.*;
import java.awt.*;

public class Bullet {
    //fields
    int x;
    int y;
    int width = 40;
    int height = 40;
    int speed = 10;

    Image img = new ImageIcon("img/bullet.png").getImage();

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bullet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}

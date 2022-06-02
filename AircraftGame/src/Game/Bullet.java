package Game;

import javax.swing.*;
import java.awt.*;

public class Bullet {
    //Coordination
    int x;
    int y;

    int width = 30;
    int height = 30;
    //speed of the bullet
    int speed = 15;

    Image image = new ImageIcon("img/bullet.png").getImage();

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

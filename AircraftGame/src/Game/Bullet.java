package Game;

import javax.swing.*;
import java.awt.*;

public class Bullet {
    //Coordination
    int x;
    int y;

    int width = 50;
    int height = 50;
    //speed of the bullet
    int speed = 10;

    Image image = new ImageIcon("C:/Users/schen/Dropbox/Software_Engineer/Java_Project/AircraftGame/img/bullet.png").getImage();

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

package Game;

import javax.swing.*;
import java.awt.*;

public class Airplane {
    int x = 100;
    int y = 620;
    int width = 50;
    int height = 50;

    Image img = new ImageIcon("img/plane.png").getImage();

    public Airplane() {
    }

    public Airplane(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}

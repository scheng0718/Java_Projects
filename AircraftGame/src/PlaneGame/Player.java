package PlaneGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends KeyAdapter {
    GameFrame frame;
    public Player(GameFrame frame) {

        this.frame = frame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case 38:
                frame.plane.up = true;
                break;
            case 40:
                frame.plane.down = true;
                break;
            case 37:
                frame.plane.left = true;
                break;
            case 39:
                frame.plane.right = true;
                break;
            case 32:
                addBullet();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case 38:
                frame.plane.up = false;
                break;
            case 40:
                frame.plane.down = false;
                break;
            case 37:
                frame.plane.left = false;
                break;
            case 39:
                frame.plane.right = false;
                break;
        }
    }
    public void addBullet() {
        Bullet launch = new Bullet(frame.plane.x + 5, frame.plane.y - 20);
        frame.bullets.add(launch);

    }
}

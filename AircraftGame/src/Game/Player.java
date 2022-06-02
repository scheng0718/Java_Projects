package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//Define a player to extend the key adapter
public class Player extends KeyAdapter {

    //Airplane airPlane;
    GameFrame frame;
    public Player(GameFrame frame) {
        //this.airPlane = airPlane;
        this.frame = frame;
    }
    //press the key
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        //up: 38, down: 40, left: 37, right: 39
        switch (keyCode) {
            case 38:
                frame.airplane.up = true;
                break;
            case 40:
                frame.airplane.down = true;
                break;
            case 37:
                frame.airplane.left = true;
                break;
            case 39:
                frame.airplane.right = true;
                break;
            case 66:
                addBullet();
                break;
        }
    }
    //release the key
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        //up: 38, down: 40, left: 37, right: 39
        switch (keyCode) {
            case 38:
                frame.airplane.up = false;
                break;
            case 40:
                frame.airplane.down = false;
                break;
            case 37:
                frame.airplane.left = false;
                break;
            case 39:
                frame.airplane.right = false;
                break;
        }
    }
    //load the bullet
    public void addBullet() {
        frame.bullets.add(new Bullet(frame.airplane.x + 5, frame.airplane.y - 20));
    }
}

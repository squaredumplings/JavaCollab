package cblgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed;
    public boolean leftPressed;
    public boolean downPressed;
    public boolean rightPressed;
    public boolean endGamePressed;

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            default: Debug.log(e.getKeyChar() + " pressed");
                break;
            case 87: upPressed = true; // w
                break;
            case 65: leftPressed = true; // a
                break;
            case 83: downPressed = true; // s
                break;
            case 68: rightPressed = true; // d
                break;
            case 75: endGamePressed = true; // k
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            default: break;
            case 87: upPressed = false; // w
                break;
            case 65: leftPressed = false; // a
                break;
            case 83: downPressed = false; // s
                break;
            case 68: rightPressed = false; // d
                break;
            case 75: endGamePressed = false; // k
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}

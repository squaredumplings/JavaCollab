package cblgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GamePanel extends JPanel implements KeyListener{  

    JLabel label;

    public GamePanel(int windowWidth, int windowHeight){
        this.setSize(windowWidth, windowHeight);
        this.setBounds(0, 0, windowWidth, windowHeight);
        this.setBackground(Color.darkGray);
        this.addKeyListener(this);
        this.setLayout(null);

        label = new JLabel();
        label.setBackground(new Color(0, 100, 0));
        label.setBounds(100, 100, 100, 100);
        label.setOpaque(true);

        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        switch(e.getKeyCode()) {
            case 87: label.setLocation(label.getX(), label.getY()-10); break;
            case 83: label.setLocation(label.getX(), label.getY()+10); break;
            case 65: label.setLocation(label.getX()-10, label.getY()); break;
            case 68: label.setLocation(label.getX()+10, label.getY()); break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        switch(e.getKeyChar()) {
            case 'w': label.setLocation(label.getX(), label.getY()-10); break;
            case 's': label.setLocation(label.getX(), label.getY()+10); break;
            case 'a': label.setLocation(label.getX()-10, label.getY()); break;
            case 'd': label.setLocation(label.getX()+10, label.getY()); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}

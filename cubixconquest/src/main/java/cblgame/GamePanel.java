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
import javax.swing.JLayeredPane;

public class GamePanel extends JLayeredPane implements KeyListener{  

    JLabel label;

    public GamePanel(int windowWidth, int windowHeight){
        this.setSize(windowWidth, windowHeight);
        this.setBounds(0, 0, windowWidth/2, windowHeight/2);
        this.setBackground(Color.red);
        this.addKeyListener(this);
        this.setLayout(null);
        this.setFocusable(true);

        label = new JLabel();
        label.setBackground(new Color(0, 100, 0));
        label.setBounds(100, 100, 100, 100);
        label.setOpaque(true);

        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyChar()) {
            case 'w': DebugPanel.log("w");
                        label.setLocation(label.getX(), label.getY()-10); 
                        break;
            case 'a': DebugPanel.log("a");
                        label.setLocation(label.getX()-10, label.getY()); 
                        break;
            case 's': DebugPanel.log("s");
                        label.setLocation(label.getX(), label.getY()+10); 
                        break;
            case 'd': DebugPanel.log("d");
                        label.setLocation(label.getX()+10, label.getY()); 
                        break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}

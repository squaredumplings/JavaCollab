package cblgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{  

    public GamePanel(int windowWidth, int windowHeight){
        this.setSize(windowWidth, windowHeight);
        this.setBounds(0, 0, windowWidth, windowHeight);
        this.setBackground(Color.red);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}

package cblgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window extends JFrame implements ActionListener {

    private String UpAction = "w";
    private String LeftAction = "a";
    private String DownAction = "s";
    private String RightAction = "d";
       
    public Window(int windowWidth, int windowHeight){
        
        DebugPanel debug = new DebugPanel(20, 20, 100, 200);
        this.add(debug);

        MenuPanel menu = new MenuPanel(windowWidth, windowHeight, this);
        this.add(menu);
        
        // window settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window when clicking the x
        this.setSize(windowWidth,windowHeight);
        this.setResizable(false);
        this.setTitle("Cubix Conquest");
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    
}
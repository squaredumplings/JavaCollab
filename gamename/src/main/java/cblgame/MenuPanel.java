package cblgame;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
    private int scaleX;
    private int scaleY;    

    public MenuPanel(int windowWidth, int windowHeight, ActionListener actionListener){
        scaleX = windowWidth / 16;
        scaleY = windowHeight / 12;
        
        // title
        //ImageIcon icon = new ImageIcon("");
        JLabel title = new JLabel();
        title.setBounds(4*scaleX, 2*scaleY, 8*scaleX, 2*scaleY);
        //title.setIcon(icon);
        this.add(title);

        // start button
        JButton startButton  = new JButton("Start");
        startButton.setBounds(6*scaleX, 5*scaleY, 4*scaleX, scaleY);
        startButton.setActionCommand("start");
        startButton.addActionListener(actionListener);
        this.add(startButton);

        // options button
        JButton optionsButton  = new JButton("Options");
        optionsButton.setBounds(6*scaleX, 7*scaleY, 4*scaleX, scaleY);
        optionsButton.setActionCommand("options");
        optionsButton.addActionListener(actionListener);
        this.add(optionsButton);

        // quit button
        JButton quitButton  = new JButton("Quit");
        quitButton.setBounds(6*scaleX, 9*scaleY, 4*scaleX, scaleY);
        quitButton.setActionCommand("quit");
        quitButton.addActionListener(actionListener);
        this.add(quitButton);

        //panel settings
        this.setBounds(0, 0, windowWidth, windowHeight);
        this.setBackground(null);
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Image background = new ImageIcon("src\\main\\resources\\background.jpg").getImage();
        Image title = new ImageIcon("src\\main\\resources\\title.jpg").getImage();

        // Draw the background image
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(title, 480, 90, getWidth()/2, getHeight()/6, this);
    }
}

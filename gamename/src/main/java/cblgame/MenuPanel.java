package cblgame;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements ActionListener{
    private int scaleX;
    private int scaleY; 
    
    JButton startButton;

    public MenuPanel(int windowWidth, int windowHeight){
        scaleX = windowWidth / 16;
        scaleY = windowHeight / 12;

        // start button
        startButton  = new JButton("Start");
        startButton.setBounds(6*scaleX, 5*scaleY, 4*scaleX, scaleY);
        startButton.setActionCommand("start");
        startButton.addActionListener(this);
        startButton.setOpaque(false);
        startButton.setBorderPainted(false);
        this.add(startButton);
        

        // options button
        JButton optionsButton  = new JButton("Options");
        optionsButton.setBounds(6*scaleX, 7*scaleY, 4*scaleX, scaleY);
        optionsButton.setActionCommand("options");
        optionsButton.addActionListener(this);
        optionsButton.setOpaque(false);
        optionsButton.setBorderPainted(false);
        this.add(optionsButton);

        // quit button
        JButton quitButton  = new JButton("Quit");
        quitButton.setBounds(6*scaleX, 9*scaleY, 4*scaleX, scaleY);
        quitButton.setActionCommand("quit");
        quitButton.addActionListener(this);
        quitButton.setOpaque(false);
        quitButton.setBorderPainted(false);
        this.add(quitButton);

        //panel settings
        this.setBounds(0, 0, windowWidth, windowHeight);
        this.setBackground(null);
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Image background = new ImageIcon("src\\main\\resources\\Background.png").getImage();
        Image title = new ImageIcon("src\\main\\resources\\Title.png").getImage();
        Image start = new ImageIcon("src\\main\\resources\\Start.png").getImage();
        Image options = new ImageIcon("src\\main\\resources\\Options.png").getImage();
        Image quit = new ImageIcon("src\\main\\resources\\Quit.png").getImage();


        // Draw the background image
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(title, 480, 90, getWidth()/2, getHeight()/6, this);
        g.drawImage(start, 720, 450, getWidth()/4, getHeight()/12, this);
        g.drawImage(options, 720, 630, getWidth()/4, getHeight()/12, this);
        g.drawImage(quit, 720, 810, getWidth()/4, getHeight()/12, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "start": DebugPanel.setText("START PRESSED");
            break;
            case "quit" : DebugPanel.setText("QUIT PRESSED"); break;
            case "options" : DebugPanel.setText("OPTIONS PRESSED"); break;
        }
    }
}

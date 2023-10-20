package cblgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

public class MenuPanel extends JLayeredPane implements ActionListener{
    
    public MenuPanel(int windowWidth, int windowHeight){
        // images from resources
        ImageIcon backgroundImage = new ImageIcon("src/main/resources/Background.png");
        ImageIcon titleImage = new ImageIcon("src/main/resources/Title.png");
        ImageIcon startImage = new ImageIcon("src/main/resources/Start.png");
        ImageIcon optionsImage = new ImageIcon("src/main/resources/Options.png");
        ImageIcon quitImage = new ImageIcon("src/main/resources/Quit.png");

        //panel settings
        this.setBounds(0, 0, windowWidth, windowHeight);
        this.setBackground(Color.darkGray);
        this.setLayout(null);
        this.setVisible(true);

        // background
        JLabel background = new JLabel();
        background.setBounds(0, 0, windowWidth, windowHeight);
        background.setIcon(backgroundImage);
        this.add(background, Integer.valueOf(0));

        // title
        JLabel title = new JLabel();
        title.setBounds(480, 90, 960, 180);
        title.setIcon(titleImage);
        this.add(title, Integer.valueOf(1));

        // start button
        JButton startButton  = new JButton();
        startButton.setBounds(720, 450, 480, 90);
        startButton.setActionCommand("start");
        startButton.addActionListener(this);
        startButton.setBorderPainted(false);
        startButton.setFocusable(false);
        startButton.setIcon(startImage);
        this.add(startButton, Integer.valueOf(1));
        

        // options button
        JButton optionsButton  = new JButton();
        optionsButton.setBounds(720, 630, 480, 90);
        optionsButton.setActionCommand("options");
        optionsButton.addActionListener(this);
        optionsButton.setBorderPainted(false);
        optionsButton.setFocusable(false);
        optionsButton.setIcon(optionsImage);
        this.add(optionsButton, Integer.valueOf(1));

        // quit button
        JButton quitButton  = new JButton();
        quitButton.setBounds(720, 810, 480, 90);
        quitButton.setActionCommand("quit");
        quitButton.addActionListener(this);
        quitButton.setOpaque(false);
        quitButton.setBorderPainted(false);
        quitButton.setFocusable(false);
        quitButton.setIcon(quitImage);
        this.add(quitButton, Integer.valueOf(1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "start": DebugPanel.log("START PRESSED"); 
                        Window parentWindow = (Window) SwingUtilities.getWindowAncestor(this);
                        parentWindow.addGame();
                        parentWindow.removeMenu();
                break;
            case "quit" : DebugPanel.log("QUIT PRESSED"); break;
            case "options" : DebugPanel.log("OPTIONS PRESSED"); break;
        }
    }
}

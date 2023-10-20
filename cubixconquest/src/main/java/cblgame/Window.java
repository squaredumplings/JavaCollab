package cblgame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Window extends JFrame{
    private int windowWidth;
    private int windowHeight;

    JLayeredPane layers;
    DebugPanel debug;
    MenuPanel menu;
    GamePanel game;
       
    public Window(int x, int y){

        windowHeight = y;
        windowWidth = x;

        
        this.getLayeredPane().add(new MenuPanel(x, y), Integer.valueOf(0));

        this.getLayeredPane().add(new DebugPanel(), Integer.valueOf(1));

        // window settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window when clicking the x
        this.setSize(x, y);
        this.setResizable(false);
        this.setTitle("Cubix Conquest");
        this.getContentPane().setBackground(Color.darkGray);
        this.setLayout(null);
        this.setVisible(true);
    }    

    public void addMenu() {
        menu = new MenuPanel(windowWidth, windowHeight);
        this.getLayeredPane().add(menu);
    }

    public void addDebug() {
        debug = new DebugPanel();
        this.getLayeredPane().add(debug);
    }

    public void addGame() {
        DebugPanel.log("adding game");
        game = new GamePanel(windowWidth, windowHeight);
        this.getLayeredPane().add(game);
    }

    public void removeMenu() {
        DebugPanel.log("removing menu");
        this.getLayeredPane().remove(menu);
    }

    public void removeDebug() {
        this.getLayeredPane().remove(debug);
    }

    public void removeGame() {
        this.getLayeredPane().remove(game);
    }
}
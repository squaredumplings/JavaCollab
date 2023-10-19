package cblgame;

import java.awt.Color;
import javax.swing.JFrame;

public class Window extends JFrame {

    // private String UpAction = "w";
    // private String LeftAction = "a";
    // private String DownAction = "s";
    // private String RightAction = "d";
    private int windowWidth;
    private int windowHeight;

    MenuPanel menu;
    GamePanel game;
       
    public Window(int x, int y){

        windowHeight = y;
        windowWidth = x;
        // window settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window when clicking the x
        this.setSize(x, y);
        this.setResizable(false);
        this.setTitle("Cubix Conquest");
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);
        this.setVisible(true);
    }    

    public void addMenu() {
        menu = new MenuPanel(windowWidth, windowHeight);
        this.add(menu);
    }

    public void addDebug() {
        this.add(new DebugPanel());
    }

    public void addGame() {
        game = new GamePanel(windowWidth, windowHeight);
        this.add(game);
    }

    public void removeMenu() {
        this.remove(menu);
    }

    // public void removeDebug() {
    //     this.remove(debug);
    // }

    public void removeGame() {
        this.remove(game);
    }
}
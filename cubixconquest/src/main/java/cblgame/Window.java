package cblgame;

import java.awt.Color;

import javax.swing.JFrame;

public class Window extends JFrame {
    
    Debug debug;
    Options options;
    Menu menu;
    Game game;
       
    public Window() {

        this.addMenu();
        this.addDebug();

        // window settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Config.WINDOWWIDTH, Config.WINDOWHEIGHT);
        this.setResizable(false);
        this.setTitle("Cubix Conquest");
        this.getContentPane().setBackground(Color.darkGray);
        this.setLayout(null);
        this.setVisible(true);
    }    

    public void addDebug() {
        Debug.log("adding debug");
        debug = new Debug();
        this.getLayeredPane().add(debug, Integer.valueOf(5));
    }

    public void addMenu() {
        Debug.log("adding menu");
        menu = new Menu();
        this.getLayeredPane().add(menu, Integer.valueOf(1));
    }

    public void addOptions() {
        Debug.log("adding options");
        options = new Options();
        this.getLayeredPane().add(options, Integer.valueOf(1));
    }

    public void addGame() {
        Debug.log("adding game");
        game = new Game();
        this.getLayeredPane().add(game, Integer.valueOf(0));
        game.startGameThread();
    }


    //// not functional maybe
    public void removeDebug() {
        Debug.log("you're not gonna see this");
        this.getLayeredPane().remove(debug);
    }

    public void removeMenu() {
        Debug.log("removing menu");
        this.getLayeredPane().remove(menu);
    }

    public void removeOptions() {
        Debug.log("removing options");
        this.getLayeredPane().remove(options);
    }

    public void removeGame() {
        Debug.log("removing game");
        this.getLayeredPane().remove(game);
    }
}
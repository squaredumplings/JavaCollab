package cblgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import cblgame.entities.Player;

public class Game extends JPanel implements Runnable {  

    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();
    Player player = new Player(this, keyHandler);

    int playerSpeed = 4;

    public Game() {

        //pane settings
        this.setSize(Config.WINDOWWIDTH, Config.WINDOWHEIGHT);
        this.setBackground(new Color(100, 50, 50));
        this.setLayout(null);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.setVisible(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();;
    }

    @Override
    public void run() {

        double drawInterval = 1e9 / Config.FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {

            update();

            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1e6;

                remainingTime = Math.max(0, remainingTime); // to avoid negatives

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        player.update();

        if (keyHandler.endGamePressed) {
            System.exit(43);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        player.draw(g2d);

        g2d.dispose();
    }
}

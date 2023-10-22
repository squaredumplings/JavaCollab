package cblgame.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import cblgame.Config;
import cblgame.Game;
import cblgame.KeyHandler;

public class Player extends Entity {
    Game gamePanel;
    KeyHandler keyHandler;

    public Player(Game gp, KeyHandler kh) {
        this.gamePanel = gp; 
        this.keyHandler = kh;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 400;
        y = 100;
        speed = 4;
    }

    public void update() {
        if (keyHandler.upPressed) {
            y -= speed;
        }
        if (keyHandler.leftPressed) {
            x -= speed;
        }
        if (keyHandler.downPressed) {
            y += speed;
        }
        if (keyHandler.rightPressed) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(x, y, Config.TILESIZE, Config.TILESIZE);
    }
}

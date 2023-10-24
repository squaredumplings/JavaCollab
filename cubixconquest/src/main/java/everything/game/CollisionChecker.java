package everything.game;

import java.awt.Rectangle;

import everything.top.Config;

public class CollisionChecker {
    
    public CollisionChecker() {

    }

    // needs to be generalized
    public static boolean collision(int x, int y, Rectangle box) {
        int size = Config.TILESIZE;

        int topLimit = x - size / 2;
        int leftLimit = x - size / 2;

        if ((x <= size / 2) || (x >= Config.MAPSIZE * size - size / 2) 
            || (y <= size / 2) || (y >= Config.MAPSIZE * size - size / 2)) {
            return true;
        }

        if (Config.MAP[(x - size / 2) / size][(y - size / 2) / size] == 2) {
            return true;
        }

        return false;
    }
}

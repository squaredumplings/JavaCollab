package cblgame;
public class Main {

    public static void main(String[] args) {
        final int windowWidth = 1920;
        final int windowHeight = 1080;
        
        Window window = new Window(windowWidth, windowHeight);
        window.addGame();
        window.addDebug();
    }
}
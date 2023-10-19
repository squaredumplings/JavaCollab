package cblgame;

import java.awt.*;
import javax.swing.*;

public class DebugPanel extends JPanel{
    JTextArea debugText = new JTextArea();

    public DebugPanel(int x, int y, int width, int height) {
        debugText.setText("");

        // debug panel
        this.setBounds(x, y, width, height);
        this.setBackground(Color.WHITE);
        this.add(debugText);
    }

    public void setText(String text) {
        debugText.setText(text);
    }
}

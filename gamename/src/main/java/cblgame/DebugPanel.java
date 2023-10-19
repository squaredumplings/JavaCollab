package cblgame;

import java.awt.*;
import javax.swing.*;

public class DebugPanel extends JPanel{
    final int x = 40;
    final int y = 40;
    final int width = 150;
    final int height = 200;

    static JTextArea debugText = new JTextArea();

    public DebugPanel() {
        debugText.setText("");
        debugText.setOpaque(false);
        debugText.setForeground(Color.white);
        // debug panel
        this.setBounds(x, y, width, height);
        this.setOpaque(false);
        this.add(debugText);
    }

    public static void setText(String text) {
        debugText.setText(text + "\n" + debugText.getText());
    }
}

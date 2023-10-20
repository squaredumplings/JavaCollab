package cblgame;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.Color;


public class DebugPanel extends JPanel{

    static JTextArea debugText = new JTextArea();

    public DebugPanel() {
        debugText.setText("");
        debugText.setForeground(new Color(200, 200, 200));
        debugText.setEditable(false);
        debugText.setBounds(40, 40, 160, 200);
        debugText.setLineWrap(true);
        debugText.setFocusable(false);
        debugText.setOpaque(false);
        
        this.setBounds(40, 40, 160, 200);
        this.setOpaque(false);
        this.add(debugText);
    }

    public static void log(String text) {
        debugText.setText(text + " " + debugText.getText());
    }
}

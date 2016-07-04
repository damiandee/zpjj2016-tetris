package tetris.view;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Dominika on 2016-07-02.
 */

public class Frame extends JFrame {

    JLabel statusbar;

    public Frame() {

        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);
        Panel panel = new Panel(this);
        add(panel);
        panel.start();

        setSize(200, 400);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JLabel getStatusBar() {
        return statusbar;
    }

    public static void main(String[] args) {

        Frame game = new Frame();
        game.setLocationRelativeTo(null);
        game.setVisible(true);

    }
}

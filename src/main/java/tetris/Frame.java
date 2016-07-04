package tetris;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Dominika on 2016-07-02.
 */

public class Frame extends JFrame {

    //private static final long serialVersionUID = 1L;
    public Dimension dimension;
    int x;
    int y;

    public Frame() throws InterruptedException {
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        x = (int) dimension.getWidth() * 4 / 12;
        y = (int) dimension.getHeight() * 2 / 12;
        this.setTitle("TETRIS");
        this.setSize(400, 660);
        this.setLocation(x, y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setFocusable(true);
        this.setResizable(false);
    }

    public static void main(String[] args) throws InterruptedException {
        new Frame();
    }
}

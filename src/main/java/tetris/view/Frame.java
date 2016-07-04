package tetris.view;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Dominika on 2016-07-02.
 */

public class Frame extends JFrame {

    private static final long serialVersionUID = 1L;
    public tetris.view.Panel panel;
    public Dimension dimension;
    int locX;
    int locY;

    public Frame() throws InterruptedException {

        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        locX = (int) dimension.getWidth() * 4 / 12;
        locY = (int) dimension.getHeight() * 2 / 12;
        panel = new tetris.view.Panel();
        this.setTitle("TETRIS");
        this.setSize(326, 585);
        this.setLocation(locX, locY);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setFocusable(true);
        this.setResizable(false);
        this.add(panel);
        addKeyListener(panel);

    }

    public static void main(String[] args) throws InterruptedException {
        new Frame();
    }
}

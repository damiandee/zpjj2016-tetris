package tetris.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Dominika on 2016-07-02.
 */

public class Frame extends JFrame implements ActionListener {

    Button score;
    Button login;
    JLabel statusbar;
    private JPanel startFrame = new JPanel();

    public Frame() {

        statusbar = new JLabel(" 0");
        final Frame mainFrame = this;


        JButton start = new JButton("START");
        startFrame.add(start);

        add(startFrame);
        setSize(400, 600);
        setTitle("Tetris");


        setDefaultCloseOperation(EXIT_ON_CLOSE);

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final Panel panel = new Panel(mainFrame);
                panel.add(statusbar, BorderLayout.SOUTH);
                add(panel);
                startFrame.setVisible(false);
                panel.start();
            }
        });
    }


    public JLabel getStatusBar() {
        return statusbar;
    }

    public static void main(String[] args) {

        Frame game = new Frame();
        game.setLocationRelativeTo(null);
        game.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        score.addActionListener(this);
        Score sc = new Score(this);
    }

}
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

    public Frame() {

        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);
        Panel panel = new Panel(this);

        score = new Button("Wyniki");
        score.setBounds(10, 10, 50, 30);
        score.setVisible(true);
        add(score);
        score.addActionListener(this);

        login = new Button("Zaloguj");
        login.setBounds(320, 10, 50, 30);
        login.setVisible(false);
        add(login);
        login.addActionListener(this);

        add(panel);

        panel.start();
        setSize(400, 600);
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

    @Override
    public void actionPerformed(ActionEvent e) {

        score.addActionListener(this);
        Score sc = new Score(this);
        login.addActionListener(this);
        Login lo = new Login();

    }
}

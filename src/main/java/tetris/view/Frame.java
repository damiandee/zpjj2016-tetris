package tetris.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Dominika on 2016-07-02.
 */

public class Frame extends JFrame implements ActionListener {

    Button score = new Button("Wyniki");;
    Button login;
    JLabel statusbar;
    private JPanel startFrame = new JPanel();
    final private Frame mainFrame;
    final private Frame scoreFrame;
    private Panel panel;

    public Frame() {

        statusbar = new JLabel(" 0");
        mainFrame = this;
        scoreFrame = this;

        JButton start = new JButton("START");
        startFrame.add(start);

        add(startFrame);
        setSize(400, 600);
        setTitle("Tetris");


        setDefaultCloseOperation(EXIT_ON_CLOSE);

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel = new Panel(mainFrame);

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

    public void endGame() {
        String text = "game over";
       // final Panel scores = new Panel(scoreFrame);
        if(statusbar.getText().equals(text)){
            score.setBounds(300, 10, 50, 30);
            score.setVisible(true);
            add(score);
            score.addActionListener(scoreFrame);

            panel.setVisible(false);

            Login login = new Login();
            login.placeComponents(scoreFrame);
        }
    }

    public void actionPerformed(ActionEvent e) {
        score.addActionListener(this);
        Score sc = new Score(this);
    }

}
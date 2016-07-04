package tetris.view;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


/**
 * Created by Dominika on 2016-07-03.
 */
public class Score extends JFrame implements ActionListener {

    JLabel sc;
    JLabel score;

    public Score() {
        super();
        setSize(400, 400);
        setVisible(true);
        setTitle("Wyniki");
        setLayout(new BorderLayout());
        sc = new JLabel("Wynik uzytkownika: ");
        add(sc, BorderLayout.PAGE_START);
        score = new JLabel(" 0");

        add(score, BorderLayout.CENTER);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


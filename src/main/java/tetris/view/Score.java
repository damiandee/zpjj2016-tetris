package tetris.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import static tetris.view.Login.user;


/**
 * Created by Dominika on 2016-07-03.
 */
public class Score extends JFrame implements ActionListener {

    JLabel sc;
    JLabel date;
    JLabel statusbar;
    String username;

    public Score(Frame frame) {
        super();
        setSize(200, 200);
        setVisible(true);
        setTitle("Wyniki");
        setLayout(new BorderLayout());

        username = user;
        //username = "user1";
        sc = new JLabel("Wynik uzytkownika " + username);
        add(sc, BorderLayout.PAGE_START);

        statusbar = frame.getStatusBar();

        statusbar = new JLabel("Uzyskany wynik: " + statusbar.getText());
        add(statusbar, BorderLayout.CENTER);

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = dateFormat.format(currentDate);
        System.out.println(dateString);

        date = new JLabel("Data rozgrywki: " + dateString);
        add(date, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

    }
}


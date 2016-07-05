package tetris.view;

import com.sun.prism.shader.DrawEllipse_Color_AlphaTest_Loader;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.lang.Object.*;


/**
 * Created by Dominika on 2016-07-03.
 */
public class Score extends JFrame implements ActionListener {

    JLabel sc;
    JLabel score;
    JLabel date;
    JLabel statusbar;

    public Score(tetris.view.Frame frame) {
        super();
        setSize(400, 400);
        setVisible(true);
        setTitle("Wyniki");
        setLayout(new BorderLayout());

        sc = new JLabel("Wynik uzytkownika: ");
        add(sc, BorderLayout.PAGE_START);

        statusbar = frame.getStatusBar();

        statusbar = new JLabel("tutaj wynik " + statusbar);
        add(statusbar, BorderLayout.CENTER);

//        score = new JLabel("tutaj wynik" + frame.getStatusBar());
//        add(score, BorderLayout.CENTER);

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = dateFormat.format(currentDate);
        System.out.println(dateString);

        date = new JLabel("tutaj data " +  dateString);
        add(date, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


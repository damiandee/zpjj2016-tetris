package tetris.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dominika on 2016-07-05.
 */
public class Login extends JFrame implements ActionListener {

    JTextField login;
    JTextField password;

    public Login() {
        super();
        setSize(200, 300);
        setVisible(true);
        setTitle("Logowanie");
        setLayout(new BorderLayout());

        login = new JTextField();
        add(login, BorderLayout.PAGE_START);

        password = new JTextField();
        add(password, BorderLayout.PAGE_END);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

package tetris.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dominika on 2016-07-05.
 */
public class Login {

    static String variable;

    public static void placeComponents(final Frame frame) {

        frame.setLayout(null);

        final JLabel userLabel = new JLabel("Uzytkownik: ");
        userLabel.setBounds(10, 10, 80, 25);
        frame.add(userLabel);

        final JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        frame.add(userText);

        final JButton loginButton = new JButton("Zaloguj");
        loginButton.setBounds(10, 80, 80, 25);
        frame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JLabel username = new JLabel(userText.getText());
                frame.add(username);
                username.setBounds(10, 10, 80, 25);
                userLabel.setVisible(false);
                userText.setVisible(false);
                loginButton.setVisible(false);
                frame.remove(userText);
                frame.remove(userLabel);
                frame.remove(loginButton);
                variable = userText.getText();
            }
        });

    }
}

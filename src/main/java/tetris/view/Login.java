package tetris.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dominika on 2016-07-05.
 */
public class Login {

    static String user;

    public static void placeComponents(final JPanel panel) {

        panel.setLayout(null);

        final JLabel userLabel = new JLabel("Uzytkownik");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        final JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);

        final JButton loginButton = new JButton("Zaloguj");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JLabel username = new JLabel(userText.getText());
                username.setBounds(10, 10, 80, 25);
                panel.add(username);
                panel.remove(loginButton);
                panel.remove(userText);
                panel.remove(userLabel);
                user = userText.getText();
            }
        });
    }
}

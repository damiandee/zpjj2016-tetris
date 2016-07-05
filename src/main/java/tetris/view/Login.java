package tetris.view;

import javax.swing.*;

/**
 * Created by Dominika on 2016-07-05.
 */
public class Login {

    public static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel userLabel = new JLabel("Uzytkownik");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);

//        JLabel passwordLabel = new JLabel("Haslo");
//        passwordLabel.setBounds(10, 40, 80, 25);
//        panel.add(passwordLabel);

//        JPasswordField passwordText = new JPasswordField(20);
//        passwordText.setBounds(100, 40, 160, 25);
//        panel.add(passwordText);

        JButton loginButton = new JButton("Zaloguj");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

//        JButton registerButton = new JButton("register");
//        registerButton.setBounds(180, 80, 80, 25);
//        panel.add(registerButton);
    }
}

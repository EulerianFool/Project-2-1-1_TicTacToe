package ui;

import javax.swing.*;
import java.awt.*;
import game.Game;
import services.UserService;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Tic Tac Toe - Main Menu");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        loginButton.addActionListener(e -> openLoginFrame());
        registerButton.addActionListener(e -> openRegisterFrame());

        add(loginButton);
        add(registerButton);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void openLoginFrame() {
        dispose();
        new LoginFrame();
    }

    private void openRegisterFrame() {
        dispose();
        new RegisterFrame();
    }
}


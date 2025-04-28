package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import models.TicTacToePlayer;
import services.UserService;
import game.Game;

public class LoginFrame extends JFrame {
    
    public LoginFrame() {
        setTitle("Login - Tic Tac Toe");
        setSize(350, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));
        
        JLabel emailLabel1 = new JLabel("Player 1 Email:");
        JTextField emailField1 = new JTextField();
        JLabel passLabel1 = new JLabel("Player 1 Password:");
        JPasswordField passField1 = new JPasswordField();
        
        JLabel emailLabel2 = new JLabel("Player 2 Email:");
        JTextField emailField2 = new JTextField();
        JLabel passLabel2 = new JLabel("Player 2 Password:");
        JPasswordField passField2 = new JPasswordField();
        
        JButton loginButton = new JButton("Login and Play");

        // Add components to the frame
        add(emailLabel1);
        add(emailField1);
        add(passLabel1);
        add(passField1);
        add(emailLabel2);
        add(emailField2);
        add(passLabel2);
        add(passField2);
        add(new JLabel()); // Empty cell for alignment
        add(new JLabel()); // Empty cell for alignment
        add(loginButton);

        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email1 = emailField1.getText();
                String password1 = new String(passField1.getPassword());
                String email2 = emailField2.getText();
                String password2 = new String(passField2.getPassword());

                // Verify user credentials and create players
                TicTacToePlayer player1 = UserService.loginUser(email1, password1);
                TicTacToePlayer player2 = UserService.loginUser(email2, password2);

                if (player1 != null && player2 != null) {
                    // Proceed to the game with the two players
                    new Game(player1, player2);
                    dispose(); // Close the login window
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid login credentials. Try again!");
                }
            }
        });

        setVisible(true);
        setLocationRelativeTo(null); // Center the window
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}


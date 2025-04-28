package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import services.UserService;

public class RegisterFrame extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;

    public RegisterFrame() {
        setTitle("Register");
        setSize(300, 250);
        setLayout(new GridLayout(4, 2));

        // Initialize fields
        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        JButton registerButton = new JButton("Register");

        // Add components to the frame
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(registerButton);

        // Register button action
        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            // Check if any field is empty
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled!");
                return;
            }

            // Try registering the user
            if (UserService.registerUser(name, email, password)) {
                JOptionPane.showMessageDialog(this, "Registration successful!");
                dispose();
                new MainFrame();  // Open login after registration
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed. Try again.");
            }
        });

        // Finalize the frame settings
        setVisible(true);
        setLocationRelativeTo(null);
    }
}


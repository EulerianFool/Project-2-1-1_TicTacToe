package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/tictactoe";
    private static final String USER = "root"; // Modify this based on your MySQL credentials
    private static final String PASS = "yourpassword"; // Modify this based on your MySQL credentials

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}


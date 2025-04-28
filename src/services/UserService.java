package services;

import database.DBConnection;
import models.TicTacToePlayer;

import java.sql.*;

public class UserService {
    public static boolean registerUser(String name, String email, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO users (firstname, lastname, username, password) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name.split(" ")[0]);  // First Name
            ps.setString(2, name.split(" ")[1]);  // Last Name
            ps.setString(3, email);
            ps.setString(4, password);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static TicTacToePlayer loginUser(String email, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new TicTacToePlayer(rs.getString("firstname") + " " + rs.getString("lastname"),
                                           rs.getString("username"),
                                           rs.getString("password"),
                                           0);  // Points initialized to 0
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


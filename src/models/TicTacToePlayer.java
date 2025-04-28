package models;

public class TicTacToePlayer extends Player {
    private String password;

    public TicTacToePlayer(String name, String email, String password, int points) {
        super(name, email, points);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    // Optionally, setters and other methods
}


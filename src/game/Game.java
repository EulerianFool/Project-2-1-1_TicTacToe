package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import models.TicTacToePlayer;

public class Game extends JFrame {
    private Board board;
    private TicTacToePlayer player1, player2;
    private JButton[][] buttons;
    private JLabel infoLabel;
    private boolean gameEnded = false;

    public Game(TicTacToePlayer p1, TicTacToePlayer p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.board = new Board();
        this.buttons = new JButton[3][3];

        setTitle("Tic Tac Toe Game");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        infoLabel = new JLabel("", SwingConstants.CENTER);
        infoLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        add(infoLabel, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        add(boardPanel, BorderLayout.CENTER);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int row = i, col = j;
                buttons[i][j] = new JButton("-");
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 70));
                boardPanel.add(buttons[i][j]);

                buttons[i][j].addActionListener(e -> {
                    if (!gameEnded && board.makeMove(row, col)) {
                        char mark = board.getCurrentPlayerMark();
                        buttons[row][col].setText(String.valueOf(mark));
                        if (mark == 'X') {
                            buttons[row][col].setForeground(Color.RED);
                        } else {
                            buttons[row][col].setForeground(Color.BLUE);
                        }

                        char winner = board.checkWinner();
                        if (winner != '-') {
                            endGame(winner);
                        } else if (board.isFull()) {
                            endGame('-');
                        } else {
                            board.changePlayer();
                            updateInfo();
                        }
                    }
                });
            }
        }

        randomFirstTurn();
        updateInfo();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void randomFirstTurn() {
        board.setCurrentPlayerMark(Math.random() < 0.5 ? 'X' : 'O');
    }

    private void updateInfo() {
        String text = "<html><b>" + player1.name + "</b> vs <b>" + player2.name + "</b><br>";
        text += (board.getCurrentPlayerMark() == 'X' ? player1.name : player2.name) + "'s move (" + (board.getCurrentPlayerMark() == 'X' ? 'X' : 'O') + ")</html>";
        infoLabel.setText(text);
    }

    private void endGame(char winnerMark) {
        gameEnded = true;
        String winnerName = (winnerMark == 'X') ? player1.name : player2.name;
        JOptionPane.showMessageDialog(this, winnerMark == '-' ? "It's a tie!" : winnerName + " wins!");
        System.exit(0);
    }
}


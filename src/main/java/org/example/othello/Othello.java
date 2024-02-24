package org.example.othello;

import org.example.othello.entities.Move;
import org.example.othello.interfaces.GameResult;
import org.example.othello.interfaces.Player;

import java.util.ArrayDeque;
import java.util.Deque;

public class Othello {
    private final Board board;
    private final Player player1;
    private final Player player2;

    public Othello(int size, Player player1, Player player2) {
        this.board = new Board(size);
        this.player1 = player1;
        System.out.println("Player 1: " + player1.getSymbol());
        this.player2 = player2;
        System.out.println("Player 2: " + player2.getSymbol());
    }

    public void play() {
        board.initializeBoard();
        Deque<Player> players = new ArrayDeque<>(2);
        players.add(player1);
        players.add(player2);
        while (true) {
            board.printBoard();
            Player currentPlayer = players.poll();
            System.out.println("Player " + currentPlayer.getSymbol() + " move");
            Move move = currentPlayer.getNextMove(board, currentPlayer.getSymbol());
            boolean isMovePlayed = board.play(move, currentPlayer.getSymbol());
            if (isMovePlayed && board.isGameOver()) {
                System.out.println("Game Over");
                GameResult result = board.getGameResult();
                if (result.getIsDraw()) {
                    System.out.println("Game is a draw");
                } else {
                    System.out.println("Player " + result.getWinner() + " wins");
                }
                board.printBoard();
                break;
            }
            players.add(currentPlayer);
        }
    }
}
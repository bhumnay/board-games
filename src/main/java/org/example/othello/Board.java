package org.example.othello;

import org.example.othello.entities.Move;
import org.example.othello.enums.PlayingSymbol;
import org.example.othello.interfaces.GameResult;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int size;
    private List<List<String>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(" ");
            }
            this.board.add(row);
        }
    }

    void initializeBoard() {
        int mid = size / 2;
        this.board.get(mid - 1).set(mid - 1, PlayingSymbol.BLACK.getSymbol());
        this.board.get(mid - 1).set(mid, PlayingSymbol.WHITE.getSymbol());
        this.board.get(mid).set(mid - 1, PlayingSymbol.WHITE.getSymbol());
        this.board.get(mid).set(mid, PlayingSymbol.BLACK.getSymbol());
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String cell = board.get(i).get(j);
                if (cell.equals(" ")) {
                    cell = "(" + i + "," + j + ")";
                } else {
                    cell = "  " + cell + "  ";
                }
                System.out.print(cell);
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    void flipPieces(int row, int column, PlayingSymbol playerSymbol) {
        String opponentSymbol = playerSymbol.equals(PlayingSymbol.BLACK) ? PlayingSymbol.WHITE.getSymbol() : PlayingSymbol.BLACK.getSymbol();
        for (int i = -1; i <= 1; i++) { // i = -1, 0, 1
            for (int j = -1; j <= 1; j++) { // j = -1, 0, 1
                int x = row + i;
                int y = column + j;
                if (x < 0 || x >= size || y < 0 || y >= size || (i == 0 && j == 0)) {
                    continue;
                }
                if (board.get(x).get(y).equals(opponentSymbol)) { // if the cell is opponent's symbol
                    int dx = i; // direction
                    int dy = j; // direction
                    while (true) { // keep moving in the direction
                        x += dx; // move in the direction
                        y += dy; // move in the direction
                        if (x < 0 || x >= size || y < 0 || y >= size) {
                            break;
                        }
                        if (board.get(x).get(y).equals(playerSymbol.getSymbol())) { // if the cell is player's symbol
                            while (x != row || y != column) { // keep flipping the opponent's symbol to player's symbol
                                x -= dx;
                                y -= dy;
                                board.get(x).set(y, playerSymbol.getSymbol()); // flip the opponent's symbol to player's symbol
                            }
                            break;
                        }
                        if (board.get(x).get(y).equals(" ")) { // if the cell is empty
                            break;
                        }
                    }
                }
            }
        }
    }

    public boolean play(Move move, PlayingSymbol playerSymbol) {
        int row = move.getX();
        int col = move.getY();
        if (row < 0 || row >= size || col < 0 || col >= size) {
            System.out.println("Invalid move");
            return false;
        }
        if (!board.get(row).get(col).equals(" ")) {
            System.out.println("Invalid move");
            return false;
        }
        board.get(row).set(col, playerSymbol.getSymbol());
        flipPieces(row, col, playerSymbol);
        return true;
    }

    public List<Move> getEmptyCells() {
        List<Move> emptyCells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.get(i).get(j).equals(" ")) {
                    emptyCells.add(new Move(i, j));
                }
            }
        }
        return emptyCells;
    }

    public int[] getScores() {
        int blackCount = 0;
        int whiteCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.get(i).get(j).equals("B")) {
                    blackCount++;
                } else if (board.get(i).get(j).equals("W")) {
                    whiteCount++;
                }
            }
        }
        return new int[]{blackCount, whiteCount};
    }

    boolean isGameOver() {
        return getEmptyCells().isEmpty();
    }

    public GameResult getGameResult() {
        int[] scores = getScores();
        int blackCount = scores[0];
        int whiteCount = scores[1];
        if (blackCount > whiteCount) {
            return new GameResult(PlayingSymbol.BLACK, false);
        } else if (blackCount < whiteCount) {
            return new GameResult(PlayingSymbol.WHITE, false);
        } else {
            return new GameResult(null, false);
        }
    }
}

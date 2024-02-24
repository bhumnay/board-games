package org.example.othello.stratergies;

import org.example.othello.Board;
import org.example.othello.entities.Move;
import org.example.othello.enums.PlayingSymbol;
import org.example.othello.interfaces.PlayingStrategy;

import java.util.Scanner;

public class ManualPlayStrategy implements PlayingStrategy {

    @Override
    public Move findBestMove(Board board, PlayingSymbol symbol) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row for next move :");
        int row = scanner.nextInt();
        System.out.println("Enter column for next move :");
        int col = scanner.nextInt();
        return new Move(row, col);
    }
}

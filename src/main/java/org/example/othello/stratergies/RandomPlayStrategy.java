package org.example.othello.stratergies;

import org.example.othello.Board;
import org.example.othello.entities.Move;
import org.example.othello.enums.PlayingSymbol;
import org.example.othello.interfaces.PlayingStrategy;

import java.util.List;

public class RandomPlayStrategy implements PlayingStrategy {

    public Move findBestMove(Board board, PlayingSymbol symbol) {
        List<Move> availableMoves = board.getEmptyCells();
        int randomIndex = (int) (Math.random() * availableMoves.size());
        return availableMoves.get(randomIndex);
    }
}

package org.example.othello.interfaces;

import org.example.othello.Board;
import org.example.othello.entities.Move;
import org.example.othello.enums.PlayingSymbol;

public interface PlayingStrategy {
    public Move findBestMove(Board board, PlayingSymbol symbol);
}

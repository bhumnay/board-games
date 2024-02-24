package org.example.othello.interfaces;

import lombok.Getter;
import org.example.othello.Board;
import org.example.othello.entities.Move;
import org.example.othello.enums.PlayerType;
import org.example.othello.enums.PlayingSymbol;

@Getter()
public abstract class Player {
    private final PlayerType playerType;
    private final PlayingSymbol symbol;
    private final PlayingStrategy playingStrategy;

    public Player(PlayerType playerType, PlayingSymbol symbol, PlayingStrategy playingStrategy) {
        this.playerType = playerType;
        this.symbol = symbol;
        this.playingStrategy = playingStrategy;
    }

    public Move getNextMove(Board board, PlayingSymbol symbol) {
        return playingStrategy.findBestMove(board, symbol);
    }
}

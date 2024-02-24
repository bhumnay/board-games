package org.example.othello.interfaces;

import lombok.Getter;
import org.example.othello.enums.PlayingSymbol;

@Getter()
public class GameResult {
    final PlayingSymbol winner;
    final Boolean isDraw;

    public GameResult(PlayingSymbol winner, Boolean isDraw) {
        this.winner = winner;
        this.isDraw = isDraw;
    }
}

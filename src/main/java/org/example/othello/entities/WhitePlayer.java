package org.example.othello.entities;

import org.example.othello.enums.PlayerType;
import org.example.othello.enums.PlayingSymbol;
import org.example.othello.interfaces.Player;
import org.example.othello.interfaces.PlayingStrategy;

public class WhitePlayer extends Player {
    public WhitePlayer(PlayerType playerType, PlayingStrategy playingStrategy) {
        super(playerType, PlayingSymbol.WHITE, playingStrategy);
    }
}
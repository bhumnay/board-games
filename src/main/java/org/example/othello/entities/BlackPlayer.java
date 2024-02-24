package org.example.othello.entities;

import org.example.othello.enums.PlayerType;
import org.example.othello.enums.PlayingSymbol;
import org.example.othello.interfaces.Player;
import org.example.othello.interfaces.PlayingStrategy;

public class BlackPlayer extends Player {
    public BlackPlayer(PlayerType playerType, PlayingStrategy playingStrategy) {
        super(playerType, PlayingSymbol.BLACK, playingStrategy);
    }
}

package org.example.othello;

import org.example.othello.entities.BlackPlayer;
import org.example.othello.entities.WhitePlayer;
import org.example.othello.enums.PlayerType;
import org.example.othello.interfaces.Player;
import org.example.othello.interfaces.PlayingStrategy;
import org.example.othello.stratergies.ManualPlayStrategy;
import org.example.othello.stratergies.RandomPlayStrategy;

public class Game {
    public static void main(String[] args) {
        int size = 4;
        PlayingStrategy playingStrategy = new RandomPlayStrategy();
        PlayingStrategy humanPlayingStrategy = new ManualPlayStrategy();
        Player player1 = new BlackPlayer(PlayerType.HUMAN, humanPlayingStrategy);
        Player player2 = new WhitePlayer(PlayerType.BOT, playingStrategy);
        Othello othello = new Othello(size, player1, player2);
        othello.play();
    }
}

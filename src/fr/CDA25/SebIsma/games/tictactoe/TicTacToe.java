package fr.CDA25.SebIsma.games.tictactoe;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class TicTacToe extends Board {
    public TicTacToe(Player[] players) {
        super(players, 3, 3);
    }

    @Override
    protected boolean isEnd() {
        return true;
    }
}

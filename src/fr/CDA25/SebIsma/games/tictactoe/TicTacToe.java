package fr.CDA25.SebIsma.games.tictactoe;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class TicTacToe extends Board {
    public TicTacToe(Player[] players, int sizeX, int sizeY) {
        super(players, sizeX, sizeY);
    }

    @Override
    protected boolean isEnd() {
        return false;
    }
}

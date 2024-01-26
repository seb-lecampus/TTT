package fr.CDA25.SebIsma.games.gomoku;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class Gomoku extends Board {
    public Gomoku(Player[] players, int sizeX, int sizeY) {
        super(players, sizeX, sizeY);
    }

    @Override
    protected boolean isEnd() {
        return true;
    }
}

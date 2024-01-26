package fr.CDA25.SebIsma.games.gomoku;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class Gomoku extends Board {
    public Gomoku(Player[] players) {
        super(players, 15, 15);
    }

    @Override
    protected boolean isEnd(int[] last_move) {
        return true;
    }
}

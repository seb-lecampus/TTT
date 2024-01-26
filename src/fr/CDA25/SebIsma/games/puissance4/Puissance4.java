package fr.CDA25.SebIsma.games.puissance4;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class Puissance4 extends Board {
    public Puissance4(Player[] players) {
        super(players, 7, 6);
    }

    @Override
    protected boolean isEnd(int[] last_move) {
        return true;
    }
}

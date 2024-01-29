package fr.CDA25.SebIsma.games.puissance4;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class Puissance4 extends Board {
    public Puissance4(Player[] players) {
        super(players, 7, 6);
    }

    @Override
    protected int[] processMove(int[] last_move) {
        return last_move; // TODO
    }

    @Override
    protected boolean isEnd(int[] last_move) {
        boolean a = checkDir(last_move, new int[]{1, 1}, 4);
        boolean b = checkDir(last_move, new int[]{1, 0}, 4);
        boolean c = checkDir(last_move, new int[]{0, 1}, 4);
        boolean d = checkDir(last_move, new int[]{1, -1}, 4);

        if(a || b || c || d) {
            winner = board[last_move[1]][last_move[0]].getOwner();
            return true;
        } else
            return checkFull();
    }
}

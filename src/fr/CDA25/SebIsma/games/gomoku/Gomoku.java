package fr.CDA25.SebIsma.games.gomoku;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class Gomoku extends Board {
    public Gomoku(Player[] players) {
        super(players, 15, 15);
    }

    @Override
    protected boolean isEnd(int[] last_move) {
        boolean a = checkDir(last_move, new int[]{1, 1}, 5);
        boolean b = checkDir(last_move, new int[]{1, 0}, 5);
        boolean c = checkDir(last_move, new int[]{0, 1}, 5);
        boolean d = checkDir(last_move, new int[]{1, -1}, 5);

        if(a || b || c || d) {
            winner = board[last_move[1]][last_move[0]].getOwner();
            return true;
        } else
            return checkFull();
    }
}

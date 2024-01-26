package fr.CDA25.SebIsma.games.tictactoe;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class TicTacToe extends Board {
    public TicTacToe(Player[] players) {
        super(players, 3, 3);
    }

    @Override
    protected boolean isEnd(int[] last_move) {
        boolean a = checkDir(last_move, new int[]{1, 1}, 3);
        boolean b = checkDir(last_move, new int[]{1, 0}, 3);
        boolean c = checkDir(last_move, new int[]{0, 1}, 3);
        boolean d = checkDir(last_move, new int[]{1, -1}, 3);

        if(a || b || c || d) {
            winner = board[last_move[1]][last_move[0]].getOwner();
            return true;
        } else
            return checkFull();
    }
}

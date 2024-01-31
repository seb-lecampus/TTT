package fr.CDA25.SebIsma.games.puissance4;

import fr.CDA25.SebIsma.games.Game;
import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.View;

public class Puissance4 extends Game {
    public Puissance4(View view) {
        super(view, 7,6);
    }

//    @Override
//    protected int[] processMove(int[] last_move) {
//
//        while(last_move[1]+1 < this.getSizeY() && this.board[last_move[1]+1][last_move[0]].getOwner() == null ) {
//            last_move[1]+=1;
//        }
//        return last_move;
//    }

    @Override
    protected void occupy(int[] last_move, Player current) {
        while(last_move[1]+1 < this.board.getSizeY() && this.board.getBoard()[last_move[1]+1][last_move[0]].getOwner() == null ) {
            last_move[1]+=1;
        }
        super.occupy(last_move, current);
    }

    @Override
    protected boolean isEnd(int[] last_move) {
        boolean a = checkDir(last_move, new int[]{1, 1}, 4);
        boolean b = checkDir(last_move, new int[]{1, 0}, 4);
        boolean c = checkDir(last_move, new int[]{0, 1}, 4);
        boolean d = checkDir(last_move, new int[]{1, -1}, 4);

        if(a || b || c || d) {
            winner = board.getBoard()[last_move[1]][last_move[0]].getOwner();
            return true;
        } else
            return checkFull();
    }

    @Override
    protected int[] getMoveFromPlayer(Board board, Player player) {
        int[] tab = new int[2];
        tab[0] = player.getMoveFromPlayer1D(board);
        return tab;
    }


}

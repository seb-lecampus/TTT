package fr.CDA25.SebIsma.games.puissance4;

import fr.CDA25.SebIsma.games.Game;
import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.View;

/**
 * Puissance 4 game
 */
public class Puissance4 extends Game {
    public Puissance4(View view) {
        super(view, 7,6);
    }


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
    protected int[] getMoveFromPlayer(Board board, Player player ) {

        int[] coordinates = new int[2];
        view.chooseColumnMessage();
        try {
            coordinates[0] = player.getCoordinate(board, this.view.getInteraction());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  coordinates;
    }


}

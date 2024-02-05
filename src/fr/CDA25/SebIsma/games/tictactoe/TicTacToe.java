package fr.CDA25.SebIsma.games.tictactoe;
import fr.CDA25.SebIsma.games.Game;
import fr.CDA25.SebIsma.ui.View;

/**
 * TicTacToe game
 */
public class TicTacToe extends Game {
    public TicTacToe(View view) {
        super(view, 3,3);
    }


    @Override
    public String getName() {
        return "Tic-tac-toe";
    }

    @Override
    protected boolean isEnd(int[] last_move) {
        boolean a = checkDir(last_move, new int[]{1, 1}, 3);
        boolean b = checkDir(last_move, new int[]{1, 0}, 3);
        boolean c = checkDir(last_move, new int[]{0, 1}, 3);
        boolean d = checkDir(last_move, new int[]{1, -1}, 3);

        if(a || b || c || d) {
            winner = board.getBoard()[last_move[1]][last_move[0]].getOwner();
            return true;
        } else
            return checkFull();
    }
}

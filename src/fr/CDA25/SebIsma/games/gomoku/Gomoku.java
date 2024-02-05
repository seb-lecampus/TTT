package fr.CDA25.SebIsma.games.gomoku;
import fr.CDA25.SebIsma.games.Game;
import fr.CDA25.SebIsma.ui.View;

/**
 * Gomoku game
 */
public class Gomoku extends Game {
    public Gomoku(View view) {
        super(view, 15, 15);
    }


    public  String getName(){
        return "Gomoku";
    };

    @Override
    protected boolean isEnd(int[] last_move) {
        boolean a = checkDir(last_move, new int[]{1, 1}, 5);
        boolean b = checkDir(last_move, new int[]{1, 0}, 5);
        boolean c = checkDir(last_move, new int[]{0, 1}, 5);
        boolean d = checkDir(last_move, new int[]{1, -1}, 5);

        if(a || b || c || d) {
            winner = board.getBoard()[last_move[1]][last_move[0]].getOwner();
            return true;
        } else
            return checkFull();
    }
}

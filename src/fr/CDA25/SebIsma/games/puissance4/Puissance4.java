package fr.CDA25.SebIsma.games.puissance4;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class Puissance4 extends Board {
    public Puissance4(Player[] players) {
        super(players, 7, 6);
    }

    @Override
    protected int[] processMove(int[] last_move) {

        while(last_move[1]+1 < this.getSizeY() && this.board[last_move[1]+1][last_move[0]].getOwner() == null ) {
            last_move[1]+=1;
        }
        return last_move;
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

    @Override
    public void play() {
        int tour = 0;
        Player current ;
        int[] last_move = {0, 0};

        do {
            current = players[ tour % players.length];

            do {
                last_move = current.getMoveFromPlayer((Puissance4)this);
            } while(!isValidMove(last_move));

            last_move = processMove(last_move);
            board[last_move[1]][last_move[0]].setOwner(current);

            for(Player p : players){
                if(p != current)
                    p.informPlayerTurn(this, current, last_move);
            }

            ++tour;
        } while(!isEnd(last_move));

        for(Player p : players)
            p.gameEnd(winner);
    }


//    @Override
//    protected boolean isValidMove(int[] move){
//        return isOnBoard(move) && board[0][move[0]].getOwner() == null;
//    }
}

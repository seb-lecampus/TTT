package fr.CDA25.SebIsma.games;
import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.games.board.Cell;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.View;

import java.util.ArrayList;

public abstract class Game {

    protected Board board;

    protected Player[] players;

    protected Player winner = null;
    protected View view;
   public Game(View view ,int sizeX ,int sizeY){
        ArrayList<Player> playersList = new ArrayList<Player>(2);
        this.view = view;

        while(playersList.size() < 2){
            Player p = view.getPlayer();
            if(p != null)
                playersList.add(p);
        }
        this.players = playersList.toArray(new Player[playersList.size()]);
        this.board = new Board(sizeX,sizeY);
    }


    protected int[] getMoveFromPlayer(Board board, Player player){
        return player.getMoveFromPlayer2D(board);
    }
    protected boolean isValidMove(int[] move){
        return board.isOnBoard(move) && board.getBoard()[move[1]][move[0]].getOwner() == null;
    }
    protected void occupy(int[] last_move, Player current) {
        board.getBoard()[last_move[1]][last_move[0]].setOwner(current);
    }
    protected abstract boolean isEnd(int[] last_move);
    public void play(){
        int tour = 0;
        Player current ;
        int[] last_move = {0, 0};

        do {
            current = players[ tour % players.length];

            do {
                last_move = getMoveFromPlayer(this.board, current);
            } while(!isValidMove(last_move));

            //last_move = processMove(last_move);
            occupy(last_move, current);

            for(Player p : players){
                if(p != current)
                    p.informPlayerTurn(this.board, current, last_move);
            }

            ++tour;
        } while(!isEnd(last_move));

        for(Player p : players)
            p.gameEnd(winner);
    }
    protected boolean checkDir(int[] move, int[] dir, int consecutive) {
        int[] cpy = {move[0], move[1]}; // copy of move
        int[] next = {move[0]+dir[0], move[1]+dir[1]}; // next cell in the dir

        // follow owner in the dir
        Player owner = this.board.getBoard()[move[1]][move[0]].getOwner();
        while(this.board.isOnBoard(next) && this.board.getBoard()[next[1]][next[0]].getOwner() == owner){
            cpy[0] = next[0];
            cpy[1] = next[1];
            next[0] = next[0]+dir[0];
            next[1] = next[1]+dir[1];
        }

        //reverse dir
        dir[0] *= -1;
        dir[1] *= -1;

        // own sufficient consecutive cell in the dir  ?
        for(int i=0; i < consecutive; ++i){
            if(!this.board.isOnBoard(cpy))
                return false;
            if(this.board.getBoard()[cpy[1]][cpy[0]].getOwner() != owner)
                return false;
            cpy[0] += dir[0];
            cpy[1] += dir[1];
        }
        return true;
    }
    protected boolean checkFull() {
        for(var line : this.board.getBoard())
            for(Cell cell : line)
                if(cell.getOwner() == null)
                    return false;
        return true;
    }
}

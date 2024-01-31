package fr.CDA25.SebIsma.players.abstractplayer;

import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.ui.View;

public abstract class Player {
     private char representation;


    public Player(char representation){
        this.representation = representation;
    }

    public char getRepresentation() {
        return representation;
    }

    /**
     *
     * @param board
     * @param view
     * @return
     */
    public abstract int[] getMoveFromPlayer2D(Board board, View view);
    public abstract int getMoveFromPlayer1D(Board board, View view);
    //public abstract void informPlayerTurn(Board board, Player player, int[] move);

    //public abstract void gameEnd(Player winner);
 }

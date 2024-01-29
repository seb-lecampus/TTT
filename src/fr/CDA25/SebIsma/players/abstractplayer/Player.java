package fr.CDA25.SebIsma.players.abstractplayer;

import fr.CDA25.SebIsma.games.boad.Board;

public abstract class Player {
     private char representation;

    public Player(char representation){
         this.representation = representation;
     }

     public char getRepresentation() {
         return representation;
     }

     public abstract int[] getMoveFromPlayer2D(Board board);
    public abstract int getMoveFromPlayer1D(Board board);
    public abstract void informPlayerTurn(Board board, Player player, int[] move);

    public abstract void gameEnd(Player winner);
 }

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

     public abstract int[] getMoveFromPlayer(Board board);
    public abstract void informOtherPlayerTurn(Player player, int[] move);

    public abstract void gameEnd(Player winner);
 }

package fr.CDA25.SebIsma.players.abstractplayer;

import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.ui.InteractionUtilisateur;

public abstract class Player {
     private final char representation;


    public Player(char representation){
        this.representation = representation;
    }


    public char getRepresentation() {
        return representation;
    }



    /**
     * get the desired coordinate
     *
     * @param board board on witch to move
     * @param interaction
     * @return the desired coordinate
     */
    public abstract int getCoordinate(Board board, InteractionUtilisateur interaction) throws Exception; // todo ensure board is a copy

 }

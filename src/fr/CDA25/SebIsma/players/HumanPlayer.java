package fr.CDA25.SebIsma.players;

import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.View;

public class HumanPlayer extends Player {

    private View view;
  
    public HumanPlayer(char representation, View view) {
        super(representation);
        this.view = view;
    }

    @Override
    public int[] getMoveFromPlayer2D(Board board, View view) {
        int[] coordinates = new int[2];
        view.displayMessage("choisi la ligne");
        coordinates[0] = view.getMove(board);
        view.displayMessage("choisi la colonne");
        coordinates[1] = view.getMove(board);
        return coordinates;
    }

    public int getMoveFromPlayer1D(Board board, View view) {

        view.displayMessage("choisi la colonne");
        return  view.getMove(board);

    }



    @Override
    public void informPlayerTurn(Board board, Player player, int[] move) {
        this.view.displayMessage("le joueur "+ player.getRepresentation()+" a joué :");
        this.showLastMove(move);
        this.view.displayBoard(board, move);
    }
    private void showLastMove(int[] move) {
        String axis="" ;
        for (int i = 0; i < move.length ; i++) {
            if(i == 0) {
                axis = "ligne";
            }if(i == 1) {
                axis = "colonne";
            }
            this.view.displayMessage(axis+" "+ move[i]);
        }
    }

    @Override
    public void gameEnd(Player winner) {

        if (winner == null) {
            this.view.displayMessage("Egalité ...");
        } else if(winner == this) {
            this.view.displayMessage("tu as gagné");
        } else {
            this.view.displayMessage("t'es nul");
        }
    }

}


package fr.CDA25.SebIsma.players;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.View;

public class HumanPlayer extends Player {

    private View view;
    public HumanPlayer(char representation, View view) {
        super(representation);
        this.view = view;
    }

    @Override
    public int[] getMoveFromPlayer(Board board) {
        return new int[]{0, 0};
    }

    @Override
    public void informPlayerTurn(Board board, Player player, int[] move) {
        this.view.displayMessage("le joueur "+ player.getRepresentation()+" a joué :");
        this.showLastMove(move);
        this.view.displayBoard(board);
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
            System.out.println("Egalité ...");
        } else if(winner == this) {
            System.out.println("tu à gagné");
        } else {
            System.out.println("t'es nul");
        }
    }
    }
}

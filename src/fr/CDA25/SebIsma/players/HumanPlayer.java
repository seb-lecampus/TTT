package fr.CDA25.SebIsma.players;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.games.puissance4.Puissance4;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.InteractionUtilisateur;
import fr.CDA25.SebIsma.ui.View;

public class HumanPlayer extends Player {

    private View view;
    private final InteractionUtilisateur interaction = new InteractionUtilisateur();
    public HumanPlayer(char representation, View view) {
        super(representation);
        this.view = view;
    }

    @Override
    public int[] getMoveFromPlayer(Board board) {
        int[] chosenCoord = new int[2];
        this.view.displayMessage("choisi la ligne");
        chosenCoord[0] = this.getCoordinate();
        this.view.displayMessage("choisi la colonne");
        chosenCoord[1] = this.getCoordinate();
        return chosenCoord;
    }
    public int[] getMoveFromPlayer(Puissance4 board) {
        int[] chosenCoord = new int[2];
        this.view.displayMessage("choisi la colonne");
        chosenCoord[0] = this.getCoordinate();
        return chosenCoord;
    }

    private int getCoordinate(){
        do {
            try {
                return this.interaction.askInt();
            } catch (Exception e) {
                this.view.displayMessage("\u001B[31m"+"entrez un chiffre"+"\u001B[0m");
            }
        }while(true);
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
            this.view.displayMessage("tu à gagné");
        } else {
            this.view.displayMessage("t'es nul");
        }
    }

}


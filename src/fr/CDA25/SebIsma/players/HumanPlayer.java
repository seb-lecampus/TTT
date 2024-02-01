package fr.CDA25.SebIsma.players;

import fr.CDA25.SebIsma.games.Game;
import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.View;

public class HumanPlayer extends Player {


    /**
     * Ctor
     * @param representation Player representation in the {@link Game}
     //* @param view {@link View} to use
     */
    public HumanPlayer(char representation/*, View view*/) {
        super(representation);
        //this.view = view;
    }

    @Override
    public int[] getMoveFromPlayer2D(Board board, View view) {
        int[] coordinates = new int[2];
        view.displayMessage("choisi la ligne");
        coordinates[0] = view.askInt();
        view.displayMessage("choisi la colonne");
        coordinates[1] = view.askInt();
        return coordinates;
    }

    @Override
    public int getMoveFromPlayer1D(Board board, View view) {

        view.displayMessage("choisi la colonne");
        return  view.askInt();

    }

}


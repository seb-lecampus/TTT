package fr.CDA25.SebIsma.players;

import fr.CDA25.SebIsma.games.Game;
import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.InteractionUtilisateur;
import fr.CDA25.SebIsma.ui.View;

/**
 * Player with human interaction
 */
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
    public int getCoordinate(Board board, InteractionUtilisateur interaction) throws Exception {

        return interaction.getInt();
    }

}


package fr.CDA25.SebIsma.players;
import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.InteractionUtilisateur;

/**
 * An artificial player
 */
public class ArtificialPlayer extends Player {

    public ArtificialPlayer() {
        // doit choisir un charactère entre 33 et 127
        super((char)((Math.random()*127)+33));

    }

    @Override
    public int getCoordinate(Board board, InteractionUtilisateur interaction) throws Exception {
        return (int) (Math.random()*(board.getSizeX()+1));
    }


}

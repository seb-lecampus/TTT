package fr.CDA25.SebIsma.players;
import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.games.puissance4.Puissance4;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class ArtificialPlayer extends Player {
    @Override
    public int[] getMoveFromPlayer(Board board) {
        int[] chosenNum = new int[2] ;
        chosenNum[0] = (int) (Math.random()*(board.getSizeX()+1));
        chosenNum[1] = (int) (Math.random()*(board.getSizeY()+1));
        return chosenNum;
    }

    public int[] getMoveFromPlayer(Puissance4 board) {
        int[] chosenNum = new int[1];
        chosenNum[0] = (int) (Math.random()*board.getSizeX());
        return chosenNum;
    }

    @Override
    public void informOtherPlayerTurn(Player player, int[] move) {

    }

    @Override
    public void gameEnd(Player winner) {

    }

    public ArtificialPlayer() {
    // doit choisir un charactère entre 33 et 127
        super((char)((Math.random()*127)+33));

    }
}

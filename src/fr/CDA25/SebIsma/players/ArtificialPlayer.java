package fr.CDA25.SebIsma.players;
import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class ArtificialPlayer extends Player {

    public ArtificialPlayer() {
        // doit choisir un charactère entre 33 et 127
        super((char)((Math.random()*127)+33));

    }

    @Override
    public int[] getMoveFromPlayer2D(Board board) {
        int[] chosenNum = new int[2] ;
        chosenNum[0] = (int) (Math.random()*(board.getSizeX()+1));
        chosenNum[1] = (int) (Math.random()*(board.getSizeY()+1));
        return chosenNum;
    }


    @Override
    public int getMoveFromPlayer1D(Board board) {

        return  (int) (Math.random()*(board.getSizeX()+1));

    }



    public void informPlayerTurn(Board board, Player player, int[] move) {

    }


    public void gameEnd(Player winner) {
    }
}

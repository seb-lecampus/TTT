package fr.CDA25.SebIsma.players;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class ArtificialPlayer extends Player {
    @Override
    public int[] getMoveFromPlayer(Board board) {
        return new int[]{0, 0};
    }

    @Override
    public void informOtherPlayerTurn(Player player, int[] move) {

    }

    @Override
    public void gameEnd(Player winner) {

    }

    public ArtificialPlayer(char representation) {
        super(representation);
    }
}

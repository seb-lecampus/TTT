package fr.CDA25.SebIsma.players;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.View;

public class HumanPlayer extends Player {

    private View view;
    public HumanPlayer(char representation, View view) {
        super(representation);
    }

    @Override
    public void getMoveFromPlayer(Board board) {

    }

    @Override
    public void informOtherPlayerTurn(Player player, int[] move) {

    }

    @Override
    public void gameEnd(Player winner) {

    }
}
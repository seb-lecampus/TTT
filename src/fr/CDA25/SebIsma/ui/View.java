package fr.CDA25.SebIsma.ui;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public interface View {
    public void displayBoard(Board board, int[] lastmove);

    Board getGame(Player[] players);

    Player getPlayer();

    void displayMessage(String message);
}

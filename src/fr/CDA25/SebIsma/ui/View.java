package fr.CDA25.SebIsma.ui;

import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public interface View {
    public void displayBoard(Board board, int[] lastmove);

    int getGame();

    Player getPlayer();


    int[] getMove2D(Board board);

    int getMove1D(Board board);
    void displayMessage(String message);
}

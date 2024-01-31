package fr.CDA25.SebIsma.ui;

import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public interface View {

    /**
     * Display the board
     * @param board board to display
     * @param lastmove last move played
     */
    void displayBoard(Board board, int[] lastmove);

    int askGame();

    Player getPlayer();

    int[] getMove2D(Board board);

    int getMove1D(Board board);

    void displayMessage(String message);
}

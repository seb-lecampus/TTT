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

    /**
     * Game selection
     * @return selected game ID
     */
    int askGame();

    /**
    * Player selection
    * @return Player chosen
    */
    Player getPlayer();

    int getMove(Board board);

    /**
    * Display generic message
    * @param message message to display
    */
    void displayMessage(String message);
}

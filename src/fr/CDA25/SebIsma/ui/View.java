package fr.CDA25.SebIsma.ui;
import fr.CDA25.SebIsma.games.board.Board;

/**
 * Display games
 */
public interface View {

    /**
    * Display the board
    * @param board board to display
    * @param lastmove last move played
    */
    void displayBoard(Board board, int[] lastmove);


    InteractionUtilisateur getInteraction();
    /**
    * Display generic message
    * @param message message to display
    */
    void displayMessage(String message);

    /**
     * warn about bad int
     */
    void warnBadInt();

    /**
     * warn about bad representation
     */
    void warnBadRepresentation();

    /**
     * warn about bad coordinates
     */
    void warnBadCoordinates();

    /**
     * show player's turn
     * @param representation
     */
    void informPlayerTurn(char representation);
}

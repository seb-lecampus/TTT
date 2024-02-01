package fr.CDA25.SebIsma.ui;
import fr.CDA25.SebIsma.games.board.Board;


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

    void warnBadInt();
    void warnBadRepresentation();

    void warnBadCoordinates();
}

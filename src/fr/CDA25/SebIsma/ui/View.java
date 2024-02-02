package fr.CDA25.SebIsma.ui;
import fr.CDA25.SebIsma.games.GameEnum;
import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

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
    void chooselignMessage();
    void chooseColumnMessage();
    void showChooseIaMessage();
    void showPlayedcolumn(int moveX);
    void showPlayedlign(int moveY);
    void chooseSymbol();
    void showChosenIaSymbol(char representation);
    void showTurnPlayer(char representation);

    /**
     * show message of game's end
     * @param winner the player who win
     * @param current the current player
     */
  void gameEndMessage(Player winner, Player current);
   void showMenu(GameEnum[] games);
}

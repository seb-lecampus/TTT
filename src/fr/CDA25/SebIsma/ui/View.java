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

    /**
     * get the {@link InteractionUtilisateur} related to the view
     * @return a suitable {@link InteractionUtilisateur} for this view
     */
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

    /**
     * show choosing line message
     */
    void chooselignMessage();

    /**
     * show choosing column message
     */
    void chooseColumnMessage();

    /**
     * show message to choose a {@link Player}
     */
    void showChooseIaMessage();

    /**
     * show played column
     * @param moveX
     */
    void showPlayedcolumn(int moveX);

    /**
     * show played line
     * @param moveY
     */
    void showPlayedlign(int moveY);

    /**
     * show message to choose a {@link Player} representation
     */
    void chooseSymbol();

    /**
     * show representation selected by ia
     * @param representation
     */
    void showChosenIaSymbol(char representation);

    /**
     * show witch {@link Player} play
     * @param representation
     */
    void showTurnPlayer(char representation);

    /**
     * show message of game's end
     * @param winner the player who win
     * @param current the current player
     */
    void gameEndMessage(Player winner, Player current);

    /**
     * show playable games
     * @param games playable games
     */
    void showMenu(GameEnum[] games);
}

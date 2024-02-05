package fr.CDA25.SebIsma.ui;
import fr.CDA25.SebIsma.games.GameEnum;
import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

/**
 * Display game in terminal
 */
public class Terminal implements View{

    private final InteractionUtilisateur interaction = new TermInteraction();


    /**
     * Prompt user for integer
     * @return user choice
     */
    @Override
    public InteractionUtilisateur getInteraction() {
        return this.interaction;
    }

    /**
     * display the game's board
     * @param board board to display
     * @param lastMove last move played
     */
    @Override
    public void displayBoard(Board board, int[] lastMove){

        for (int i = 0; i < board.getSizeY() ; i++) {

            this.lignBord(board.getSizeX());
            System.out.println();
            for (int j = 0; j < board.getSizeX() ; j++) {

                if(lastMove != null && lastMove[1] == i && lastMove[0] == j){

                    System.out.print("| " +"\u001B[31m" + board.getBoard()[i][j].getOwner().getRepresentation()+ " \u001B[0m");
                }else {
                    System.out.print(board.getBoard()[i][j].getRepresentation());
                }
            }
            System.out.println("|");
        }
        this.lignBord(board.getSizeX());
        System.out.println();
    }

    private void lignBord(int boardSize){
        for (int i = 0; i < boardSize; i++) {
            System.out.print("----");
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void warnBadInt() {
       System.out.println("\u001B[31m" + "Il faut entrer un chiffre" + "\u001B[0m");
    }

    @Override
    public void warnBadRepresentation() {
        System.out.println("\u001B[31m" + "Il faut entrer un charactère" + "\u001B[0m");
    }

    @Override
    public void informPlayerTurn(char representation) {
        System.out.println("le joueur "+ representation+" a joué :");
    }

    @Override
    public void warnBadCoordinates() {
        System.out.println("\u001B[31m" + "case prise ou hors tableau" + "\u001B[0m");
    }

   public void showChooseIaMessage(){
        System.out.println("créer un joueur artificiel ? (y/n) ");
   }

    @Override
    public void chooseColumnMessage() {
        System.out.println("choisi la colonne");
    }
    @Override
    public void chooselignMessage() {
        System.out.println("choisi la ligne");
    }

    @Override
    public void showPlayedcolumn(int moveX) {
        System.out.println("colonne "+moveX);
    }

    @Override
    public void chooseSymbol() {
       System.out.println("Choisir un symbol (un caractere unique)");
    }

    @Override
    public void showPlayedlign(int moveY){
        System.out.println("ligne "+moveY);
    }

    @Override
    public void showChosenIaSymbol(char representation) {
        System.out.println("l'IA a choisi le symbole ");
    }

    @Override
    public void showTurnPlayer(char representation) {
        System.out.println("c'est au joueur \u001B[36m"+ representation+"\u001B[0m de jouer");
    }

     public void gameEndMessage(Player winner, Player current) {

        if (winner == null) {
            this.displayMessage("Egalité ...");
        } else if(winner == current) {
            this.displayMessage("le joueur "+winner.getRepresentation()+" a gagné");
        } else {
            this.displayMessage("t'es nul");
        }
    }
    public void showMenu(GameEnum[] games){

        this.displayMessage("Choisir un jeu");
        int i = 0;
         for(GameEnum game : games){
            this.displayMessage(i+"." + game.toString());
            i++;
        }

    }

    @Override
    public void errorMenuMessage() {
        displayMessage("\u001B[31m choisi un chiffre dans la liste ... \u001B[0m");
    }
}



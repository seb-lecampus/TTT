package fr.CDA25.SebIsma.ui;
import fr.CDA25.SebIsma.games.board.Board;


public class Terminal implements View{

    private final InteractionUtilisateur interaction = new TermInteraction();


    /**
     * Prompt user for integer
     * @return user choice
     * @throws Exception delegate exception handling because it can't print
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
    public void displayBoard(Board board, int[] lastMove){

        for (int i = 0; i < board.getSizeY() ; i++) {

            this.lignBord(board.getSizeX());
            System.out.println();
            for (int j = 0; j < board.getSizeX() ; j++) {

                if(lastMove[1] == i && lastMove[0] == j){

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


}



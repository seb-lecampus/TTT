package fr.CDA25.SebIsma.ui;
import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.players.ArtificialPlayer;
import fr.CDA25.SebIsma.players.HumanPlayer;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

import java.util.concurrent.ExecutionException;

public class Terminal implements View{

    private final InteractionUtilisateur interaction = new InteractionUtilisateur();

    public InteractionUtilisateur getInteraction() {
        return interaction;
    }

    public int askGame() {
        // todo automatisation for new game
        System.out.println("Choisir un jeu");
        System.out.println("1. TicTacToe");
        System.out.println("2. Gomoku");
        System.out.println("3. Puissance 4");
        System.out.println("0. Quitter");


            switch (this.askInt()) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                default:
                    return askGame();
            }

    }

    @Override
    public Player getPlayer() {

        System.out.println("créer un joueur artificiel ? (y/n) ");
        char choice = Character.toLowerCase(this.askChar());

        if(choice == 'y'){

            ArtificialPlayer ai = new ArtificialPlayer();
            System.out.println("l'IA a choisi le symbole "+ ai.getRepresentation() );
            return ai;
        } else if (choice == 'n') {
            System.out.println("Choisir un symbol (un caractere unique)");
            char symbol = this.askChar();
            return new HumanPlayer(symbol, this);
        } else{
            return getPlayer();
        }

    }
    private char askChar(){
        do {
            try{
                return this.interaction.getChar();
            }catch(Exception e){
                this.interaction.getScan().nextLine();
                System.out.println("\u001B[31m" + "Il faut entrer un caractère" + "\u001B[0m");
            }
        }while(true);
    }
    public int askInt(){
        do {
            try{
                return this.interaction.getInt();
            }catch(Exception e){
                this.interaction.getScan().nextLine();
                System.out.println("\u001B[31m" + "Il faut entrer un chiffre" + "\u001B[0m");
            }
        }while(true);
    }

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




    public int getMove1D(Board board) {
        this.displayMessage("choisi la colonne");
        return this.askInt();
    }
}



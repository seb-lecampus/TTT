package fr.CDA25.SebIsma;

import fr.CDA25.SebIsma.games.Game;
import fr.CDA25.SebIsma.games.gomoku.Gomoku;
import fr.CDA25.SebIsma.games.puissance4.Puissance4;
import fr.CDA25.SebIsma.games.tictactoe.TicTacToe;
import fr.CDA25.SebIsma.ui.Terminal;
import fr.CDA25.SebIsma.ui.View;

/**
 * Act as factory for creating {@link Game}
 */
public class GameInit {

    private Game game;
    private final View view ;


    /**
     * -UI to use GUI {@link View}
     * @param args args from the command line
     */
    public GameInit(String[] args){
        if(args.length != 0 && args[0].equals("UI"))
            this.view = new Terminal();
        else
            this.view = new Terminal();
    }

    private int askInt(){
        do{
            try{
                return this.view.getInteraction().getInt();
            }catch (Exception e){
                this.view.displayMessage("\u001B[31m" + "Il faut entrer un chiffre" + "\u001B[0m");
            }
        }while(true);
    }

    /**
     * Show game menu
     * @return the game chosen
     */
    public Game buildGame() {
        return switch (this.askGame()) {
           case 1 -> new TicTacToe(this.view);
           case 2 -> new Gomoku(this.view);
           case 3 -> new Puissance4(this.view);
           case 0 -> null;
           default -> buildGame();
        };
    }

    /**
     * Prompt user for integer
     * @return user choice
     * @throws Exception delegate exception handling because it can't print
     */
    public int askGame() {

        this.view.displayMessage("Choisir un jeu");
        this.view.displayMessage("1. TicTacToe");
        this.view.displayMessage("2. Gomoku");
        this.view.displayMessage("3. Puissance 4");
        this.view.displayMessage("0. Quitter");

        return switch (this.askInt()) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> 3;
            case 0 -> 0;
            default -> askGame();
        };


    }
}

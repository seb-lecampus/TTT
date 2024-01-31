package fr.CDA25.SebIsma;

import fr.CDA25.SebIsma.games.Game;
import fr.CDA25.SebIsma.games.gomoku.Gomoku;
import fr.CDA25.SebIsma.games.puissance4.Puissance4;
import fr.CDA25.SebIsma.games.tictactoe.TicTacToe;
import fr.CDA25.SebIsma.ui.Terminal;
import fr.CDA25.SebIsma.ui.View;

/**
 * Act as factory for creating games
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

    /**
     * Show game menu
     * @return the game chosen
     */
    public Game getGame() {
        return switch (this.view.askGame()) {
           case 1 -> new TicTacToe(this.view);
           case 2 -> new Gomoku(this.view);
           case 3 -> new Puissance4(this.view);
           case 0 -> null;
           default -> getGame();
        };
    }
}

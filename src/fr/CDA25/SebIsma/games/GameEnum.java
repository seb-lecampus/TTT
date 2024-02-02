package fr.CDA25.SebIsma.games;

import fr.CDA25.SebIsma.games.gomoku.Gomoku;
import fr.CDA25.SebIsma.games.puissance4.Puissance4;
import fr.CDA25.SebIsma.games.tictactoe.TicTacToe;
import fr.CDA25.SebIsma.ui.View;

/**
 * Enum containing all instantiable game
 */
public enum GameEnum {
    EXIT (){
        @Override
        public String toString() {
            return "Quitter";
        }
    },
    TICTACTOE () {
        @Override
        public Game getGame(View view) {
            return new TicTacToe(view);
        }

        @Override
        public String toString() {
            return "Tic-tac-toe";
        }
    },
    GOMOKU () {
        @Override
        public Game getGame(View view) {
            return new Gomoku(view);
        }
        @Override
        public String toString() {
            return "Gomoku";
        }
    },
    PUISSANCE4 () {
        @Override
        public Game getGame(View view) {
            return new Puissance4(view);
        }
        @Override
        public String toString() {
            return "Puissance 4";
        }
    };

    /**
     * Get {@link Game} from the enum
     * @param view the {@link View} to use by the instanced game
     * @return instance of a {@link Game}
     */
    public Game getGame(View view){
        return null;
    }
}

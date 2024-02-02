package fr.CDA25.SebIsma.games;

import fr.CDA25.SebIsma.games.gomoku.Gomoku;
import fr.CDA25.SebIsma.games.puissance4.Puissance4;
import fr.CDA25.SebIsma.games.tictactoe.TicTacToe;
import fr.CDA25.SebIsma.ui.View;

public enum GameEnum {
    TICTACTOE () {
        @Override
        public Game getGame(View view) {
            return new TicTacToe(view);
        }
    },
    GOMOKU () {
        @Override
        public Game getGame(View view) {
            return new Gomoku(view);
        }
    },
    PUISSANCE4 () {
        @Override
        public Game getGame(View view) {
            return new Puissance4(view);
        }
    };

    public Game getGame(View view){
        return null;
    }
}

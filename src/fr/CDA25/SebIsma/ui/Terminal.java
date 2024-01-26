package fr.CDA25.SebIsma.ui;
import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.games.boad.Cell;
import fr.CDA25.SebIsma.games.gomoku.Gomoku;
import fr.CDA25.SebIsma.games.puissance4.Puissance4;
import fr.CDA25.SebIsma.games.tictactoe.TicTacToe;
import fr.CDA25.SebIsma.players.ArtificialPlayer;
import fr.CDA25.SebIsma.players.HumanPlayer;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class Terminal implements View{

    private final InteractionUtilisateur interaction = new InteractionUtilisateur();




    @Override
    public Board getGame(Player[] players) {
        // todo automatisation for new game
        System.out.println("Choisir un jeu");
        System.out.println("1. TicTacToe");
        System.out.println("2. Gomoku");
        System.out.println("3. Puissance 4");
        switch(interaction.askInt()){
            case 1:
                return new TicTacToe(players, 3, 3);
            case 2:
                return new Gomoku(players, 15, 15);
            case 3:
                return new Puissance4(players, 7, 6);
        }
        return null;
    }

    @Override
    public Player getPlayer() {

        System.out.println("créer un joueur artificiel ? (y/n) ");
        char choice = Character.toLowerCase(this.interaction.askChar());

        if(choice == 'y'){

            ArtificialPlayer ai = new ArtificialPlayer();
            System.out.println("l'IA a choisi le symbole "+ ai.getRepresentation() );
            return ai;
        }else{
            System.out.println("Choisir un symbol (un caractere unique)");
            char symbol = this.interaction.askChar();
            return new HumanPlayer(symbol, this);
        }

    }

    public void displayBoard(Board board, int[] lastMove){
            String color = "";
        for (int i = 0; i < board.getSizeX() ; i++) {
            this.lignBord(board.getSizeX());
            for (int j = 0; j < board.getSizeY() ; j++) {
                if(lastMove[1] == i && lastMove[0] == j){
                    color = "\u001B[31m";
                }
                System.out.println(color + board.getBoard()[i][j].getRepresentation()+ "\u001B[0m");
            }
        }
    }

    private void lignBord(int boardSize){
        for (int i = 0; i < boardSize; i++) {
            System.out.print("-----");
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}



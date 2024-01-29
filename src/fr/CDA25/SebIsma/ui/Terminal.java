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
        do {
            try {
                switch (interaction.askInt()) {
                    case 1:
                        return new TicTacToe(players);
                    case 2:
                        return new Gomoku(players);
                    case 3:
                        return new Puissance4(players);
                }
            } catch (Exception e) {
                System.out.println("\u001B[31m"+"Il faut entrer un chiffre"+"\u001B[0m");
            }
        }while(true);

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

        for (int i = 0; i < board.getSizeY() ; i++) {

            this.lignBord(board.getSizeY());
            System.out.println();
            for (int j = 0; j < board.getSizeX() ; j++) {
                String color = "";
                if(lastMove[1] == i && lastMove[0] == j){

                    System.out.print("| " +"\u001B[31m" + board.getBoard()[i][j].getOwner().getRepresentation()+ " \u001B[0m");
                }else {
                    System.out.print(board.getBoard()[i][j].getRepresentation());
                }
            }
            System.out.println("|");
        }
        this.lignBord(board.getSizeY());
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
}



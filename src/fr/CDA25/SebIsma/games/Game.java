package fr.CDA25.SebIsma.games;
import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.games.board.Cell;
import fr.CDA25.SebIsma.players.ArtificialPlayer;
import fr.CDA25.SebIsma.players.HumanPlayer;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.View;

import java.util.ArrayList;

public abstract class Game {

    protected Board board;

    protected Player[] players;

    protected Player winner = null;
    protected View view;
    public Game(View view ,int sizeX ,int sizeY){
        ArrayList<Player> playersList = new ArrayList<Player>(2);
        this.view = view;

        while(playersList.size() < 2){
            Player p = this.buildPlayer();
            if(p != null)
                playersList.add(p);
        }
        this.players = playersList.toArray(new Player[playersList.size()]);
        this.board = new Board(sizeX,sizeY);
    }

    public Player buildPlayer() {

        this.view.displayMessage("créer un joueur artificiel ? (y/n) ");
        char choice = Character.toLowerCase(this.askChar());

        if(choice == 'y'){

            ArtificialPlayer ai = new ArtificialPlayer();
            this.view.displayMessage("l'IA a choisi le symbole "+ ai.getRepresentation() );
            return ai;
        } else if (choice == 'n') {
            this.view.displayMessage("Choisir un symbol (un caractere unique)");
            char symbol = this.askChar();
            return new HumanPlayer(symbol/*, this*/);
        } else{
            return buildPlayer();
        }

    }
    private char askChar(){
        do{
            try{
                return this.view.getInteraction().getChar();
            }catch (Exception e){
               this.view.warnBadRepresentation();
            }
        }while(true);
    }

    /**
     * get the coordinates which choose by the player
     * @param board
     * @param player
     * @return the coordinates which the player want to occupy
     */
    protected int[] getMoveFromPlayer(Board board, Player player) throws Exception{
        int[] coordinates = new int[2];

        view.displayMessage("choisi la colonne ");
        coordinates[0] = player.getCoordinate(board, this.view.getInteraction() );

        view.displayMessage("choisi la ligne");
        coordinates[1] = player.getCoordinate(board,this.view.getInteraction() );

        return coordinates;
    }

    /**
     * check if the cell which choose by the player is valid
     * @param move
     * @return boolean
     */
    protected boolean isValidMove(int[] move){
        return board.isOnBoard(move) && board.getBoard()[move[1]][move[0]].getOwner() == null;
    }

    /**
     * set the player as cell's owner
     * @param last_move
     * @param current
     */
    protected void occupy(int[] last_move, Player current) {

        board.getBoard()[last_move[1]][last_move[0]].setOwner(current);
    }
    protected abstract boolean isEnd(int[] last_move);

    /**
     * Start the game
     */
    public void play(){

        int tour = 0;

        Player current ;

        int[] last_move = {0, 0};

        do {
            current = players[ tour % players.length];

            do {
                try {
                    last_move = getMoveFromPlayer(this.board, current);
                    if (!isValidMove(last_move)) {
                        this.view.warnBadCoordinates();
                    } else {
                        break;
                    }
                }catch(Exception e){
                    this.view.warnBadCoordinates();
                }

            } while(true);

            occupy(last_move, current);

            this.informPlayerTurn(this.board, current, last_move);

            ++tour;

        } while(!isEnd(last_move));

        this.gameEndMessage(winner, current);
    }


    protected boolean checkDir(int[] move, int[] dir, int consecutive) {

        int[] cpy = {move[0], move[1]}; // copy of move
        int[] next = {move[0]+dir[0], move[1]+dir[1]}; // next cell in the dir

        // follow owner in the dir
        Player owner = this.board.getBoard()[move[1]][move[0]].getOwner();

        while(this.board.isOnBoard(next) && this.board.getBoard()[next[1]][next[0]].getOwner() == owner){
            cpy[0] = next[0];
            cpy[1] = next[1];
            next[0] = next[0]+dir[0];
            next[1] = next[1]+dir[1];
        }

        //reverse dir
        dir[0] *= -1;
        dir[1] *= -1;

        // own sufficient consecutive cell in the dir  ?
        for(int i=0; i < consecutive; ++i){

            if(!this.board.isOnBoard(cpy))
                return false;

            if(this.board.getBoard()[cpy[1]][cpy[0]].getOwner() != owner)
                return false;
            cpy[0] += dir[0];
            cpy[1] += dir[1];

        }
        return true;
    }
    protected boolean checkFull() {
        for(var line : this.board.getBoard())
            for(Cell cell : line)
                if(cell.getOwner() == null)
                    return false;
        return true;
    }

    /**
     * show the information at start of the player's turn
     * @param board the game's board
     * @param player the current player
     * @param move the last move of previous player
     */
    public void informPlayerTurn(Board board, Player player, int[] move) {

        this.view.displayMessage("le joueur "+ player.getRepresentation()+" a joué :");
        this.showLastMove(move);
        this.view.displayBoard(board, move);

    }

    /**
     * show messages with coordinates of last move
     * @param move last given coordinates
     */
    private void showLastMove(int[] move) {
        String axis="" ;

        for (int i = 0; i < move.length ; i++) {

            if(i == 0) {
                axis = "ligne";

            }if(i == 1) {
                axis = "colonne";
            }

            this.view.displayMessage(axis+" "+ move[i]);
        }
    }

    /**
     * show message of game's end
     * @param winner the player who win
     * @param current the current player
     */
    private void gameEndMessage(Player winner, Player current) {

        if (winner == null) {
            this.view.displayMessage("Egalité ...");
        } else if(winner == current) {
            this.view.displayMessage("le joueur "+winner.getRepresentation()+" a gagné");
        } else {
            this.view.displayMessage("t'es nul");
        }
    }
}

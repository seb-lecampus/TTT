package fr.CDA25.SebIsma.games;
import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.games.board.Cell;
import fr.CDA25.SebIsma.players.ArtificialPlayer;
import fr.CDA25.SebIsma.players.HumanPlayer;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.Terminal;
import fr.CDA25.SebIsma.ui.View;

import java.io.*;
import java.util.ArrayList;

/**
 * Game controller
 */
public abstract class Game implements Serializable {


    protected Board board;

    protected Player[] players;

    protected int tour =0;
    transient protected Player winner = null;
    transient protected View view;


    public Board getBoard() {
        return board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public int getTour() {
        return tour;
    }


    /**
     * Ctor
     * @param view {@link View} to use
     * @param sizeX number of {@link Cell} in width
     * @param sizeY number of {@link Cell} in height
     */
    public Game(View view ,int sizeX ,int sizeY){
        this.view = view;
        try {
             Game game = loadGame();
             this.board = game.getBoard();
             this.tour = game.getTour();
             this.players = game.getPlayers();

        }catch(Exception e) {
            ArrayList<Player> playersList = new ArrayList<Player>(2);

            while (playersList.size() < 2) {
                Player p = this.buildPlayer();
                if (p != null)
                    playersList.add(p);
            }
            this.players = playersList.toArray(new Player[playersList.size()]);
            this.board = new Board(sizeX, sizeY);
        }

    }

    private Game loadGame() throws Exception{

        final FileInputStream fichier = new FileInputStream("C:\\Users\\ismael.vas\\Desktop\\github\\bibliotheque_de_jeux\\sauvegarde\\"+ this.getName());
        ObjectInputStream ois = new ObjectInputStream(fichier);
        return (Game) ois.readObject();

    }
    abstract public String getName();
    /**
     * Build a {@link Player}
     * @return a {@link Player} built according user choice
     */
    protected Player buildPlayer() {

        this.view.showChooseIaMessage();
        char choice = Character.toLowerCase(this.askChar());

        if(choice == 'y'){

            ArtificialPlayer ai = new ArtificialPlayer();
            this.view.showChosenIaSymbol(ai.getRepresentation());
            return ai;
        } else if (choice == 'n') {
            this.view.chooseSymbol();
            char symbol = this.askChar();
            return new HumanPlayer(symbol/*, this*/);
        } else{
            return buildPlayer();
        }

    }
    protected char askChar(){
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

        view.chooseColumnMessage();
        coordinates[0] = player.getCoordinate(board, this.view.getInteraction() );

        view.chooselignMessage();
        coordinates[1] = player.getCoordinate(board,this.view.getInteraction() );

        return coordinates;
    }

    /**
     * check if the cell which choose by the player is valid
     * @param move
     * @return is valid cell or not
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


        Player current ;

        int[] last_move = {0, 0};
        this.view.displayBoard(this.board, null);
        do {

            this.saveGame();

            current = players[ tour % players.length];
            this.view.showTurnPlayer(current.getRepresentation());
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

        this.view.gameEndMessage(winner, current);
    }
    private void saveGame(){
        try {
            final FileOutputStream fichier = new FileOutputStream("C:\\Users\\ismael.vas\\Desktop\\github\\bibliotheque_de_jeux\\sauvegarde/"+this.getName());
            ObjectOutputStream oos = new ObjectOutputStream(fichier);
            oos.writeObject(this);
        } catch (Exception e) {
            System.out.println("proleme");
        }
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
    protected void informPlayerTurn(Board board, Player player, int[] move) {

        this.view.informPlayerTurn(player.getRepresentation());
        this.view.showPlayedcolumn(move[0]);
        this.view.showPlayedlign(move[1]);
        this.view.displayBoard(board, move);

    }


}

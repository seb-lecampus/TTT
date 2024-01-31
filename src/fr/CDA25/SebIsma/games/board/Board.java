package fr.CDA25.SebIsma.games.board;

public class Board {

    private final Cell[][] board;

    private final int sizeX, sizeY;

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public Board(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        board = new Cell[this.sizeY][this.sizeX];
        this.buildBoard(this.board);
    }

        /**
         * build the board's cell
         * @param board the board on which construct the cells
         */
        private void buildBoard(Cell[][] board){

        for (int i = 0; i < this.getSizeY() ; i++) {
            for (int j = 0; j < getSizeX(); j++) {
               board[i][j] = new Cell();
            }
        }
    }

    /**
     * check if the move is not out of the board
     * @param move the array of coordinates which choose by the player
     * @return boolean
     */
    public boolean isOnBoard(int[] move){

        int x = move[0];
        int y = move[1];

        if(!(x >= 0 && x < sizeX))
            return false;
        if(!(y >= 0 && y < sizeY))
            return false;

        return true;
    }




}
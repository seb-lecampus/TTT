package fr.CDA25.SebIsma.games.boad;

import fr.CDA25.SebIsma.players.abstractplayer.Player;

public abstract class Board {
protected Cell[][] board;

protected Player[] players;
protected Player winner;

private int sizeX, sizeY;

public int getSizeX() {
    return sizeX;
}

public int getSizeY() {
    return sizeY;
}

public Board(Player[] players, int sizeX, int sizeY){
    this.players = players;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    // todo Cell[][]
}

public void play(){
    int tour = 0;
    Player current, winner=null;
    int[] last_move = {0, 0};

    do {
        current = players[ tour % players.length];

        do {
            last_move = current.getMoveFromPlayer(this);
        } while(!isValidMove(last_move));

        last_move = processMove(last_move);
        board[last_move[1]][last_move[0]].setOwner(current);

        for(Player p : players){
            if(p != current)
                p.informPlayerTurn(this, current, last_move);
        }
    } while(!isEnd(last_move));

    for(Player p : players)
        p.gameEnd(winner);
}


protected abstract boolean isEnd(int[] last_move);

protected int[] processMove(int[] last_move){
    return last_move;
}
protected boolean checkDir(int[] move, int[] dir, int consecutive) {
    int[] cpy = {move[0], move[1]}; // copy of move
    int[] next = {move[0]+dir[0], move[1]+dir[1]}; // next cell in the dir

    // follow owner in the dir
    Player owner = this.board[move[1]][move[0]].getOwner();
    while(isOnBoard(next) && this.board[next[1]][next[0]].getOwner() == owner){
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
        if(!isOnBoard(cpy))
            return false;
        if(this.board[cpy[1]][cpy[0]].getOwner() != owner)
            return false;
        cpy[0] += dir[0];
        cpy[1] += dir[1];
    }
    return true;
}

protected boolean isOnBoard(int[] move){
    int x = move[0];
    int y = move[1];

    if(!(x >= 0 && x < sizeX))
        return false;
    if(!(y >= 0 && y < sizeY))
        return false;

    return true;
}

protected boolean isValidMove(int[] move){
    return isOnBoard(move) && board[move[1]][move[0]].getOwner() == null;
}

protected boolean checkFull() {
    for(var line : this.board)
        for(Cell cell : line)
            if(cell.getOwner() == null)
                return false;
    return true;
}
}
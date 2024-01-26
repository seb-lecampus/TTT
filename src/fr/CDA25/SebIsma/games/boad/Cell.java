package fr.CDA25.SebIsma.games.boad;

import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class Cell {
    private Player owner;

    public String getRepresentation(){
        if(this.owner == null){
            return "|   ";
        }else{
            return "| "+this.owner.getRepresentation()+" ";
        }
    }

    public void SetOwner(Player owner){
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }
}

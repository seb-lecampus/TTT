package fr.CDA25.SebIsma.games.board;

import fr.CDA25.SebIsma.players.abstractplayer.Player;

import java.io.Serializable;

/**
 * A cell of a {@link Board}
 */
public class Cell implements Serializable {
    private Player owner;

    /**
     * get cell's representation.
     * @return cell's representation.
     */
    public String getRepresentation(){
        if(this.owner == null){
            return "|   ";
        }else{
            return "| "+this.owner.getRepresentation()+" ";
        }
    }


    public void setOwner(Player owner){
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }
}

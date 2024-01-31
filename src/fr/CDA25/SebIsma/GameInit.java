package fr.CDA25.SebIsma.games;

import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.Terminal;
import fr.CDA25.SebIsma.ui.View;

import java.util.ArrayList;

public class GameInit {

    private Game game;
    private View view ;

    GameInit(String[] args){
        if(args.length != 0 && args[0].equals("UI"))
            this.view = new Terminal();
        else
            this.view = new Terminal();
    }
}

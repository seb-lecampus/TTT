import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.Terminal;
import fr.CDA25.SebIsma.ui.View;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        View ui;
        ArrayList<Player> players = new ArrayList<Player>(2); // todo remove Magic number

        if(args.length != 0 && args[0].equals("UI"))
            ui = new Terminal();
        else
            ui = new Terminal();

        while(players.size() < 2){
            Player p = ui.getPlayer();
            if(p != null)
                players.add(p);
        }



        Board game = ui.getGame( (Player[]) players.toArray(new Player[players.size()] ));
            game.play();
    }
}
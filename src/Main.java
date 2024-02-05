import fr.CDA25.SebIsma.games.GameInit;
import fr.CDA25.SebIsma.games.Game;
import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.ui.Terminal;
import fr.CDA25.SebIsma.ui.View;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;


public class Main {

    public static void main(String[] args) {
        do {
            Game game = new GameInit(args).askGame();
            if (game != null) {
                game.play();

            } else {
                break;
            }
        } while (true);
    }
}
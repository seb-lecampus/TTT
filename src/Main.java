import fr.CDA25.SebIsma.GameInit;
import fr.CDA25.SebIsma.games.Game;


public class Main {

    public static void main(String[] args) {
        do {
            Game game = new GameInit(args).buildGame();
            if (game != null) {
                game.play();
            } else {
                break;
            }
        } while (true);;
    }
}
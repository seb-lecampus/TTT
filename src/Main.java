import fr.CDA25.SebIsma.GameInit;
import fr.CDA25.SebIsma.games.Game;


public class Main {
    // todo voir si on met GameInit en singleton et en faire une factory 
    public static void main(String[] args) {
        do {
            Game game = new GameInit(args).getGame();
            if (game != null) {
                game.play();
            } else {
                break;
            }
        } while (true);;
    }
}
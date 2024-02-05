package fr.CDA25.SebIsma.games;
import fr.CDA25.SebIsma.ui.Terminal;
import fr.CDA25.SebIsma.ui.View;

/**
 * Act as factory for creating {@link Game}
 */
public class GameInit {

    private Game game;
    private final View view ;


    /**
     * -UI to use GUI {@link View}
     * @param args args from the command line
     */
    public GameInit(String[] args){
        if(args.length != 0 && args[0].equals("UI"))
            this.view = new Terminal();
        else
            this.view = new Terminal();
    }

    private int askInt(){
        do{
            try{
                return this.view.getInteraction().getInt();
            }catch (Exception e){
                this.view.warnBadInt();
            }
        }while(true);
    }


    /**
     * Prompt user for integer
     * @return user choice
     */
    public Game askGame() {
        GameEnum[] games = GameEnum.values();
        this.view.showMenu(games);
        return games[this.askInt()].getGame(this.view);
    }
}

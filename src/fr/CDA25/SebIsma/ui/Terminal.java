package fr.CDA25.SebIsma.ui;
import fr.CDA25.SebIsma.games.boad.Board;
import fr.CDA25.SebIsma.players.ArtificialPlayer;
import fr.CDA25.SebIsma.players.HumanPlayer;
import fr.CDA25.SebIsma.players.abstractplayer.Player;

public class Terminal implements View{

    private final InteractionUtilisateur interaction = new InteractionUtilisateur();

    @Override
    public Board getGame(Player[] players) {
        return null;
    }

    @Override
    public Player getPlayer() {

        System.out.println("créer un joueur artificiel ? (y/n) ");
        char choice = this.interaction.askChar();
        System.out.println("Choisir un symbol (un caractere unique)");

        char symbol = this.interaction.askChar();
        if(choice == 'y'){
            return new ArtificialPlayer(symbol);
        }else{
            return new HumanPlayer(symbol, this);
        }

    }
}



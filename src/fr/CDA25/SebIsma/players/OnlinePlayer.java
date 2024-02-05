package fr.CDA25.SebIsma.players;

import fr.CDA25.SebIsma.games.board.Board;
import fr.CDA25.SebIsma.players.abstractplayer.Player;
import fr.CDA25.SebIsma.ui.InteractionUtilisateur;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class OnlinePlayer extends Player {
    Socket socket;
    PrintWriter printWriter;
    BufferedReader in;

    public OnlinePlayer(Socket socket){
        super('O');
        this.socket = socket;
        try {
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int getCoordinate(Board board, InteractionUtilisateur interaction) throws Exception {
        System.out.println("send");

        printWriter.println("DONNE MOI DES COORDONNEES");
        //printWriter.flush();
        //printWriter.close();
    int i =0;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            i = Integer.parseInt(in.readLine());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(i);
        return i;
    }
}

package fr.CDA25.SebIsma.ui;

import java.util.Scanner;

public class TermInteraction implements InteractionUtilisateur{

    private final Scanner scan = new Scanner(System.in);

    /**
     * get integer from the terminal
     * @return the integer
     * @throws Exception
     */
    public int getInt() throws Exception {

        try{
            return this.scan.nextInt();
        } finally {
            this.scan.nextLine();
        }
    }

    /**
     * get character from the terminal
     * @return the character
     */
    public char getChar(){

        return  this.scan.nextLine().charAt(0);

    }
}

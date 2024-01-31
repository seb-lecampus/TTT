package fr.CDA25.SebIsma.ui;

import java.util.Scanner;

public class InteractionUtilisateur {

    Scanner scan = new Scanner(System.in);

    public Scanner getScan() {
        return scan;
    }

    /**
     * Prompt user for integer
     * @return user choice
     * @throws Exception delegate exception handling because it can't print
     */
    public int getInt() throws Exception {

        int i = this.scan.nextInt();
        this.scan.nextLine();
        return i;
    }
    /**
     * Prompt user for integer
     * @return user choice
     * @throws Exception delegate exception handling because it can't print
     */
    public char getChar() throws Exception{

        return this.scan.nextLine().charAt(0);

    }


}

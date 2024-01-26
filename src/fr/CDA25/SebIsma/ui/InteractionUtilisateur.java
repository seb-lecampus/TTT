package fr.CDA25.SebIsma.ui;

import java.util.Scanner;

public class InteractionUtilisateur {

    Scanner scan = new Scanner(System.in);
    public int askInt(){
        do {
            try {
                return this.scan.nextInt();
            } catch (Exception e) {
                this.scan.next();
            }
        } while (true);
    }

    public char askChar(){
        return this.scan.nextLine().charAt(0);
    }

}

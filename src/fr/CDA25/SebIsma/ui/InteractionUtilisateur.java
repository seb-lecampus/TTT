package fr.CDA25.SebIsma.ui;

/**
 * Handle interaction with user
 */
public interface InteractionUtilisateur {

    /**
     * Prompt user for integer
     * @return user choice
     * @throws Exception delegate exception handling because it can't print
     */
    int getInt() throws Exception;

    /**
     * Prompt user for integer
     * @return user choice
     * @throws Exception delegate exception handling because it can't print
     */
    char getChar() throws Exception;

}

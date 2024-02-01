package fr.CDA25.SebIsma.ui;


public interface InteractionUtilisateur {



    /**
     * Prompt user for integer
     * @return user choice
     * @throws Exception delegate exception handling because it can't print
     */
    public int getInt() throws Exception;
    /**
     * Prompt user for integer
     * @return user choice
     * @throws Exception delegate exception handling because it can't print
     */
    public char getChar() throws Exception;

}

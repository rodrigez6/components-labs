package danyliuk.mykola.util;

/**
 * @author Mykola Danyliuk
 */
public class Parser {

    public static int parseInt(String s) throws NumberFormatException{
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e){
            throw new NumberFormatException("Invalid integer: " + s);
        }
    }

    public static double parseDouble(String s) throws NumberFormatException{
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e){
            throw new NumberFormatException("Invalid integer: " + s);
        }
    }

}

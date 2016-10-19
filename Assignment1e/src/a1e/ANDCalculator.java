package a1e;

/**
 * Calculator for AND.
 * 
 * @author Geoff McLennan
 * @version 1.0
 */
public class ANDCalculator extends Calculator {
    
    /**
     * Sets parent calculator type.
     */
    public ANDCalculator() {
        super("&");
    }
    
    /**
     * Calculates the table value base on position.
     * 
     * @param valX x position
     * @param valY y position
     */
    public float calcValue(int valX, int valY) {
        return valX & valY;
    }
}

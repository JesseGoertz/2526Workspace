package a1d;

/**
 * Calculator for division.
 * 
 * @author GeoffMcLennan
 * @version 1.0
 */
public class DivisionCalculator extends Calculator {
    
    /**
     * Sets parent calculator type.
     */
    public DivisionCalculator() {
        super("/");
    }
    
    /**
     * Calculates the table value based on position.
     * 
     * @param valX x position
     * @param valY y position
     * @return calculated value
     */
    public float calcValue(int valX, int valY) {
        return (float) valX / valY;
    }

}

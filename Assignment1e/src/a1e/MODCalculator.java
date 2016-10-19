package a1e;

/**
 * Calculator for addition.
 * 
 * @author GeoffMcLennan
 * @version 1.0
 */
public class MODCalculator extends Calculator {
    
    /**
     * Sets parent calculator type.
     */
    public MODCalculator() {
        super("%");
    }
    
    /**
     * Calculates the table value based on position.
     * 
     * @param valX x position
     * @param valY y position
     * @return calculated value
     */
    public float calcValue(int valX, int valY) {
        return valX % valY;
    }

}

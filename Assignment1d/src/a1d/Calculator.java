package a1d;

/**
 * Abstract template of calculators.
 * 
 * @author GeoffMcLennan
 * @version 1.0
 */
public abstract class Calculator {
    
    private String type;
    
    /**
     * Saves the calculator type on creation.
     * 
     * @param str type
     */
    protected Calculator(String str) {
        type = str;
    }
    
    /**
     * Gets the calculator type.
     * 
     * @return type of calculator
     */
    public String getDescription() {
        return type;
    }
    
    /**
     * Calculates the table value based on position.
     * 
     * @param valX x position
     * @param valY y position
     * @return calculated value
     */
    public abstract float calcValue(int valX, int valY);

}

package a1d;

/**
 * Framework for table objects.
 * 
 * @author GeoffMcLennan
 * @version 1.0
 */
public class Table {
    
    private float[][] table;
    
    private int start;
    private int size;
    private String type;
    
    /**
     * Constructs a table object.
     * 
     * @param start starting number
     * @param stop ending number
     * @param calc calculator to use in calculations
     */
    public Table(final int start, final int stop, final Calculator calc) {
        this.start = start;
        this.size = (stop - start) + 1;
        type = calc.getDescription();
        
        table = new float[size][size];
        
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                table[i][j] = calc.calcValue(start + i, start + j);
            }
        } 
    }
    
    /**
     * Retrieves the type of the table.
     * 
     * @return table type
     */
    public String getDescription() {
        return type;
    }
    
    /**
     * Retrieves the starting value of the table.
     * 
     * @return starting number
     */
    public int getStart() {
        return start;
    }
    
    /**
     * Retrieves the size of the table.
     * 
     * @return table size
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Retrieves the value at the given position in the table.
     * 
     * @param row row of given position
     * @param col column of given position
     * @return table value
     */
    public float getValueAt(final int row, final int col) {
        return table[row][col];
    }
    
}

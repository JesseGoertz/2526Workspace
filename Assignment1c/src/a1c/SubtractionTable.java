package a1c;

public class SubtractionTable extends Table {
    
    private int[][] table;
    private int start;
    private int stop;
    
    /**
     * Calls parent constructor, and fills in table.
     * 
     * @param start start point
     * @param stop end point
     */
    public SubtractionTable(int start, int stop) {
        super(start, stop, "-");
        this.start = start;
        this.stop = stop;
        createTable();
    }
    
    /**
     * Fills in table and sends it to parent.
     */
    public void createTable() {
        int dimension = stop - start + 1;
        table = new int[dimension][dimension];
        
        for (int i = 0; i <= (stop - start); i++) {
            for (int j = 0; j <= (stop - start); j++) {
                table[i][j] = (start + i) - (start + j);
            }
        } 
        
        super.getTable(table);
    }

}

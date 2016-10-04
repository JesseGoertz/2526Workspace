package a1c;

public abstract class Table {
    
    private int[][] table;
    
    private int start;
    private int stop;
    private String type;
    
    protected Table(final int start, final int stop, final String type) {
        this.start = start;
        this.stop = stop;
        this.type = type;
    }
    
    public abstract void createTable();
    
    /**
     * Prints out table.
     */
    public void display() {
        // Line 1
        System.out.print("    " + type);
        
        for (int i = start; i <= stop; i++) {
            System.out.printf("%6d", i);
        }
        System.out.println();
        
        // Line 2
        System.out.print("     ");
        
        for (int i = start; i <= stop; i++) {
            System.out.print("------");
        }
        System.out.println();
        
        // The rest
        for (int i = 0; i <= (stop - start); i++) {
            System.out.printf("%3d", start + i);
            System.out.print(" |");
            
            for (int j = 0; j <= (stop - start); j++) {
                System.out.printf("%6d", table[i][j]);
            }
            System.out.println();
        }        
    }
    
    /**
     * Gets table from child and sets instance variable.
     * 
     * @param table childs table
     */
    public void getTable(int[][] table) {
        this.table = table;
    }
}

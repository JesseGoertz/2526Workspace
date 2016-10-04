package a1b;

public class AdditionTable extends ArithmeticTable {
    
    private int[][] table;
    
    private int start;
    private int end;
    
    /**
     * Constructor, creates multiplication table.
     * 
     * @param start low parameter
     * @param end high parameter
     */
    public AdditionTable(int start, int end) {
        this.start = start;
        this.end = end;
        
        createTable();
    }
    
    /**
     * Creates the table in an array. 
     */
    public void createTable() {
        int dimension = end - start + 1;
        table = new int[dimension][dimension];
        
        for (int i = 0; i <= (end - start); i++) {
            for (int j = 0; j <= (end - start); j++) {
                table[i][j] = start + i + start + j;
            }
        }        
    }
    
    /**
     * Prints out formatted table.
     */
    public void display() {
        // Line 1
        System.out.print("    +");
        
        for (int i = start; i <= end; i++) {
            System.out.printf("%6d", i);
        }
        System.out.println();
        
        // Line 2
        System.out.print("     ");
        
        for (int i = start; i <= end; i++) {
            System.out.print("------");
        }
        System.out.println();
        
        for (int i = 0; i <= (end - start); i++) {
            System.out.printf("%3d", start + i);
            System.out.print(" |");
            
            for (int j = 0; j <= (end - start); j++) {
                System.out.printf("%6d", table[i][j]);
            }
            System.out.println();
        }
    }

}

package a1e;

/**
 * Displays tables in console.
 * 
 * @author GeoffMcLennan
 * @version 1.0
 */
public class ConsoleDisplayer extends Displayer {
    
    /**
     * Displays contents of table.
     * 
     * @param table table to be displayed.
     */
    public void displayTable(Table table) {
        
        int start = table.getStart();
        int size = table.getSize();
        // Line 1
        System.out.print("    " + table.getDescription());
        
        for (int i = start; i < (start + size); i++) {
            System.out.printf("%6d", i);
        }
        System.out.println();
        
        // Line 2
        System.out.print("     ");
        
        for (int i = 0; i < size; i++) {
            System.out.print("------");
        }
        System.out.println();
        
        // The rest
        for (int i = 0; i < size; i++) {
            System.out.printf("%3d", start + i);
            System.out.print(" |");
            
            for (int j = 0; j <= size - 1; j++) {
                System.out.printf(" %5.2f", table.getValueAt(i, j));
            }
            System.out.println();
        } 
    }
    
}

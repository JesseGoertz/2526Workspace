package assn.p1;

public class ArithmeticTable {

    private enum TableType {
        ADD,
        MULT
    }
    
    private TableType tableType = TableType.MULT;
    
    private int start = 1;
    private int end = 10;
    
    private int[][] table;

    public boolean argumentCheck(String[] args){
        if(args.length!=3){
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, \"*\"");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }        
    
        if(args[0].charAt(0) == '+')
            tableType = TableType.ADD;
        else
            tableType = TableType.MULT;
        
        int sta;
        int sto;
    
        try{
            sta = Integer.parseInt(args[1]);
            sto = Integer.parseInt(args[2]);
        }
        catch(NumberFormatException ex){
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, -, \"*\", /");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }
    
        if((sta < 1 || sta > 100)||((sto < 1 || sto > 100))){
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, -, \"*\", /");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }
    
        if(sta >= sto){
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, -, \"*\", /");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }
          
        start = sta;
        end = sto;
        return true;
    }
    
    public void createTable(int begin, int finish, TableType tableType) {
        int dimension = finish - begin + 1;
        table = new int[dimension][dimension];

        
        for(int i = 0; i <= (finish - begin); i++) {
            for(int j = 0; j <= (finish - begin); j++) {
                if(tableType == TableType.ADD){
                    table[i][j] = start + i + start + j;
                } else {
                    table[i][j] = (start + i) * (start + j);
                }
            }
        }
    }

    public void printTable() {
        // Line 1
        if(tableType == TableType.ADD)
            System.out.print("    +");
        else
            System.out.print("    *");
        
        for(int i = start; i <= end; i++) {
            System.out.printf("%6d", i);
        }
        System.out.println();
        
        // Line 2
        System.out.print("     ");
        
        for(int i = start; i <= end; i++) {
            System.out.print("------");
        }
        System.out.println();
        
        // The rest
        for(int i = 0; i <= (end - start); i++) {
            System.out.printf("%3d", start + i);
            System.out.print(" |");
            
            for(int j = 0; j <= (end - start); j++) {
                System.out.printf("%6d", table[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        ArithmeticTable table = new ArithmeticTable();
        if (table.argumentCheck(args)){
            table.createTable(table.start, table.end, table.tableType);
            table.printTable();
        }
    }
}

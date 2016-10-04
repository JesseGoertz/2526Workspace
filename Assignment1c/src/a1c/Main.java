package a1c;

public class Main {
    
    /**
     * Main entry point for the program.
     * 
     * @param argv command line arguments
     */
    public static void main(final String[] argv) {
        final TableType type;
        final int       start;
        final int       stop;
        
        if (argv.length != 3) {
            usage();
        }

        type  = getType(argv[0]);
        start = getNumber(argv[1]);
        stop  = getNumber(argv[2]);
        
        Table table = getTable(type, start, stop);
        table.display();
    }
    
    /**
     * Parses table type from string.
     * 
     * @param str first command line argument
     * @return type of table
     */
    public static TableType getType(final String str) {
        final TableType type;
        
        if (str.equals("+")) {
            type = TableType.ADD;
        } else if (str.equals("-")) {
            type = TableType.SUB;
        } else if (str.equals("*")) {
            type = TableType.MULT;
        } else {
            usage();
            type = null;
        }
        
        return (type);
    }
    
    /**
     * Parses and validates number input.
     * 
     * @param str input
     * @return validated integer
     */
    public static int getNumber(final String str) {
        int val;
        
        try {
            val = Integer.parseInt(str);
            
            if (val < 1 || val > 100) {
                usage();
            }
        } catch (NumberFormatException ex) {
            usage();
            val = 0;
        }
        
        return (val);
    }
    
    /**
     * Creates table object depending the type.
     * 
     * @param type type of table
     * @param start start point
     * @param stop end point
     * @return corresponding table object
     */
    public static Table getTable(final TableType type,
                               final int start,
                               final int stop) {
        Table table;
        if (type == TableType.ADD) {
            table = new AdditionTable(start, stop);
        } else if (type == TableType.SUB) {
            table = new SubtractionTable(start, stop);
        } else {
            table = new MultiplicationTable(start, stop);
        }
        return table;
    }    
    
    /**
     * User instructions.
     */
    public static void usage() {
        System.err.println("Usage: Main <type> <start> <stop>");
        System.err.println("\tWhere <type> is one of +, \"*\"");
        System.err.println("\tand <start> is between 1 and 100");
        System.err.println("\tand <stop> is between 1 and 100");
        System.err.println("\tand start < stop");
        System.exit(1);
    }            
}


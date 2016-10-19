package a1d;

/**
 * Driver Class.
 * 
 * @author GeoffMcLennan
 * @version 1.0
 */
public class Main {
    
    /**
     * Main entry point for the program.
     * 
     * @param argv command line arguments
     */
    public static void main(final String[] argv) {
        final Calculator calc;
        final int       start;
        final int       stop;
        
        if (argv.length != 3) {
            usage();
        }

        calc  = getCalc(argv[0]);
        start = getNumber(argv[1]);
        stop  = getNumber(argv[2]);
        
        Table table = new Table(start, stop, calc);
        ConsoleDisplayer.displayTable(table);
    }
    
    /**
     * Creates appropriate calculator.
     * 
     * @param str first command line argument
     * @return calculator
     */
    public static Calculator getCalc(final String str) {
        final Calculator calc;
        
        if (str.equals("+")) {
            calc = new AdditionCalculator();
        } else if (str.equals("-")) {
            calc = new SubtractionCalculator();
        } else if (str.equals("*")) {
            calc = new MultiplicationCalculator();
        } else if (str.equals("/")) {
            calc = new DivisionCalculator();
        } else {
            usage();
            calc = null;
        }
        
        return (calc);
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

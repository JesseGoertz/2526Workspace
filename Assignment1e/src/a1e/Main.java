package a1e;

import java.util.HashMap;
import java.util.Map;

/**
 * The driver program.
 */
public class Main {
    
    /**
     * The smallest value to start a table at.
     */
    private static final int MIN_VALUE = 1;

    /**
     * The largest value to stop a table at.
     */
    private static final int MAX_VALUE = 100;

    /**
     * Disallows the creation of any Main objects.
     */
    private Main() {
    }

    /**
     * Point of entry to the program.
     *
     * @param argv
     *            the command line args. argv[0] - the type (+, -, *, /, &, |,
     *            ^, %) argv[1] - the start value (> 1 && < 100) argv[2] - the
     *            end value (> 1 && < 100) argv[3] - the displayer type
     *            (ConsoleDisplayer, SwingDisplayer)
     */
    public static void main(final String[] argv) {
        final int expectedArgs = 4;
        final int typeArg = 0;
        final int startArg = 1;
        final int stopArg = 2;
        final int displayerArg = 3;

        final TableType type;
        final Calculator calc;
        final Table table;
        final Displayer displayer;
        final int start;
        final int stop;

        if (argv.length != expectedArgs) {
            usage("Wrong number of arguments");
        }

        type = getType(argv[typeArg]);
        start = getNumber(argv[startArg]);
        stop = getNumber(argv[stopArg]);
        calc = getCalculator(type);
        table = new Table(start, stop, calc);
        displayer = getDisplayer(argv[displayerArg]);
        displayer.displayTable(table);
    }

    /**
     * Converts the supplied string into the appropriate TableType. If the string
     * is not a valid type then exits the program.
     *
     * @param str
     *            the stringto convert
     * @return the appropriate TableType
     */
    public static TableType getType(final String str) {
        final Map<String, TableType> typeMap;
        final TableType type;

        typeMap = new HashMap<String, TableType>();
        typeMap.put("+", TableType.ADD);
        typeMap.put("-", TableType.SUB);
        typeMap.put("*", TableType.MULT);
        typeMap.put("/", TableType.DIV);
        typeMap.put("&", TableType.AND);
        typeMap.put("|", TableType.OR);
        typeMap.put("^", TableType.XOR);
        typeMap.put("%", TableType.MOD);

        type = typeMap.get(str);

        if (type == null) {
            usage("Unknown calulcator type: " + str);
        }

        return (type);
    }

    /**
     * Converts the supplied string into an int. If the string is not a valid int
     * then exits the program. To be valid the string must be an integer and be >
     * MIN_VALUE and < MAX_VALUE.
     *
     * @param str
     *            the string to convert
     * @return the converted number
     */
    public static int getNumber(final String str) {
        int val;

        try {
            val = Integer.parseInt(str);

            if (val < 1 || val > 100) {
                usage("Value out of range: " + val);
            }
        } catch (NumberFormatException ex) {
            usage("Not a number: " + str);
            val = 0;
        }

        return (val);
    }

    /**
     * Creates the appropriate calculator.
     *
     * @param type
     *            the type of calculator to create
     * @return the newly created calculator
     */
    public static Calculator getCalculator(final TableType type) {
        // COMP 2526 NOTE: much smaller than an if/else or
        // switch :-)
        final Map<TableType, Calculator> calcMap;
        final Calculator calc;

        calcMap = new HashMap<TableType, Calculator>();
        calcMap.put(TableType.ADD, new AdditionCalculator());
        calcMap.put(TableType.SUB, new SubtractionCalculator());
        calcMap.put(TableType.MULT, new MultiplicationCalculator());
        calcMap.put(TableType.DIV, new DivisionCalculator());
        calcMap.put(TableType.AND, new ANDCalculator());
        calcMap.put(TableType.OR, new ORCalculator());
        calcMap.put(TableType.XOR, new XORCalculator());
        calcMap.put(TableType.MOD, new MODCalculator());
        calc = calcMap.get(type);

        return (calc);
    }

    /**
     * Creates the appropriate displayer.
     *
     * @param name
     *            the class name of the displayer to create
     * @return the newly created displayer
     */
    public static Displayer getDisplayer(final String name) {
        // COMP 2526 NOTE: This is part of "reflection"
        // What we are doing is converting the string
        // into an instance of a class at runtime!
        String className = "a1e." + name;
        try {
            return ((Displayer) Class.forName(className).newInstance());
        } catch (final ClassNotFoundException ex) {
            usage("Cannot find class: " + name);
        } catch (final InstantiationException ex) {
            System.err.println("Error creating: " + name);
            System.exit(1);
        } catch (final IllegalAccessException ex) {
            System.err.println(name + " must have a public, no-arg, constructor");
            System.exit(1);
        }

        return (null);
    }

    /**
     * Displays the usage message and exit the program.
     */
    public static void usage(final String msg) {
        System.err.println(msg);
        System.err.println("Usage: Main <type> <start> <stop> <displayer>");
        System.err.println("\tWhere <type> is one of: +, \"*\", /, \"%\", \"&\", \"|\", \"^\"");
        System.err.println("\tand <start> is between 1 and 100");
        System.err.println("\tand <stop> is between 1 and 100");
        System.err.println("\tand <displayer> is one of: ConsoleDisplayer, SwingDisplayer");
        System.exit(1);
    }
}

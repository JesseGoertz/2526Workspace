package ca.bcit.comp2526.a2b;

import java.awt.Color;

public class Water {
    
    public static final Color COLOR = new Color(0, 81, 211);
    private final Cell container;
    
    /**
     * Creates a water object and sets the background colour of its container
     * cell.
     * @param location containing cell.
     */
    public Water(Cell location) {
        container = location;
        container.setBackground(COLOR);
    }

}

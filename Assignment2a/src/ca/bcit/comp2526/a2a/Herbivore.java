package ca.bcit.comp2526.a2a;

import java.awt.Color;

public class Herbivore {
    
    private Cell container;
    private static final Color color = new Color(252, 222, 30);
    
    public Herbivore(Cell location) {
        container = location;
    }
    
    public void init() {
        container.setBackground(color);
    }

}

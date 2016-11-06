package ca.bcit.comp2526.a2a;

import java.awt.Color;

public class Plant {
    
    private Cell container;
    private static final Color color = new Color(44, 158, 18);
    
    public Plant(Cell location) {
        container = location;
    }
    
    public void init() {
        container.setBackground(color);
    }
    
}

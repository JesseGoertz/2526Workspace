package ca.bcit.comp2526.a2a;

import java.awt.Color;

public class Herbivore extends Organism {
    
    private Cell container;
    private static final Color color = new Color(252, 222, 30);
    
    public Herbivore(Cell location) {
        container = location;
    }
    
    public void init() {
        container.setBackground(color);
    }
    
    public void move() {
        // Plants don't move
    }
    
    public boolean canEat(Organism org) {
        if (org instanceof Plant) {
            return true;
        } else {
            return false;
        }
    }

}

package ca.bcit.comp2526.a2b;

public class Herbivore extends Animal {
    
    private static final int[][] COLOR_ARRAY = {
            {255, 250, 2}, 
            {244, 241, 29},
            {252, 250, 108}
    };
    private static final int MAX_HUNGER = 6;
    private static final int STEPS = 1;
    public static final int MAX_BABES = 2;
    
    /**
     * Passes the cell and Herbivore-specific constants to parent.
     * @param location cell.
     */
    public Herbivore(Cell location) {
        super(location, STEPS, MAX_HUNGER, MAX_BABES, COLOR_ARRAY);
    }
    
    public boolean canEat(Organism org) {
        return org instanceof Plant;
    }
    
    public boolean canReproduce(int food, int family, int open) {
        return (food >= 2) && (family >= 1) && (open >= 2);
    }
    
    public boolean isFamily(Organism org) {
        return org instanceof Herbivore;
    }
    
    public boolean canWalk(Organism org) {
        return org instanceof Plant;
    }

}

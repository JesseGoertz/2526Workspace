package ca.bcit.comp2526.a2b;

public class Carnivore extends Animal implements HatesWater {
    
    private static final int[][] COLOR_ARRAY = {
            {255, 30, 22},
            {255, 57, 22},
            {255, 22, 69}
    };
    private static final int MAX_HUNGER = 3;
    private static final int STEPS = 2;
    private static final int MAX_BABES = 1;
    
    /**
     * Passes the cell and Carnivore specific variables to parent class.
     * @param location target cell.
     */
    public Carnivore(Cell location) {
        super(location, STEPS, MAX_HUNGER, MAX_BABES, COLOR_ARRAY); 
    }

    public boolean canEat(Organism org) {
        return org instanceof Herbivore 
                || org instanceof Omnivore;
    }
    
    public boolean canReproduce(int family, int food, int open) {
        return false;
    }
    
    public boolean isFamily(Organism org) {
        return org instanceof Carnivore;
    }
    
    public boolean canWalk(Organism org) {
        return org instanceof Plant;
    }
}

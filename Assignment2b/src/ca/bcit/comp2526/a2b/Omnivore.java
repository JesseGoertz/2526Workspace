package ca.bcit.comp2526.a2b;

public class Omnivore extends Animal {
    
    private static final int[][] COLOR_ARRAY = {
            {242, 0, 255},
            {246, 86, 255},
            {248, 130, 255}            
    };
    private static final int MAX_HUNGER = 6;
    private static final int STEPS = 1;
    private static final int MAX_BABES = 1;
    
    public Omnivore(Cell location) {
        super(location, STEPS, MAX_HUNGER, MAX_BABES, COLOR_ARRAY);
    }
    
    /**
     * Checks to see if this Omnivore can eat the target organism.
     * @return true if it can eat the target.
     */
    public boolean canEat(Organism org) {
        return org instanceof Herbivore 
                || org instanceof Carnivore
                || org instanceof Plant;
    }
    
    public boolean canReproduce(int family, int food, int open) {
        return false;
    }
    
    public boolean isFamily(Organism org) {
        return org instanceof Omnivore;
    }
    
    public boolean canWalk(Organism org) {
        return org instanceof Plant;
    }

}

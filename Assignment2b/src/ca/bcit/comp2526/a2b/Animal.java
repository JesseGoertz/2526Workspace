package ca.bcit.comp2526.a2b;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public abstract class Animal implements Organism {
    
    protected Cell container;
    private boolean hasMoved = false;
    private final int[] rgb; 
    private final int moveLength;
    private final int maxHunger;
    private final int maxBabes;
    private int hunger;
    
    /**
     * Receives all necessary parameters from child and randomly selects an appropriate colour for 
     * the cell.
     * @param location - container cell.
     * @param moveLength - number of cells the Animal can move.
     * @param maxHunger - maximum turns the Animal can go without eating.
     * @param maxBabes - number of offspring spawned when this Animal reproduces.
     * @param colors - array of rgb values for colours for this Animal.
     */
    public Animal(Cell location, int moveLength, int maxHunger, int maxBabes, int[][] colors) {
        container = location;
        this.moveLength = moveLength;
        hunger = maxHunger;
        this.maxHunger = maxHunger;
        this.maxBabes = maxBabes;
        int rand = (int) (Math.random() * 3);
        this.rgb = colors[rand];
    }
    
    /**
     * Initializes the cell with the appropriate colour for this Animal.
     */
    public void init() {
        float ratio = 1 - (((float) maxHunger - hunger) / maxHunger);
        Color shade = new Color((int)(rgb[0] * ratio), 
                (int) (rgb[1] * ratio), (int) (rgb[2] * ratio));
        container.setBackground(shade);
    }
    
    /**
     * Checks to see if the animal will die, then scans all neighbouring cells to check for food 
     * and empty cells. Tells the animal to reproduce if possible, then moves to a cell (preferably 
     * with food).
     * @param world - the world containing the Animal.
     * @param moveRad - maximum number of cells the Animal can move in one turn.
     */
    public void move(World world, int moveRad) {
        if (!hasMoved) {
            
            int row = container.getRow();
            int col = container.getCol();
            ArrayList<Point> food = new ArrayList<Point>(25);
            ArrayList<Point> family = new ArrayList<Point>(25);
            ArrayList<Point> emptyCells = new ArrayList<Point>(25);
            
            if (!container.isWater()) {
                if (checkDeath()) {
                    return;
                }
            }
            
            for (int i = -moveRad; i <= moveRad; i++) {
                for (int j = -moveRad; j <= moveRad; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int checkRow = row + i;
                    int checkCol = col + j;
                    if (checkRow < 0 || checkRow >= world.getRowCount()
                            || checkCol < 0 || checkCol >= world.getColumnCount()) {
                        continue;
                    }
                    Cell targCell = world.getCellAt(checkRow, checkCol);
                    Organism target = targCell.getInhabitant();
                    if (this.canEat(target)) {
                        if (!(this instanceof HatesWater && targCell.isWater())) {
                            food.add(new Point(checkRow, checkCol));
                        }
                    } else if (target == null || this.canWalk(target)) {
                        if (!(this instanceof HatesWater && targCell.isWater())) {
                            emptyCells.add(new Point(checkRow, checkCol));
                        }
                    } else if (this.isFamily(target)) {
                        family.add(new Point(checkRow, checkCol));
                    }
                }
            }
            
            // Checks amount of food
            int victims = food.size();
                        
            //Check number of open spots
            int empties = emptyCells.size();
                        
            //Count nearby family
            int siblings = family.size();
            
            //Perform checks
            if (canReproduce(victims, siblings, empties)) {
                int random = 1;
                int numBabes = 0;
                do {
                    int rand = (int) (Math.random() * empties--);
                    Point dest = emptyCells.remove(rand);
                    Cell birthCell = world.getCellAt((int) dest.getX(), (int) dest.getY());
                    Organism babe = makeBabe(birthCell);
                    birthCell.setInhabitant(babe);
                    babe.init();
                    numBabes++;
                    random = (int) (Math.random() * 2);
                } while (random == 1 && numBabes < maxBabes);
            }
            if (victims > 0) {
                int rand = (int) (Math.random() * victims);
                Point dest = food.get(rand);
                Cell newCell = world.getCellAt((int) dest.getX(), (int) dest.getY());
                changeCells(newCell, true);
                return;
            }
            if (empties > 0) {
                int rand = (int) (Math.random() * empties);
                Point dest = emptyCells.get(rand);
                Cell newCell = world.getCellAt((int) dest.getX(), (int) dest.getY());
                changeCells(newCell, false);
            } 
        }
    }
    
    /**
     * Moves the Animal from one cell to another, feeding it if applicable.
     * @param dest - destination cell.
     * @param feed - flag that says if the Animal should be fed.
     */
    private void changeCells(Cell dest, boolean feed) {
        Cell oldCell = container;
        dest.setInhabitant(this);
        container = dest;
        oldCell.setInhabitant(null);
        oldCell.defaultBackground();
        init();
        if (feed) {
            feed();
        }
        hasMoved = true;
    }
    
    /**
     * Creates the proper Animal object to be placed in a new cell.
     * @param location - the cell to contain the baby.
     * @return the baby.
     */
    private Organism makeBabe(Cell location) {
        if (this instanceof Herbivore) {
            return new Herbivore(location);
        } else if (this instanceof Omnivore) {
            return new Omnivore(location);
        } else if (this instanceof Carnivore) {
            return new Carnivore(location);
        } else {
            return null;
        }
    }
    
    /**
     * Resets hunger to its max value.
     */
    private void feed() {
        hunger = this.maxHunger;
    }
    
    /**
     * Decrements hunger, then if the Animal should die, resets the colour of the
     * containing cell, and sets its inhabitant to a null pointer.
     * @return true if Animal has died.
     */
    public boolean checkDeath() {
        if (--hunger <= 0) {
            container.defaultBackground();
            container.setInhabitant(null);
            return true;
        }
        return false;
    }
    
    /**
     * Automatically generated getter.
     * @return moveLength
     */
    public int getMoveLength() {
        return moveLength;
    }
    
    /**
     * Resets the hasMoved flag.
     */
    public void resetMove() {
        hasMoved = false;
    }
    
    /**
     * Tests the target organism to see if it is edible by this Animal.
     * @param org organism to be eaten.
     * @return true if animal is edible.
     */
    public abstract boolean canEat(Organism org);
    
    /**
     * Tests to see if the Animal is able to reproduce given its surroundings.
     * @param food number of food cells in range.
     * @param family number of same-species Animals nearby.
     * @param open number of empty cells nearby.
     * @return true if animal should reproduce.
     */
    public abstract boolean canReproduce(int food, int family, int open);
    
    /**
     * Checks to see if target Organism is the same species.
     * @param org Organism to be tested.
     * @return true if they are the same species.
     */
    public abstract boolean isFamily(Organism org);
    
    /**
     * Checks to see if this Animal can walk on the target Organism.
     * @param org Organism to be tested.
     * @return true if this Animal can walk on the Organism.
     */
    public abstract boolean canWalk(Organism org);

}

package ca.bcit.comp2526.a2b;

import java.awt.Color;
import java.awt.Point;
import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Animal implements Organism {
    
    protected Cell container;
    private boolean hasMoved = false;
    private final int[] rgb; 
    private final int moveLength;
    private final int MAX_HUNGER;
    private final int MAX_BABES;
    private int hunger;
    
    public Animal(Cell location, int moveLength, int maxHunger, int maxBabes, int[][] colors) {
        container = location;
        this.moveLength = moveLength;
        hunger = maxHunger;
        MAX_HUNGER = maxHunger;
        MAX_BABES = maxBabes;
        int rand = (int) (Math.random() * 3);
        this.rgb = colors[rand];
    }
    
    public void init() {
        float ratio = 1 - (((float) MAX_HUNGER - hunger) / MAX_HUNGER);
        Color shade = new Color((int)(rgb[0] * ratio), 
                (int) (rgb[1] * ratio), (int) (rgb[2] * ratio));
        container.setBackground(shade);
    }
    
    public void move(World world, int moveRad) {
        if (!hasMoved) {
            
            int row = container.getRow();
            int col = container.getCol();
            ArrayList<Point> food = new ArrayList<Point>(25);
            ArrayList<Point> family = new ArrayList<Point>(25);
            ArrayList<Point> emptyCells = new ArrayList<Point>(25);
            
            --hunger;
            
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
                    Organism target = world.getCellAt(checkRow, checkCol).getInhabitant();
                    if (this.canEat(target)) {
                        food.add(new Point(checkRow, checkCol));
                    } else if (target == null || this.canWalk(target)) {
                        emptyCells.add(new Point(checkRow, checkCol));
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
                } while (random == 1 && numBabes < MAX_BABES);
            }
            if (victims > 0) {
                int rand = (int) (Math.random() * victims);
                Point dest = food.get(rand);
                Cell newCell = world.getCellAt((int) dest.getX(), (int) dest.getY());
                changeCells(newCell, true);
                checkDeath();
                return;
            }
            if (empties > 0) {
                int rand = (int) (Math.random() * empties);
                Point dest = emptyCells.get(rand);
                Cell newCell = world.getCellAt((int) dest.getX(), (int) dest.getY());
                changeCells(newCell, false);
                checkDeath();
            } 
        }
    }
    
    private void changeCells(Cell dest, boolean feed) {
        Cell oldCell = container;
        dest.setInhabitant(this);
        container = dest;
        oldCell.setInhabitant(null);
        oldCell.setBackground(Color.WHITE);
        init();
        if (feed) {
            feed();
        }
        hasMoved = true;
    }
    
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
    
    private void feed() {
        hunger = this.MAX_HUNGER;
    }
    
    public void checkDeath() {
        if (hunger <= 0) {
            container.setBackground(Color.WHITE);
            container.setInhabitant(null);
        }
    }
    
    public int getMoveLength() {
        return moveLength;
    }
    
    public void resetMove() {
        hasMoved = false;
    }
    
    public abstract boolean canEat(Organism org);
    
    public abstract boolean canReproduce(int food, int family, int open);
    
    public abstract boolean isFamily(Organism org);
    
    public abstract boolean canWalk(Organism org);

}

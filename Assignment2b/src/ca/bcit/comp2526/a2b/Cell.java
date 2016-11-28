package ca.bcit.comp2526.a2b;

import java.awt.Color;
import javax.swing.JPanel;

public class Cell extends JPanel {
    
    /**
     * Automatically generated serial ID.
     */
    private static final long serialVersionUID = 1L;
    private Organism inhabitant;
    private int row;
    private int col;
    public Water water = null;
    
    /**
     * Sets all instance variables for this cell.
     * @param world containing world.
     * @param row this cell's row.
     * @param column this cell's column.
     */
    public Cell(World world, int row, int column) {
        this.row = row;
        this.col = column;
    }
    
    /**
     * Creates a random number between 0 and 99, then creates an organism based
     * on the relative chances of generating each organism.
     */
    public void init() {
        int rand =  (int) (Math.random() * 100);
        if (rand <= 30) {
            Plant plant = new Plant(this);
            inhabitant = plant;
            plant.init();
        } else if (rand <= 55) {
            Herbivore herb = new Herbivore(this);
            inhabitant = herb;
            herb.init();
        } else if (rand <= 65) {
            Carnivore carn = new Carnivore(this);
            inhabitant = carn;
            carn.init();
        } else if (rand <= 75) {
            Omnivore omn = new Omnivore(this);
            inhabitant = omn;
            omn.init();
        } else if (rand <= 78) {
            water = new Water(this);   
        }
    }
    
    /**
     * Automatically generated getter.
     * @return inhabitant
     */
    public Organism getInhabitant() {
        return inhabitant;
    }
    
    /**
     * Automatically generated setter.
     * @param org Organism to be set.
     */
    public void setInhabitant(Organism org) {
        inhabitant = org;
    }
    
    /**
     * Checks to see if there is water in this cell.
     * @return true if there is water.
     */
    public boolean isWater() {
        return water != null;
    }
    
    /**
     * Resets the colour of this cell to blue if it has water, or white otherwise.
     */
    public void defaultBackground() {
        if (water != null) {
            setBackground(Water.COLOR);
        } else {
            setBackground(Color.WHITE);
        }
    }
    
    /**
     * Automatically generate getter.
     * @return row
     */
    public int getRow() {
        return row;
    }
    
    /**
     * Automatically generate getter.
     * @return col
     */
    public int getCol() {
        return col;
    }
    
    /**
     * Checks to see if this cell is empty.
     * @return true if it is empty.
     */
    public boolean isEmpty() {
        return (inhabitant == null);
    }

}


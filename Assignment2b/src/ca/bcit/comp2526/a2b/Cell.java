package ca.bcit.comp2526.a2b;

import java.awt.Container;
import javax.swing.JPanel;

public class Cell extends JPanel {
    
    private World world;
    private Organism inhabitant;
    private int row;
    private int col;
    
    public Cell(World world, int row, int column) {
        this.world = world;
        this.row = row;
        this.col = column;
    }
    
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
        }
    }
    
    public Organism getInhabitant() {
        return inhabitant;
    }
    
    public void setInhabitant(Organism org) {
        inhabitant = org;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public boolean isEmpty() {
        return (inhabitant == null);
    }

}


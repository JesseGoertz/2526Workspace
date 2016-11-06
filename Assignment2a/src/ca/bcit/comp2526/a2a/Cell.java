package ca.bcit.comp2526.a2a;

import java.awt.Container;
import javax.swing.JPanel;

public class Cell extends JPanel {
    
    private World world;
    private int row;
    private int col;
    
    public Cell(World world, int row, int column) {
        this.world = world;
        this.row = row;
        this.col = column;
    }
    
    public void init() {
        int rand =  (int) (Math.random() * 10);
        if (rand <= 2) {
            Plant plant = new Plant(this);
            plant.init();
        } else if (rand <= 3) {
            Herbivore herb = new Herbivore(this);
            herb.init();
        }
    }

}

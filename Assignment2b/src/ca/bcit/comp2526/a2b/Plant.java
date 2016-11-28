package ca.bcit.comp2526.a2b;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Plant implements Organism {
    
    private Cell container;
    private static final int[][] COLOR_ARRAY = {
            {67, 242, 48},
            {48, 242, 103},
            {122, 248, 48}
    };
    private final int[] rgb;
    private static final int MAX_LIFE = 10;
    private boolean hasMoved = false;
    private int life;
    
    /**
     * Creates a plant in the given cell with a randomly selected shade of green.
     * @param location - container cell.
     */
    public Plant(Cell location) {
        container = location;
        life = MAX_LIFE;
        int rand = (int) (Math.random() * 3);
        this.rgb = COLOR_ARRAY[rand];
    }
    
    /**
     * Sets the background colour to the proper shade.
     */
    public void init() {
        float ratio = 1 - (((float) MAX_LIFE - life) / MAX_LIFE);
        container.setBackground(new Color((int) (rgb[0] * ratio), 
                (int) (rgb[1] * ratio), (int) (rgb[2] * ratio)));
    }
    
    /**
     * Checks all surrounding cells to see if there is the proper number of plants and empty
     * cells to reproduce, then creates new plants if there is.
     * @param world containing world.
     */
    public void reproduce(World world) {
        if (!hasMoved) {
            if (--life <= 0) {
                container.setBackground(Color.WHITE);
                container.setInhabitant(null);
                return;
            }
            int row = container.getRow();
            int col = container.getCol();
            ArrayList<Point> empty = new ArrayList<Point>(8);
            ArrayList<Point> plants = new ArrayList<Point>(8);
            
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (i == row && j == col) {
                        continue;
                    }
                    if (i < 0 || i >= world.getRowCount()
                            || j < 0 || j >= world.getColumnCount()) {
                        continue;
                    }
                    Cell targCell = world.getCellAt(i, j);
                    Organism target = targCell.getInhabitant();
                    if (target == null && !targCell.isWater()) {
                        empty.add(new Point(i, j));
                    } else if (target instanceof Plant) {
                        plants.add(new Point(i, j));
                    }
                }
            }
            
            int empties = empty.size();
            if (empties >= 2 && plants.size() >= 3) {
                int random = 1;
                int numSpawn = 0;
                do {
                    int rand = (int) (Math.random() * empties--);
                    Point dest = empty.remove(rand);
                    Cell birthCell = world.getCellAt((int) dest.getX(), (int) dest.getY());
                    Plant plant = new Plant(birthCell);
                    birthCell.setInhabitant(plant);
                    plant.init();
                    plant.setMove(true);
                    numSpawn++;
                    random = (int) (Math.random() * 2);
                } while (random == 1 && numSpawn <= 1);
            }
            hasMoved = true;
            init();
        }
    }
    
    /**
     * Resets the hasMoved flag.
     */
    public void resetMove() {
        hasMoved = false;
    }
    
    /**
     * Sets the hasMoved flag to the given value.
     * @param val given value.
     */
    public void setMove(boolean val) {
        hasMoved = val;
    }
}

package ca.bcit.comp2526.a2b;

import java.awt.Color;

import javax.swing.BorderFactory;

public class World {
    
    private final int rows;
    private final int cols;
    private Cell[][] env;
    
    /**
     * Creates the world and its array of cells.
     * @param rows number of rows.
     * @param cols number of columns.
     */
    public World(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        env = new Cell[rows][cols];
    }
    
    /**
     * Cycles through the empty array of Cells, and initialized a Cell in each index.
     */
    public void init() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                env[i][j] = new Cell(this, i, j);
                env[i][j].init();
                env[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        }
    }

    /**
     * Automatically generated getter.
     * @return rows
     */
    public int getRowCount() {
        return rows;
    }

    /**
     * Automatically generated getter.
     * @return cols
     */
    public int getColumnCount() {
        return cols;
    }
    
    /**
     * Returns the cell at the given indices in the array.
     * @param row array row.
     * @param col array column.
     * @return the cell at that position.
     */
    public Cell getCellAt(int row, int col) {
        return env[row][col];
    }
    
    /**
     * Cycles through the environment, and acts on each inhabitant.
     */
    public void takeTurn() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = env[i][j];
                Organism inhabitant = cell.getInhabitant();
                if (inhabitant instanceof Animal) {
                    ((Animal) inhabitant).move(this, ((Animal) inhabitant).getMoveLength());
                } else if (inhabitant instanceof Plant) {
                    ((Plant) inhabitant).reproduce(this);
                }
                
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = env[i][j];
                Organism inhabitant = cell.getInhabitant();
                if (inhabitant != null) {
                    inhabitant.resetMove();
                }
                
            }
        }
    }
    
}


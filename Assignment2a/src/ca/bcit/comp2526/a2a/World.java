package ca.bcit.comp2526.a2a;

import java.awt.Color;

import javax.swing.BorderFactory;

public class World {
    
    final private int rows;
    final private int cols;
    private Cell[][] env;
    
    public World(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        env = new Cell[rows][cols];
    }
    
    public void init() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                env[i][j] = new Cell(this, i, j);
                env[i][j].init();
                env[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        }
    }

    public int getRowCount() {
        return rows;
    }

    public int getColumnCount() {
        return cols;
    }
    
    public Cell getCellAt(int row, int col) {
        return env[row][col];
    }
    
    public void takeTurn() {
        
    }
    
}

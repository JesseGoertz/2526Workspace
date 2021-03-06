package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.Point;

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
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = env[i][j];
                Organism inhabitant = cell.getInhabitant();
                inhabitant.move(new World(10, 10), new Point(1, 1));
            }
        }
    }
    
    public Point getMove(int xPos, int yPos) {
        int xdiff;
        int ydiff;
        if (xPos == 0) {
            xdiff = (int) (Math.random() * 2);
        } else if (xPos == cols - 1) {
            xdiff = ((int) (Math.random() * 2)) - 1;
        } else {
            xdiff = ((int) (Math.random() * 3)) - 2;
        }
        
        if (yPos == 0) {
            ydiff = (int) (Math.random() * 2);
        } else if (yPos == rows - 1) {
            ydiff = ((int) (Math.random() * 2)) - 1;
        } else {
            ydiff = ((int) (Math.random() * 3)) - 2;
        }
        
        return new Point(xdiff, ydiff);
    }
    
    public void moveCell(Organism org, Cell oldCell, Cell newCell) {
        newCell.setInhabitant(org);
        oldCell.setInhabitant(null);
        org.init();
    }
    
}

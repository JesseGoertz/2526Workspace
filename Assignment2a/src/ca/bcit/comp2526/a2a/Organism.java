package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.Point;

public abstract class Organism {
    
    private Cell container;
    
    public abstract void init();
    
    public void move(World world, Point point) {
        int row = container.getRow() + (int) point.getY();
        int col = container.getCol() + (int) point.getX();
        
        Cell newCell = world.getCellAt(row, col);
        if (newCell.isEmpty()) {
            Cell oldCell = world.getCellAt(container.getCol(), container.getRow());
            this.container = newCell;
            world.moveCell(this, oldCell, newCell);
        } else if (this.canEat(newCell.getInhabitant())) {
            // Move cells
            Cell oldCell = world.getCellAt(container.getCol(), container.getRow());
            this.container = newCell;
            world.moveCell(this, oldCell, newCell);
        } else {
            this.move(world, point);
        }
        
    }
    
    public abstract boolean canEat(Organism org);
}

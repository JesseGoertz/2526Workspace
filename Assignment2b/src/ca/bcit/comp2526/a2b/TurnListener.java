package ca.bcit.comp2526.a2b;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class TurnListener implements MouseListener {
    
    private GameFrame frame;
    
    public TurnListener(GameFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(MouseEvent click) {
        frame.takeTurn();
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}
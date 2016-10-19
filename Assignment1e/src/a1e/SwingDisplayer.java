package a1e;

import javax.swing.JFrame;

public class SwingDisplayer extends Displayer {
    
    /**
     * Creates a frame and gives it the table to display.
     * 
     * @param table table to be displayed.
     */
    public void displayTable(final Table table) {
        final DisplayerFrame frame;

        frame = new DisplayerFrame();
        frame.init(table);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
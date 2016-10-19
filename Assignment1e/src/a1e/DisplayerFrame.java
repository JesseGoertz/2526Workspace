package a1e;

import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DisplayerFrame extends JFrame {
    
    /**
     * Automatically generated ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a button for each value in the table plus formatting.
     * 
     * @param table table to be displayed.
     */
    public void init(final Table table) {
        //code to set the frame title
        String type = table.getDescription();
        int start = table.getStart();
        int size = table.getSize();
        int end = start + size - 1;
        this.setTitle(type + "(" + start + "," + end + ")");

        //code to create a gridlayout with buttons that will display the
        //table results
        
        
        setLayout(new GridLayout(0, size + 1));
        
        // Line 1
        add(new JButton(type));
        
        for (int i = start; i < (start + size); i++) {
            add(new JButton("" + i));
        }
        
        // The rest
        for (int i = 0; i < size; i++) {
            add(new JButton("" + (start + i)));
            
            for (int j = 0; j < size; j++) {
                add(new JButton("" + table.getValueAt(i, j)));
            }
        }
    }

}

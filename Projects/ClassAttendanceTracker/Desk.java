/**
 * @author Christian Piper
 * @since 9/8/21
 */

// Import the main package
package Projects.ClassAttendanceTracker;

// Import libraries
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.awt.*;

public class Desk extends JPanel {

    // Holds the preferred dimension
    private Dimension preferredSize;
    private int desiredX;
    private int desiredY;

    // Main constructor
    Desk(int x, int y, int width, int height) {
        preferredSize = new Dimension(width, height);
        desiredX = x;
        desiredY = y;
    }

    // Called when frame is drawn
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.RED);
        //g.setColor(Color.RED);
        //g.drawRect(0, 0, (int)Math.round(preferredSize.getWidth()), (int)Math.round(preferredSize.getHeight()));
    }

    // Set the preferred size
    public void setPreferredSize(Dimension newSize) {
        preferredSize = newSize;
    }

    // Get the preferred size
    @Override
    public Dimension getPreferredSize() {
        return preferredSize;
    }

    // Get the X value
    public int getDesiredX() {
        return desiredX;
    }

    // Get the Y value
    public int getDesiredY() {
        return desiredY;
    }
}

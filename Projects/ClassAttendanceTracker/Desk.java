// Christian Piper
// 9/8/21

// Import the main package
package Projects.ClassAttendanceTracker;

// Import the visual library
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

// Import the shape library
import java.awt.*;

public class Desk extends JPanel {

    // Holds the preferred dimension
    private Dimension preferredDimension;

    // Main constructor
    Desk(int x, int y) {
        preferredDimension = new Dimension(x, y);
    }

    // Called when frame is drawn
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(100, 10, 300, 400);
    }

    // Set the preferred size
    public void setPreferredSize(Dimension newSize) {
        preferredDimension = newSize;
    }

    // Get the preferred size
    @Override
    public Dimension getPreferredSize() {
        return preferredDimension;
    }
}

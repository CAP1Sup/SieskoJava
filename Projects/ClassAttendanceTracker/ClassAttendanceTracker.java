// Christian Piper
// 9/8/21

// Import the main package
package Projects.ClassAttendanceTracker;

// Import the visual library
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;

// Import the shape library
import java.awt.*;

// Import event library
import java.awt.event.*;
import java.util.ArrayList;

// Import Desk class
import Projects.ClassAttendanceTracker.Desk;

public class ClassAttendanceTracker extends MouseInputAdapter {

    // Create a variables
    // Main window, spacing
    private static JFrame frame;
    private static Container window;
    private static JPanel seatingChartArea;
    private static SpringLayout layout;

    // Buttons
    private static JButton newDeskButton;

    // Desk array (for storing available desks)
    private static ArrayList<Desk> deskArray;

    // Sizes
    private static Dimension screenSize;

    public static void main(String[] args) {

        // Get the size of the computer window
        Rectangle screenRect = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        screenSize = new Dimension((int)screenRect.getWidth(), (int)screenRect.getHeight());
        //screenSize.setSize(1000, 500);

        // Initialize the desk array
        deskArray = new ArrayList<Desk>();

        // Create the instance
        frame = new JFrame();

        // Get the container
        window = frame.getContentPane();

        // Set the layout
        layout = new SpringLayout();
        window.setLayout(layout);

        // Add desks to the array
        deskArray.add(new Desk(0, 0, 300, 400));
        deskArray.add(new Desk(400, 400, 400, 300));

        // Create seating chart instance
        seatingChartArea = new JPanel();

        // Create button instances
        newDeskButton = new JButton();

        // Set the background color of the buttons
        newDeskButton.setBackground(Color.RED);

        // Set the text of the buttons
        newDeskButton.setText("New Desk");

        // Add the seating chart area to the window
        window.add(seatingChartArea);

        // Add the buttons to the window
        window.add(newDeskButton);

        // Add all of the desks to the window
        for (int index = 0; index < deskArray.size(); index++) {

            // Get the desk from the array
            Desk currentDesk = deskArray.get(index);

            // Add it to the seating chart area
            seatingChartArea.add(currentDesk);

            // Set its layout constraints
            layout.putConstraint(SpringLayout.WEST, currentDesk, currentDesk.getDesiredX(), SpringLayout.WEST, seatingChartArea);
            layout.putConstraint(SpringLayout.NORTH, currentDesk, currentDesk.getDesiredY(), SpringLayout.NORTH, seatingChartArea);
        }

        // Set up the seating chart area
        seatingChartArea.setBackground(Color.BLUE);
        seatingChartArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));

        // Set the program to exit when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background color
        frame.setBackground(Color.WHITE);

        // Set the size (same as the screen size, so fullscreen)
        frame.setPreferredSize(screenSize);

        // Allow the window to be resized
        frame.setResizable(true);

        // Set the title
        frame.setTitle("Class Attendance Tracker");

        // Layout setup    (int)Math.round(screenSize.getHeight() * (1.0/4.0))
        layout.putConstraint(SpringLayout.NORTH, seatingChartArea, 0, SpringLayout.NORTH, window);
        layout.putConstraint(SpringLayout.SOUTH, seatingChartArea, 0, SpringLayout.SOUTH, window);
        layout.putConstraint(SpringLayout.WEST, seatingChartArea, 0, SpringLayout.WEST, window);
        layout.putConstraint(SpringLayout.EAST, seatingChartArea, 0, SpringLayout.EAST, window);

        // Pack the frame
        frame.pack();

        // Update the visual reference
        SwingUtilities.updateComponentTreeUI(frame);

        // Make the window visible
        frame.setVisible(true);
    }
}

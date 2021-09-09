// Christian Piper
// 9/8/21

// Import the main package
package Projects.ClassAttendanceTracker;

// Import the visual library
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

// Import the shape library
import java.awt.*;

// Import event library
import java.awt.event.*;
import java.util.ArrayList;

// Import Desk class
import Projects.ClassAttendanceTracker.Desk;

public class ClassAttendanceTracker extends MouseInputAdapter {

    // Create a variable for storing the window
    private static JFrame window;
    private static JPanel seatingChartArea;
    private static JButton newDeskButton;
    private static ArrayList<Desk> deskArray;

    public static void main(String[] args) {

        // Initialize the desk array
        deskArray = new ArrayList<Desk>();

        // Add desks to the array
        deskArray.add(new Desk(300, 400));
        deskArray.add(new Desk(400, 300));

        // Create the instance
        window = new JFrame();

        // Create seating chart instance
        seatingChartArea = new JPanel();

        // Create button instances
        newDeskButton = new JButton();

        // Set up the seating chart area
        seatingChartArea.setBackground(Color.BLUE);

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
            window.add(deskArray.get(index));
        }

        // Set the program to exit when the window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background color
        window.setBackground(Color.WHITE);

        // Set the size
        window.setSize(new Dimension(300, 120));

        // Allow the window to be resized
        window.setResizable(true);

        // Set the title
        window.setTitle("Class Attendance Tracker");

        // Set the layout
        window.setLayout(new FlowLayout());
        window.pack();

        // Make the window visible
        window.setVisible(true);
    }
}

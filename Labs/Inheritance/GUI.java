package Inheritance;

// Import libraries
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener {

    private static JFrame frame;
    private static Container window;

    // Layouts
    private static SpringLayout loginLayout;
    private static SpringLayout dataExplorerLayout;

    // Text fields
    private static JTextField usernameText;
    private static JPasswordField passwordText;

    // Labels
    private static JLabel usernameInputLabel;
    private static JLabel passwordInputLabel;
    private static JLabel studentDataLabel;
    private static JLabel teacherDataLabel;

    // Buttons
    private static JButton loginButton;
    private static JButton exitButton;
    private static JButton addTeacherButton;
    private static JButton addStudentButton;
    private static JButton submitButtonTeacher;
    private static JButton submitButtonStudent;

    // Desk array (for storing available desks)
    private static ArrayList<Login> logins;

    // Sizes
    private static Dimension screenSize;

    GUI() {
        // Get the size of the computer window
        Rectangle screenRect =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        screenSize = new Dimension((int) screenRect.getWidth(), (int) screenRect.getHeight());

        // Initialize the desk array
        logins = new ArrayList<Login>();

        // Create the instance
        frame = new JFrame();

        // Get the container
        window = frame.getContentPane();

        // Create button instances
        loginButton = new JButton("Login");
        exitButton = new JButton("Exit");
        addTeacherButton = new JButton("Create New Teacher");
        addStudentButton = new JButton("Create New Student");
        submitButtonTeacher = new JButton("Ok");
        submitButtonStudent = new JButton("Ok");

        // Instantiate all of the labels
        usernameInputLabel = new JLabel("Username: ");
        passwordInputLabel = new JLabel("Password: ");
        studentDataLabel = new JLabel("Student(s): ");
        teacherDataLabel = new JLabel("Teacher(s): ");

        // Attach the buttons to the actionListener
        loginButton.addActionListener(this);
        exitButton.addActionListener(this);
        addTeacherButton.addActionListener(this);
        addStudentButton.addActionListener(this);
        submitButtonTeacher.addActionListener(this);
        submitButtonStudent.addActionListener(this);

        // Set the text boxes for the input
        usernameText = new JTextField(16);
        passwordText = new JPasswordField(16);

        // Add the buttons to the window
        window.add(loginButton);
        window.add(exitButton);
        window.add(usernameInputLabel);
        window.add(usernameText);
        window.add(passwordInputLabel);
        window.add(passwordText);

        // Set the program to exit when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background color
        frame.setBackground(Color.BLUE);

        // Set the size (same as the screen size, so fullscreen)
        frame.setPreferredSize(screenSize);

        // Allow the window to be resized
        frame.setResizable(true);

        // Set the title
        frame.setTitle("Student Teacher Database");

        // Setup the login layout
        loginLayout = new SpringLayout();

        // Set the positions of the elements on the login page
        loginLayout.putConstraint(
                SpringLayout.NORTH, usernameInputLabel, 10, SpringLayout.NORTH, window);
        loginLayout.putConstraint(
                SpringLayout.NORTH, usernameText, 5, SpringLayout.SOUTH, usernameInputLabel);
        loginLayout.putConstraint(
                SpringLayout.WEST, usernameText, 0, SpringLayout.WEST, usernameInputLabel);
        loginLayout.putConstraint(
                SpringLayout.NORTH, passwordInputLabel, 10, SpringLayout.SOUTH, usernameText);
        loginLayout.putConstraint(
                SpringLayout.WEST, passwordInputLabel, 0, SpringLayout.WEST, usernameText);
        loginLayout.putConstraint(
                SpringLayout.NORTH, passwordText, 5, SpringLayout.SOUTH, passwordInputLabel);
        loginLayout.putConstraint(SpringLayout.NORTH, exitButton, 20, SpringLayout.SOUTH, passwordText);
        loginLayout.putConstraint(SpringLayout.NORTH, loginButton, 20, SpringLayout.SOUTH, passwordText);
        loginLayout.putConstraint(SpringLayout.WEST, loginButton, 20, SpringLayout.WEST, window);
        loginLayout.putConstraint(SpringLayout.WEST, exitButton, 0, SpringLayout.EAST, loginButton);

        // Set the layout of the window
        window.setLayout(loginLayout);

        // Pack the frame
        frame.pack();

        // Make the window visible
        frame.setVisible(true);
    }

    // Process button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {

            // ! WRITE THE CHECK HERE
            JOptionPane.showMessageDialog(
                    window, "Check not written", "Login status", JOptionPane.INFORMATION_MESSAGE);

            if (true/* Write check here */) {
                switchToDataPage();
            }
            else {
                passwordText.setText("");
            }



        } else if (ae.getSource() == exitButton) {
            System.exit(0);
        } else if (ae.getSource() == addTeacherButton) {
            window.remove(addTeacherButton);
            window.remove(addStudentButton);
        } else if (ae.getSource() == addStudentButton) {
            window.remove(addTeacherButton);
            window.remove(addStudentButton);
        } else if (ae.getSource() == submitButtonTeacher) {
            window.remove(submitButtonTeacher);
        } else if (ae.getSource() == submitButtonStudent) {
            window.remove(submitButtonStudent);
        }
    }

    public void switchToLoginPage() {

    }

    public void switchToDataPage() {

        // Remove the old window details
        window.removeAll();
        window.repaint();

        // Add the new window details
        window.add(studentDataLabel);
        window.add(teacherDataLabel);
        //window.add(addTeacherButton);
        //window.add(addStudentButton);

        // Re-create the layout (must be done every time as the list of objects could change)
        dataExplorerLayout = new SpringLayout();

        // Add the constraints to the display
        dataExplorerLayout.putConstraint(SpringLayout.NORTH, studentDataLabel, 0, SpringLayout.NORTH, window);

        JLabel lastAddressLabel = new Person("Bryson", new Address("My street", "My city", "My state", 0000), 2003).addToWindow(window, dataExplorerLayout, studentDataLabel);
        dataExplorerLayout.putConstraint(SpringLayout.NORTH, teacherDataLabel, 20, SpringLayout.SOUTH, lastAddressLabel);

        // Set the new layout
        window.setLayout(dataExplorerLayout);

        // Pack the window (solves all component constraints)
        frame.pack();
    }

    public void switchToNewTeacherPage() {

    }

    public void switchToNewStudentPage() {

    }

    public static void main(String[] args) {
        GUI theGUI = new GUI();
    }
}

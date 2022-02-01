package Inheritance;

// Import libraries
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener {

    private static JFrame frame;
    private static Container window;
    private static SpringLayout layout;

    // Text fields
    private static JTextField usernameText;
    private static JPasswordField passwordText;
    private static JTextField nameText;
    private static JTextField yearOfBirthText;
    private static JTextField streetText;
    private static JTextField cityText;
    private static JTextField stateText;
    private static JTextField zipText;
    private static JTextField idText;
    private static JTextField majorText;
    private static JTextField gpaText;
    private static JTextField salaryText;

    // Labels
    private static JLabel usernameInputlabel;
    private static JLabel passwordInputlabel;
    private static JLabel nameInputlabel;
    private static JLabel streetInputlabel;
    private static JLabel cityInputlabel;
    private static JLabel stateInputLabel;
    private static JLabel zipInputLabel;
    private static JLabel birthYearInputLabel;
    private static JLabel idInputlabel;
    private static JLabel studentMajorLabel;
    private static JLabel studentGPALabel;
    private static JLabel teacherSalaryLabel;

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

        // Set the layout
        layout = new SpringLayout();
        window.setLayout(layout);

        // Create button instances
        loginButton = new JButton("Login");
        exitButton = new JButton("Exit");
        addTeacherButton = new JButton("Create New Teacher");
        addStudentButton = new JButton("Create New Student");
        submitButtonTeacher = new JButton("Ok");
        submitButtonStudent = new JButton("Ok");

        // Instantiate all of the labels
        usernameInputlabel = new JLabel("Username: ");
        passwordInputlabel = new JLabel("Password: ");
        nameInputlabel = new JLabel("Name: ");
        streetInputlabel = new JLabel("Street: ");
        cityInputlabel = new JLabel("City: ");
        stateInputLabel = new JLabel("State: ");
        zipInputLabel = new JLabel("Zip: ");
        birthYearInputLabel = new JLabel("Year of Birth: ");
        idInputlabel = new JLabel("ID: ");
        studentMajorLabel = new JLabel("Major: ");
        studentGPALabel = new JLabel("GPA: ");
        teacherSalaryLabel = new JLabel("Salary: ");

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

        nameText = new JTextField(30);
        yearOfBirthText = new JTextField(30);
        streetText = new JTextField(30);
        cityText = new JTextField(30);
        stateText = new JTextField(30);
        zipText = new JTextField(30);
        idText = new JTextField(30);
        majorText = new JTextField(30);
        gpaText = new JTextField(30);
        salaryText = new JTextField(30);

        // Add the buttons to the window
        window.add(loginButton);
        window.add(exitButton);
        window.add(usernameInputlabel);
        window.add(usernameText);
        window.add(passwordInputlabel);
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

        // Set the positions of the buttons
        layout.putConstraint(
                SpringLayout.NORTH, usernameInputlabel, 10, SpringLayout.NORTH, window);
        layout.putConstraint(
                SpringLayout.NORTH, usernameText, 5, SpringLayout.SOUTH, usernameInputlabel);
        layout.putConstraint(
                SpringLayout.WEST, usernameText, 0, SpringLayout.WEST, usernameInputlabel);
        layout.putConstraint(
                SpringLayout.NORTH, passwordInputlabel, 10, SpringLayout.SOUTH, usernameText);
        layout.putConstraint(
                SpringLayout.WEST, passwordInputlabel, 0, SpringLayout.WEST, usernameText);
        layout.putConstraint(
                SpringLayout.NORTH, passwordText, 5, SpringLayout.SOUTH, passwordInputlabel);
        layout.putConstraint(SpringLayout.NORTH, exitButton, 20, SpringLayout.SOUTH, passwordText);
        layout.putConstraint(SpringLayout.NORTH, loginButton, 20, SpringLayout.SOUTH, passwordText);
        layout.putConstraint(SpringLayout.WEST, loginButton, 20, SpringLayout.WEST, window);
        layout.putConstraint(SpringLayout.WEST, exitButton, 0, SpringLayout.EAST, loginButton);

        // Pack the frame
        frame.pack();

        // Update the visual reference
        SwingUtilities.updateComponentTreeUI(frame);

        // Make the window visible
        frame.setVisible(true);
    }

    // Process button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            window.remove(loginButton);
            window.remove(exitButton);
            window.remove(usernameInputlabel);
            window.remove(usernameText);
            window.remove(passwordInputlabel);
            window.remove(passwordText);

            window.add(addTeacherButton);
            window.add(addStudentButton);

            // ! WRITE THE CHECK HERE
            JOptionPane.showMessageDialog(
                    window, "Check not written", "Login status", JOptionPane.INFORMATION_MESSAGE);
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

    public static void main(String[] args) {
        GUI theGUI = new GUI();
    }
}

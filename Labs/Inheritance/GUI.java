package Inheritance;

// Import libraries
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener {

    // Main framing and window
    private static Container window;
    private static JPanel panel;

    // Layouts
    private static SpringLayout loginLayout;
    private static SpringLayout dataExplorerLayout;
    private static SpringLayout newStudentLayout;
    private static SpringLayout newTeacherLayout;

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
    private static JLabel usernameInputLabel;
    private static JLabel passwordInputLabel;
    private static JLabel studentDataLabel;
    private static JLabel teacherDataLabel;

    private static JLabel nameInputLabel;
    private static JLabel streetInputLabel;
    private static JLabel cityInputLabel;
    private static JLabel stateInputLabel;
    private static JLabel zipInputLabel;
    private static JLabel birthYearInputLabel;
    private static JLabel idInputLabel;
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
    private static JButton cancelButton;

    // Login array (for storing available logins)
    private static ArrayList<Login> logins = new ArrayList<Login>();

    private static ArrayList<Student> students = new ArrayList<Student>();
    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    // Sizes
    private static Dimension screenSize;

    GUI() {
        super();

        // Testing
        logins.add(new Login("CAP1Sup", "12345"));
        logins.add(new Login("Ellie42", "4242"));
        /*
        students.add(
                new Student(
                        "Will",
                        new Address("Mountain Drive", "State College", "PA", 18053),
                        2003,
                        456372,
                        "Aerospace Engineering",
                        3.80));
        students.add(
            new Student(
                    "Will",
                    new Address("Mountain Drive", "State College", "PA", 18053),
                    2003,
                    456372,
                    "Aerospace Engineering",
                    3.80));
        students.add(
                new Student(
                        "Trinity",
                        new Address("River Road", "Dover", "DE", 19701),
                        2003,
                        982022,
                        "Marine Biology",
                        3.80));

        teachers.add(
                new Teacher(
                        "Gwen", new Address("Valley", "Baltimore", "MD", 21234), 834201, 70, 000));
        teachers.add(
                new Teacher(
                        "Rich", new Address("Valley", "Baltimore", "MD", 21234), 340873, 80, 000));*/

        // Get the size of the computer window
        Rectangle screenRect =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        screenSize = new Dimension((int) screenRect.getWidth(), (int) screenRect.getHeight());

        // Create the panel
        panel = new JPanel();

        // Get the container
        window = this.getContentPane();

        // Add the scroll pane
        add(panel);

        // Create button instances
        loginButton = new JButton("Login");
        exitButton = new JButton("Exit");
        addTeacherButton = new JButton("Create New Teacher");
        addStudentButton = new JButton("Create New Student");
        submitButtonTeacher = new JButton("Submit");
        submitButtonStudent = new JButton("Submit");
        cancelButton = new JButton("Cancel");

        // Instantiate all of the labels
        usernameInputLabel = new JLabel("Username: ");
        passwordInputLabel = new JLabel("Password: ");
        studentDataLabel = new JLabel("Student(s): ");
        teacherDataLabel = new JLabel("Teacher(s): ");

        nameInputLabel = new JLabel("Name: ");
        streetInputLabel = new JLabel("Street: ");
        cityInputLabel = new JLabel("City: ");
        stateInputLabel = new JLabel("State: ");
        zipInputLabel = new JLabel("Zip: ");
        birthYearInputLabel = new JLabel("Year of Birth: ");
        idInputLabel = new JLabel("ID: ");
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
        cancelButton.addActionListener(this);

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

        // Set the program to exit when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size (same as the screen size, so fullscreen)
        setPreferredSize(screenSize);

        // Allow the window to be resized
        setResizable(true);

        // Set the title
        setTitle("Student Teacher Database");

        // Switch to the login page
        switchToLoginPage();

        // Make the window visible
        setVisible(true);
    }

    // Process button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {

            if (allowLogin()) {
                switchToDataPage();
            } else {
                JOptionPane.showMessageDialog(
                        panel,
                        "Login failed!",
                        "Please try again",
                        JOptionPane.INFORMATION_MESSAGE);
                passwordText.setText("");
            }

        } else if (ae.getSource() == exitButton) {
            System.exit(0);
        } else if (ae.getSource() == addTeacherButton) {
            switchToNewTeacherPage();
        } else if (ae.getSource() == addStudentButton) {
            switchToNewStudentPage();
        } else if (ae.getSource() == submitButtonTeacher) {
            createNewTeacher();
            switchToDataPage();
            JOptionPane.showMessageDialog(
                    panel,
                    "Your new teacher has been added!",
                    "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (ae.getSource() == submitButtonStudent) {
            createNewStudent();
            switchToDataPage();
            JOptionPane.showMessageDialog(
                    panel,
                    "Your new student has been added!",
                    "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (ae.getSource() == cancelButton) {
            switchToDataPage();
        }
    }

    /**
     * Checks to see if the username and password are valid
     *
     * @return If the login should be allowed
     */
    public boolean allowLogin() {

        // Get the values of the username and password inputs
        String usernameInput = usernameText.getText();
        String passwordInput = passwordText.getText();

        // Loop through the logins, checking if one matches
        for (Login login : logins) {

            // Check to see if the username matches
            if (login.getUsername().equals(usernameInput.strip())) {

                // Check that the password hashes match
                if (login.getPasswordHash() == passwordInput.strip().hashCode()) {

                    // Both fields match, allow the login
                    return true;
                }
            }
        }

        // If we made it here, there is no login that matches
        return false;
    }

    // When Information is entered, add new teacher to the arrayList of teachers
    public void createNewTeacher() {

        teachers.add(
                new Teacher(
                        nameText.getText().strip(),
                        (new Address(
                                streetText.getText().strip(),
                                cityText.getText().strip(),
                                stateText.getText().strip(),
                                Integer.parseInt(zipText.getText().strip()))),
                        Integer.parseInt(yearOfBirthText.getText().strip()),
                        Integer.parseInt(idText.getText().strip()),
                        Integer.parseInt(salaryText.getText().strip())));
    }

    // When Information is entered, add a new Student to the arrayList of students
    public void createNewStudent() {

        students.add(
                new Student(
                        nameText.getText().strip(),
                        (new Address(
                                streetText.getText().strip(),
                                cityText.getText().strip(),
                                stateText.getText().strip(),
                                Integer.parseInt(zipText.getText().strip()))),
                        Integer.parseInt(yearOfBirthText.getText().strip()),
                        Integer.parseInt(idText.getText().strip()),
                        majorText.getText().strip(),
                        Double.parseDouble(gpaText.getText().strip())));
    }

    public void switchToLoginPage() {

        // Remove the old window details
        panel.removeAll();
        panel.repaint();

        // Add the buttons to the window
        panel.add(loginButton);
        panel.add(exitButton);
        panel.add(usernameInputLabel);
        panel.add(usernameText);
        panel.add(passwordInputLabel);
        panel.add(passwordText);

        // Setup the login layout
        loginLayout = new SpringLayout();

        // Set the positions of the elements on the login page
        loginLayout.putConstraint(
                SpringLayout.NORTH, usernameInputLabel, 10, SpringLayout.NORTH, panel);
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
        loginLayout.putConstraint(
                SpringLayout.NORTH, exitButton, 20, SpringLayout.SOUTH, passwordText);
        loginLayout.putConstraint(
                SpringLayout.NORTH, loginButton, 20, SpringLayout.SOUTH, passwordText);
        loginLayout.putConstraint(SpringLayout.WEST, loginButton, 20, SpringLayout.WEST, panel);
        loginLayout.putConstraint(SpringLayout.WEST, exitButton, 0, SpringLayout.EAST, loginButton);

        // Set the layout of the window
        panel.setLayout(loginLayout);

        // Pack the window (solves all component constraints)
        this.pack();
    }

    public void switchToDataPage() {

        // Remove the old window details
        panel.removeAll();
        panel.repaint();

        // Add the new window details
        panel.add(studentDataLabel);
        panel.add(addStudentButton);
        panel.add(teacherDataLabel);
        panel.add(addTeacherButton);

        // Re-create the layout (must be done every time as the list of objects could change)
        dataExplorerLayout = new SpringLayout();

        // Add the constraints to the display
        dataExplorerLayout.putConstraint(
                SpringLayout.NORTH, studentDataLabel, 0, SpringLayout.NORTH, panel);

        // Create a storage for the last label, which will allow nice formatting
        JLabel lastLabel = studentDataLabel;

        // Loop through the student ArrayList, adding each student
        for (Student student : students) {
            lastLabel = student.addToWindow(panel, dataExplorerLayout, lastLabel, 10);
        }

        // Add the new student button
        dataExplorerLayout.putConstraint(
                SpringLayout.NORTH, addStudentButton, 10, SpringLayout.SOUTH, lastLabel);

        // Add the constrain the last label
        dataExplorerLayout.putConstraint(
                SpringLayout.NORTH, teacherDataLabel, 20, SpringLayout.SOUTH, addStudentButton);

        // Set that the last label should be the teacher data label
        lastLabel = teacherDataLabel;

        // Loop through the student ArrayList, adding each student
        for (Teacher teacher : teachers) {
            lastLabel = teacher.addToWindow(panel, dataExplorerLayout, lastLabel, 10);
        }

        // Add the new student button
        dataExplorerLayout.putConstraint(
                SpringLayout.NORTH, addTeacherButton, 10, SpringLayout.SOUTH, lastLabel);

        // Set the new layout
        panel.setLayout(dataExplorerLayout);

        // Add edit Buttons
        // for(int i = 0; i < students.size(); i++){}

        // Pack the window (solves all component constraints)
        this.pack();
    }

    public void switchToNewStudentPage() {

        // Remove the old window details
        panel.removeAll();
        panel.repaint();

        // Reset the layout
        newStudentLayout = new SpringLayout();

        // Add all of the labels to the window
        panel.add(nameInputLabel);
        panel.add(nameText);
        panel.add(birthYearInputLabel);
        panel.add(yearOfBirthText);
        panel.add(streetInputLabel);
        panel.add(streetText);
        panel.add(cityInputLabel);
        panel.add(cityText);
        panel.add(stateInputLabel);
        panel.add(stateText);
        panel.add(zipInputLabel);
        panel.add(zipText);
        panel.add(idInputLabel);
        panel.add(idText);
        panel.add(studentMajorLabel);
        panel.add(majorText);
        panel.add(studentGPALabel);
        panel.add(gpaText);
        panel.add(submitButtonStudent);
        panel.add(cancelButton);

        // Put constraints on the items in the window
        // Top / bottom constraints
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, nameInputLabel, 0, SpringLayout.NORTH, panel);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, nameText, 0, SpringLayout.SOUTH, nameInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, birthYearInputLabel, 0, SpringLayout.SOUTH, nameText);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, yearOfBirthText, 0, SpringLayout.SOUTH, birthYearInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, streetInputLabel, 0, SpringLayout.SOUTH, yearOfBirthText);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, streetText, 0, SpringLayout.SOUTH, streetInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, cityInputLabel, 0, SpringLayout.SOUTH, streetText);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, cityText, 0, SpringLayout.SOUTH, cityInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, stateInputLabel, 0, SpringLayout.SOUTH, cityText);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, stateText, 0, SpringLayout.SOUTH, stateInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, zipInputLabel, 0, SpringLayout.SOUTH, stateText);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, zipText, 0, SpringLayout.SOUTH, zipInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, idInputLabel, 0, SpringLayout.SOUTH, zipText);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, idText, 0, SpringLayout.SOUTH, idInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, studentMajorLabel, 0, SpringLayout.SOUTH, idText);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, majorText, 0, SpringLayout.SOUTH, studentMajorLabel);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, studentGPALabel, 0, SpringLayout.SOUTH, majorText);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, gpaText, 0, SpringLayout.SOUTH, studentGPALabel);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, submitButtonStudent, 0, SpringLayout.SOUTH, gpaText);
        newStudentLayout.putConstraint(
                SpringLayout.NORTH, cancelButton, 0, SpringLayout.SOUTH, gpaText);

        // Left / Right constraints
        newStudentLayout.putConstraint(
                SpringLayout.WEST, nameInputLabel, 0, SpringLayout.WEST, panel);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, nameText, 0, SpringLayout.WEST, nameInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, birthYearInputLabel, 0, SpringLayout.WEST, nameText);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, yearOfBirthText, 0, SpringLayout.WEST, birthYearInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, streetInputLabel, 0, SpringLayout.WEST, yearOfBirthText);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, streetText, 0, SpringLayout.WEST, streetInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, cityInputLabel, 0, SpringLayout.WEST, streetText);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, cityText, 0, SpringLayout.WEST, cityInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, stateInputLabel, 0, SpringLayout.WEST, cityText);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, stateText, 0, SpringLayout.WEST, stateInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, zipInputLabel, 0, SpringLayout.WEST, stateText);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, zipText, 0, SpringLayout.WEST, zipInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, idInputLabel, 0, SpringLayout.WEST, zipText);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, idText, 0, SpringLayout.WEST, idInputLabel);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, studentMajorLabel, 0, SpringLayout.WEST, idText);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, majorText, 0, SpringLayout.WEST, studentMajorLabel);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, studentGPALabel, 0, SpringLayout.WEST, majorText);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, gpaText, 0, SpringLayout.WEST, studentGPALabel);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, submitButtonStudent, 0, SpringLayout.WEST, gpaText);
        newStudentLayout.putConstraint(
                SpringLayout.WEST, cancelButton, 0, SpringLayout.EAST, submitButtonStudent);

        // Set the layout of the window
        panel.setLayout(newStudentLayout);

        // Clear all Text Fields
        nameText.setText("");
        streetText.setText("");
        cityText.setText("");
        stateText.setText("");
        zipText.setText("");
        yearOfBirthText.setText("");
        idText.setText("");
        majorText.setText("");
        gpaText.setText("");

        // Pack the frame
        this.pack();
    }

    public void switchToNewTeacherPage() {

        // Remove all of the old info from the window
        panel.removeAll();
        panel.repaint();

        // Reset the layout of the teacher input layout
        newTeacherLayout = new SpringLayout();

        // Add all new labels and text fields
        panel.add(nameInputLabel);
        panel.add(nameText);
        panel.add(birthYearInputLabel);
        panel.add(yearOfBirthText);
        panel.add(streetInputLabel);
        panel.add(streetText);
        panel.add(cityInputLabel);
        panel.add(cityText);
        panel.add(stateInputLabel);
        panel.add(stateText);
        panel.add(zipInputLabel);
        panel.add(zipText);
        panel.add(idInputLabel);
        panel.add(idText);
        panel.add(teacherSalaryLabel);
        panel.add(salaryText);

        // Add buttons
        panel.add(submitButtonTeacher);
        panel.add(cancelButton);

        // Put constraints on the items in the window
        // Top / bottom constraints
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, nameInputLabel, 0, SpringLayout.NORTH, panel);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, nameText, 0, SpringLayout.SOUTH, nameInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, birthYearInputLabel, 0, SpringLayout.SOUTH, nameText);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, yearOfBirthText, 0, SpringLayout.SOUTH, birthYearInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, streetInputLabel, 0, SpringLayout.SOUTH, yearOfBirthText);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, streetText, 0, SpringLayout.SOUTH, streetInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, cityInputLabel, 0, SpringLayout.SOUTH, streetText);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, cityText, 0, SpringLayout.SOUTH, cityInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, stateInputLabel, 0, SpringLayout.SOUTH, cityText);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, stateText, 0, SpringLayout.SOUTH, stateInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, zipInputLabel, 0, SpringLayout.SOUTH, stateText);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, zipText, 0, SpringLayout.SOUTH, zipInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, idInputLabel, 0, SpringLayout.SOUTH, zipText);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, idText, 0, SpringLayout.SOUTH, idInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, teacherSalaryLabel, 0, SpringLayout.SOUTH, idText);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, salaryText, 0, SpringLayout.SOUTH, teacherSalaryLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, submitButtonTeacher, 0, SpringLayout.SOUTH, salaryText);
        newTeacherLayout.putConstraint(
                SpringLayout.NORTH, cancelButton, 0, SpringLayout.SOUTH, salaryText);

        // Left / Right constraints
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, nameInputLabel, 0, SpringLayout.WEST, panel);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, nameText, 0, SpringLayout.WEST, nameInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, birthYearInputLabel, 0, SpringLayout.WEST, nameText);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, yearOfBirthText, 0, SpringLayout.WEST, birthYearInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, streetInputLabel, 0, SpringLayout.WEST, yearOfBirthText);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, streetText, 0, SpringLayout.WEST, streetInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, cityInputLabel, 0, SpringLayout.WEST, streetText);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, cityText, 0, SpringLayout.WEST, cityInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, stateInputLabel, 0, SpringLayout.WEST, cityText);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, stateText, 0, SpringLayout.WEST, stateInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, zipInputLabel, 0, SpringLayout.WEST, stateText);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, zipText, 0, SpringLayout.WEST, zipInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, idInputLabel, 0, SpringLayout.WEST, zipText);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, idText, 0, SpringLayout.WEST, idInputLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, teacherSalaryLabel, 0, SpringLayout.WEST, idText);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, salaryText, 0, SpringLayout.WEST, teacherSalaryLabel);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, submitButtonTeacher, 0, SpringLayout.WEST, salaryText);
        newTeacherLayout.putConstraint(
                SpringLayout.WEST, cancelButton, 0, SpringLayout.EAST, submitButtonTeacher);

        // Set the layout of the window
        panel.setLayout(newTeacherLayout);

        // Clears all of the text fields
        nameText.setText("");
        streetText.setText("");
        cityText.setText("");
        stateText.setText("");
        zipText.setText("");
        yearOfBirthText.setText("");
        idText.setText("");
        salaryText.setText("");

        // Pack the frame
        this.pack();
    }

    public static void main(String[] args) {
        GUI theGUI = new GUI();
    }
}

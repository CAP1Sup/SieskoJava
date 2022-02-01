package Inheritance;

import java.awt.*;

import javax.swing.*;

public class Student extends Person {

    // Instance variables
    private int id;
    private String major;
    private double GPA;

    /**
     * Creates a new Student object
     *
     * @param address
     * @param name
     * @param yearOfBirth
     * @param id
     * @param major
     * @param GPA
     */
    public Student(
            String name, Address address, int yearOfBirth, int id, String major, double GPA) {

        // Set up the Person superclass
        super(name, address, yearOfBirth);

        // Set all of the instance variables
        this.id = id;
        this.major = major;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return String.format(
                "%s | ID: %d | Major: %s | GPA: %f",
                super.toString(), this.id, this.major, this.GPA);
    }

    /**
     * Adds the Student object details to the specified window
     *
     * @param window The container to add the Student details to
     * @param layout The layout to add the components to
     * @param aboveComponent The component that the address data should come after
     * @return Returns the last label, allowing the entries to be stacked
     */
    public JLabel addToWindow(Container window, SpringLayout layout, JComponent aboveComponent) {

        // Create the different labels of text
        JLabel idLabel = new JLabel("ID: " + this.id);
        JLabel majorLabel = new JLabel("Major: " + this.major);
        JLabel gpaLabel = new JLabel("Salary: " + this.GPA);

        // Add all of the elements to the window
        window.add(idLabel);
        window.add(majorLabel);
        window.add(gpaLabel);

        // Set up the Person items (store the last element)
        JLabel lastPersonObj = super.addToWindow(window, layout, aboveComponent);

        // Add the elements to the layout
        // Stack them on top of one another
        layout.putConstraint(SpringLayout.NORTH, idLabel, 0, SpringLayout.SOUTH, lastPersonObj);
        layout.putConstraint(SpringLayout.NORTH, majorLabel, 0, SpringLayout.SOUTH, idLabel);
        layout.putConstraint(SpringLayout.NORTH, gpaLabel, 0, SpringLayout.SOUTH, majorLabel);

        // Make sure that they align to the above component
        layout.putConstraint(SpringLayout.WEST, idLabel, 0, SpringLayout.WEST, lastPersonObj);
        layout.putConstraint(SpringLayout.WEST, majorLabel, 0, SpringLayout.WEST, idLabel);
        layout.putConstraint(SpringLayout.WEST, gpaLabel, 0, SpringLayout.WEST, idLabel);

        // Finally return the last element (GPA in this case)
        return gpaLabel;
    }

    /** @return int return the ID */
    public int getID() {
        return id;
    }

    /** @param id the ID to set */
    public void setID(int id) {
        this.id = id;
    }

    /** @return String return the major */
    public String getMajor() {
        return major;
    }

    /** @param major the major to set */
    public void setMajor(String major) {
        this.major = major;
    }

    /** @return double return the GPA */
    public double getGPA() {
        return GPA;
    }

    /** @param GPA the GPA to set */
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}

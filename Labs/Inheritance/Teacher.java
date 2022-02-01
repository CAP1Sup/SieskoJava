package Inheritance;

import java.awt.*;
import javax.swing.*;

public class Teacher extends Person {
    private int id;
    private int salary;

    public Teacher(String name, Address address, int yearOfBirth, int id, int salary) {
        super(name, address, yearOfBirth);
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s | ID: %d | Salary: %d", super.toString(), this.id, this.salary);
    }

    /**
     * Adds the Teacher object details to the specified window
     * @param window The container to add the Teacher details to
     * @param layout The layout to add the components to
     * @param aboveComponent The component that the address data should come after
     * @return Returns the last label, allowing the entries to be stacked
     */
    public JLabel addToWindow(Container window, SpringLayout layout, JComponent aboveComponent) {

        // Create the different labels of text
        JLabel idLabel = new JLabel("ID: " + this.id);
        JLabel salaryLabel = new JLabel("Salary: " + this.salary);

        // Add all of the elements to the window
        window.add(idLabel);
        window.add(salaryLabel);

        // Set up the Person items (store the last element)
        JLabel lastPersonObj = super.addToWindow(window, layout, aboveComponent);

        // Add the elements to the layout
        // Stack them on top of one another
        layout.putConstraint(SpringLayout.NORTH, idLabel, 0, SpringLayout.SOUTH, lastPersonObj);
        layout.putConstraint(SpringLayout.NORTH, salaryLabel, 0, SpringLayout.SOUTH, idLabel);

        // Make sure that they align to the above component
        layout.putConstraint(SpringLayout.WEST, idLabel, 0, SpringLayout.WEST, lastPersonObj);
        layout.putConstraint(SpringLayout.WEST, salaryLabel, 0, SpringLayout.WEST, idLabel);

        // Finally return the last element (salary in this case)
        return salaryLabel;
    }

    /** @return int return the id */
    public int getId() {
        return id;
    }

    /** @param id the id to set */
    public void setId(int id) {
        this.id = id;
    }

    /** @return int return the salary */
    public int getSalary() {
        return salary;
    }

    /** @param salary the salary to set */
    public void setSalary(int salary) {
        this.salary = salary;
    }
}

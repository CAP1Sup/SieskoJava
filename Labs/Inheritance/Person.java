package Inheritance;

import java.awt.*;

import javax.swing.*;

public class Person {

    // Variables
    private Address address;
    private String name;
    private int yearOfBirth;

    public Person() {
        address = new Address();
        name = "";
        yearOfBirth = 0;
    }

    public Person(Address a) {
        address = a;
        name = "";
        yearOfBirth = 0;
    }

    public Person(String n, Address a) {
        address = a;
        name = n;
        yearOfBirth = 0;
    }

    public Person(String n, Address a, int y) {
        address = a;
        name = n;
        yearOfBirth = y;
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s | Address: %s | Birth year: %d",
                this.name, address.toString(), this.yearOfBirth);
    }

    /**
     * Adds the Person object details to the specified window
     *
     * @param window The container to add the Person details to
     * @param layout The layout to add the components to
     * @param aboveComponent The component that the address data should come after
     * @return Returns the last label, allowing the entries to be stacked
     */
    public JLabel addToWindow(Container window, SpringLayout layout, JComponent aboveComponent) {

        // Create the different labels of text
        JLabel nameLabel = new JLabel("Name: " + this.name);
        JLabel birthYearLabel = new JLabel("Year of birth: " + this.yearOfBirth);

        // Add all of the elements to the window
        window.add(nameLabel);
        window.add(birthYearLabel);

        // Set up the address items (store the last element)
        JLabel lastAddressObj = address.addToWindow(window, layout, nameLabel);

        // Add the elements to the layout
        // Stack them on top of one another
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 0, SpringLayout.SOUTH, aboveComponent);
        layout.putConstraint(
                SpringLayout.NORTH, birthYearLabel, 0, SpringLayout.SOUTH, lastAddressObj);

        // Make sure that they align to the above component
        layout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, aboveComponent);
        layout.putConstraint(SpringLayout.WEST, birthYearLabel, 0, SpringLayout.WEST, nameLabel);

        // Finally return the last element (zip code in this case)
        return birthYearLabel;
    }

    /** @return Address return the address */
    public Address getAddress() {
        return address;
    }

    /** @param address the address to set */
    public void setAddress(Address address) {
        this.address = address;
    }

    /** @return String return the name */
    public String getName() {
        return name;
    }

    /** @param name the name to set */
    public void setName(String name) {
        this.name = name;
    }

    /** @return int return the yearOfBirth */
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    /** @param yearOfBirth the yearOfBirth to set */
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}

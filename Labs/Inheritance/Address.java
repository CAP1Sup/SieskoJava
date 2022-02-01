package Inheritance;

import java.awt.*;

import javax.swing.*;

public class Address {

    // Variables
    private String street;
    private String city;
    private String state;
    private int zip;

    public Address() {
        street = "";
        city = "";
        state = "";
        zip = 0;
    }

    /**
     * Creates a new address
     *
     * @param street The street number and name
     * @param city The city name
     * @param state The state (two letter version)
     * @param zip Zip code
     */
    public Address(String street, String city, String state, int zip) {

        // Save the values of the variables in the instance variables
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d", this.street, this.city, this.state, this.zip);
    }

    /**
     * Adds the Address object details to the specified window
     *
     * @param window The container to add the Address details to
     * @param layout The layout to add the components to
     * @param aboveComponent The component that the address data should come after
     * @return Returns the last label, allowing the entries to be stacked
     */
    public JLabel addToWindow(Container window, SpringLayout layout, JComponent aboveComponent) {

        // Create the different labels of text
        JLabel streetLabel = new JLabel("Street: " + this.street);
        JLabel cityLabel = new JLabel("City: " + this.city);
        JLabel stateLabel = new JLabel("State: " + this.state);
        JLabel zipLabel = new JLabel("Zip: " + this.zip);

        // Add all of the elements to the window
        window.add(streetLabel);
        window.add(cityLabel);
        window.add(stateLabel);
        window.add(zipLabel);

        // Add the elements to the layout
        // Stack them on top of one another
        layout.putConstraint(
                SpringLayout.NORTH, streetLabel, 0, SpringLayout.SOUTH, aboveComponent);
        layout.putConstraint(SpringLayout.NORTH, cityLabel, 0, SpringLayout.SOUTH, streetLabel);
        layout.putConstraint(SpringLayout.NORTH, stateLabel, 0, SpringLayout.SOUTH, cityLabel);
        layout.putConstraint(SpringLayout.NORTH, zipLabel, 0, SpringLayout.SOUTH, stateLabel);

        // Make sure that they align to the above component
        layout.putConstraint(SpringLayout.WEST, streetLabel, 0, SpringLayout.WEST, aboveComponent);
        layout.putConstraint(SpringLayout.WEST, cityLabel, 0, SpringLayout.WEST, streetLabel);
        layout.putConstraint(SpringLayout.WEST, stateLabel, 0, SpringLayout.WEST, streetLabel);
        layout.putConstraint(SpringLayout.WEST, zipLabel, 0, SpringLayout.WEST, streetLabel);

        // Finally return the last element (zip code in this case)
        return zipLabel;
    }

    /** @return String return the street */
    public String getStreet() {
        return street;
    }

    /** @param street the street to set */
    public void setStreet(String street) {
        this.street = street;
    }

    /** @return String return the city */
    public String getCity() {
        return city;
    }

    /** @param city the city to set */
    public void setCity(String city) {
        this.city = city;
    }

    /** @return String return the state */
    public String getState() {
        return state;
    }

    /** @param state the state to set */
    public void setState(String state) {
        this.state = state;
    }

    /** @return int return the zip */
    public int getZip() {
        return zip;
    }

    /** @param zip the zip to set */
    public void setZip(int zip) {
        this.zip = zip;
    }
}

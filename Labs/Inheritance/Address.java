package Inheritance;

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

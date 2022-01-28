package Inheritance;

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

    public Person(Address a, String n) {
        address = a;
        name = n;
        yearOfBirth = 0;
    }

    public Person(Address a, String n, int y) {
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

package PersonEx;

public class Person {
    String name, address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String toString() {
        return String.format("Name: %s | Address: %s", name, address);
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public String getAddress() {
        return address;
    }
}

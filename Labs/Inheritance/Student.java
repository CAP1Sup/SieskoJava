package Inheritance;

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
            Address address, String name, int yearOfBirth, int id, String major, double GPA) {

        // Set up the Person superclass
        super(address, name, yearOfBirth);

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

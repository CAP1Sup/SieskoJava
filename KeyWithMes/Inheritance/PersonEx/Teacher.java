package PersonEx;

public class Teacher extends Person {
    double salary;

    public Teacher(String name, String address, double salary) {
        super(name, address);
        this.salary = salary;
    }

    public String toString() {
        return String.format("%s | Salary: $%.2f", super.toString(), salary);
    }

    public static void main(String[] args) {
        Teacher t = new Teacher("Mr. Siesko", "Unknown", 58000);
        System.out.println(t);
    }
}

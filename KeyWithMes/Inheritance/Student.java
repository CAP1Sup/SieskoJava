/**
 * @author Christian Piper (@CAP1Sup)
 * @since 1/26/22
 */


class Person {
    private String name;

    public Person(String n) {
        name = n;
    }

    public String toString() {
        return name;
    }
}

public class Student extends Person {
    private int id;

    public Student(String n, int i) {
        super(n);
        id = i;
    }

    public String toString() {
        return super.toString() + " | ID: " + id;
    }

    public static void main(String[] args) {
        Student s = new Student("Nancy", 55);
        System.out.println(s instanceof Student);
        System.out.println(s instanceof Person);
        System.out.println(s);
    }
}

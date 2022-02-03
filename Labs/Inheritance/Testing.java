package Inheritance;

public class Testing {
    public static void main(String args[]) {
        Person p1 = new Person("Ellie", new Address("Windon Ave", "Pittsburgh", "PA", 17047), 2006);
        Person p2 = new Person("Christian", new Address("Riverside", "Philadelphia", "PA", 17864), 2003);

        Student s1 = new Student("Will",new Address("Mountain Drive", "State College", "PA", 18053), 2003, 456372, "Aerospace Engineering",  3.80);
        Student s2 =
                new Student(
                        "Trinity",
                        new Address("River Road", "Dover", "DE", 19701),
                        2003,
                        982022,
                        "Marine Biology",
                        3.80);

        Teacher t1 =
                new Teacher(
                        "Gwen", new Address("Valley", "Baltimore", "MD", 21234), 834201, 70, 000);
        Teacher t2 =
                new Teacher(
                        "Rich", new Address("Valley", "Baltimore", "MD", 21234), 340873, 80, 000);
    }
}

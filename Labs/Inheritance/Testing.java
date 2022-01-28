package Inheritance;

public class Testing
{
    public static void main(String args[])
    {
        Person p1 = new Person(new Address("Windon Ave", "Pittsburgh", "PA", 17047), "Ellie", 2006);
        Person p2 = new Person(new Address("Riverside", "Philadelphia", "PA", 17864), "Christian", 2003);

        Student s1 = new Student(new Address("Mountain Drive", "State College", "PA", 18053), "Will", 2003, 456372, "Aerospace Engineering", 3.80);
        Student s2 = new Student(new Address("River Road", "Dover", "DE", 19701), "Trinity", 2003, 982022, "Marine Biology", 3.80);

        Teacher t1 = new Teacher(new Address("Valley", "Baltimore", "MD", 21234), "Gwen", 834201, 70,000);
        Teacher t2 = new Teacher(new Address("Valley", "Baltimore", "MD", 21234), "Rich", 340873, 80,000);
    }
}

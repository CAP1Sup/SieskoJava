package PersonEx;

public class Student extends Person {
    int idNum;

    public Student(String name, String address, int idNum) {
        super(name, address);
        this.idNum = idNum;
    }

    public String toString() {
        return String.format("%s | ID: %d", super.toString(), idNum);
    }

    public void setID(int newID) {
        this.idNum = newID;
    }

    public int getID() {
        return this.idNum;
    }

    public static void main(String[] args) {
        Student s = new Student("Josh", "None", 12345);
        System.out.println(s);
    }
}

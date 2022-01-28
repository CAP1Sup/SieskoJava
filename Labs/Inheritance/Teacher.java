package Inheritance;

public class Teacher extends Person
{
    private int id;
    private int salary;

    public Teacher()
    {
        super();
        id = 0;
        salary = 0;
    }

    public Teacher(Address a, String n, int y, int t, int s)
    {
        super(a, n, y);
        id = t;
        salary = s;
    }

    @Override
    public String toString() {
        return String.format("%s | ID: %d | Salary: %d", super.toString(), this.id, this.salary);
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return int return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

}

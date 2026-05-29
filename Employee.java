package axldarfo;

/**
 * Employee Class - Represents an employee at AXL Darfo
 */
public class Employee extends Person {

    private String employeeId;
    private String department;
    private double salary;
    private Color  favoriteColor;

    public Employee(String firstName, String lastName, int age,
                    String email, String employeeId, String department, double salary) {
        super(firstName, lastName, age, email);
        this.employeeId = employeeId;
        this.department = department;
        setSalary(salary);
        this.favoriteColor = Color.BLUE; // default
    }

    // Getters
    public String getEmployeeId()    { return employeeId; }
    public String getDepartment()    { return department; }
    public double getSalary()        { return salary; }
    public Color  getFavoriteColor() { return favoriteColor; }

    // Setters
    public void setDepartment(String department)    { this.department = department; }
    public void setFavoriteColor(Color color)       { this.favoriteColor = color; }
    public void setSalary(double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary cannot be negative.");
        this.salary = salary;
    }

    // Give a raise by percentage
    public void giveRaise(double percent) {
        if (percent < 0) throw new IllegalArgumentException("Raise percentage cannot be negative.");
        this.salary += this.salary * (percent / 100.0);
    }

    @Override
    public String toString() {
        return String.format("Employee[ID:%s | %s | Dept:%s | Salary:%.2f€ | Color:%s]",
                employeeId, getFullName(), department, salary, favoriteColor.getName());
    }
}

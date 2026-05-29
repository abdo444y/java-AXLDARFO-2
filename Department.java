package axldarfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Department Class - Represents a department within AXL Darfo
 */
public class Department {

    private String         name;
    private Color          themeColor;
    private List<Employee> employees;
    private Employee       manager;

    public Department(String name, Color themeColor) {
        this.name       = name;
        this.themeColor = (themeColor != null) ? themeColor : Color.BLUE;
        this.employees  = new ArrayList<>();
    }

    // Getters
    public String   getName()       { return name; }
    public Color    getThemeColor() { return themeColor; }
    public Employee getManager()    { return manager; }

    // Set department manager
    public void setManager(Employee manager) {
        this.manager = manager;
        if (!employees.contains(manager)) employees.add(manager);
        System.out.println(manager.getFullName() + " is now manager of " + name);
    }

    // Add employee
    public void addEmployee(Employee emp) {
        if (emp == null) throw new IllegalArgumentException("Employee cannot be null.");
        employees.add(emp);
        emp.setDepartment(name);
        System.out.println("Hired: " + emp.getFullName() + " -> " + name);
    }

    // Remove employee
    public boolean removeEmployee(String employeeId) {
        for (Employee e : employees) {
            if (e.getEmployeeId().equals(employeeId)) {
                employees.remove(e);
                System.out.println("Removed employee: " + e.getFullName());
                return true;
            }
        }
        return false;
    }

    // Calculate total salary cost
    public double getTotalSalaryCost() {
        double total = 0;
        for (Employee e : employees) total += e.getSalary();
        return total;
    }

    // Print department summary
    public void printSummary() {
        System.out.println("\n=== Department: " + name + " [" + themeColor.getName() + "] ===");
        System.out.println("  Manager: " + (manager != null ? manager.getFullName() : "None"));
        System.out.println("  Employees (" + employees.size() + "):");
        for (Employee e : employees) System.out.println("    " + e);
        System.out.printf("  Total Salary Cost: %.2f€/month%n", getTotalSalaryCost());
    }

    public int getEmployeeCount() { return employees.size(); }
    public List<Employee> getEmployees() { return employees; }
}

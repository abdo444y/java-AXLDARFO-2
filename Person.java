package axldarfo;

/**
 * Person Class - Base class for all people in the system
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private String email;

    public Person(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName  = lastName;
        setAge(age);
        this.email = email;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public int    getAge()       { return age; }
    public String getEmail()     { return email; }
    public String getFullName()  { return firstName + " " + lastName; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName)   { this.lastName  = lastName; }
    public void setAge(int age) {
        if (age < 0 || age > 120) throw new IllegalArgumentException("Invalid age: " + age);
        this.age = age;
    }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return String.format("Person[%s, age=%d, email=%s]", getFullName(), age, email);
    }
}

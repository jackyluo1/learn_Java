/**
 * Problem 2 [40pts]
 * Create a class Employee that includes the following instance variables
 * • First name (String) cannot be empty,
 * • Last name (String) cannot be empty,
 * • Monthly salary (double) must be non-negative.
 * Provide a set and a get method for each instance variable. The setters must
 * return boolean
 * and perform validation. If the monthly salary is not positive, set its value
 * to zero. If a name is
 * empty set it to “[empty]”.
 * Provide a constructor that initializes the three instance variables.
 * No default constructor is required. Also, overwrite equals() and toString().
 * Write a
 * test class named EmployeeTest that demonstrates class Employee’s
 * capabilities. Create two
 * different Employee objects. Use println() to display information about each
 * employee (this
 * will invoke toString()). Then compare the two using equals() and display the
 * result.
 * Submission format: You MUST define TWO classes. One is Employee which must be
 * declared
 * as a non-public class. Two is EmployeeTest which is public and contains the
 * main()
 * method. So, you must submit one file EmployeeTest.java containing the above
 * two classes.
 * The tests must be performed in the main() method.
 */
class Employee {
    private String firstName;
    private String lastName;
    private Double monthlySalary;

    public Employee(String firstName, String lastName, Double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySalary = monthlySalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public boolean setFirstName() {
        if (firstName.isEmpty()) {
            System.out.println("Illegel, set firstName to [empty]");
            this.firstName = "[empty]";
            return false;
        }
        return true;
    }

    public boolean setLastName() {
        if (lastName.isEmpty()) {
            System.out.println("Illegel, set lastName to [empty]");
            this.lastName = "[empty]";
            return false;
        }
        return true;
    }

    public boolean setMonthlySalary() {
        if (monthlySalary < 0.0) {
            System.out.println("Illegel, set monthly Salary to 0");
            this.monthlySalary = 0.0;
            return false;
        }
        return true;
    }

    public boolean equals(Employee other) {
        return this.firstName.equals(other.getFirstName()) && this.lastName.equals(other.getLastName())
                && this.monthlySalary.equals(other.getMonthlySalary());
    }

    public String toString() {
        return "First name: " + this.firstName + ", Last name: " + this.lastName + ", Monthly Salary: "
                + this.monthlySalary;
    }

}

public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("");
        Employee a = new Employee("Jing", "Luo", 0.0);
        System.out.println("a FirstName: " + a.getFirstName());
        System.out.println("a LastName: " + a.getLastName());
        System.out.println("a monthly salary: " + a.getMonthlySalary());
        System.out.println(a.setFirstName());
        System.out.println(a.setLastName());
        System.out.println(a.setMonthlySalary());
        System.out.println("Employee a: " + a.toString());
        System.out.println("");
        System.out.println("-------Another Employee");
        Employee b = new Employee("", "", -1.0);
        System.out.println("Employee b:(before seted) " + b.toString());
        System.out.println(b.setFirstName());
        System.out.println(b.setLastName());
        System.out.println(b.setMonthlySalary());
        System.out.println("b FirstName: " + b.getFirstName());
        System.out.println("b FirstName: " + b.getLastName());
        System.out.println("b FirstNamemonthly salary: " + b.getMonthlySalary());
        System.out.println("Employee b:(after seted) " + b.toString());
        System.out.println("");
        System.out.println("------- Employee is same?");
        Employee c = new Employee("Jing", "Luo", 0.0);
        System.out.println("Employee a: " + a.toString());
        System.out.println("Employee b: " + b.toString());
        System.out.println("Employee c: " + c.toString());
        System.out.println("Employee c is equal to Employee a: " + a.equals(c));
        System.out.println("Employee b is equal to Employee a: " + a.equals(b));
        System.out.println("");
    }
}


/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/21/2026
 * Assignment: C330L Week 3 Course Project
 * Title: Abstraction, Constructors, & Access Specifiers
 *
 * Description:
 * This class represents a salaried employee in the
 * Employee Management System.
 *
 * It extends the abstract Employee superclass and
 * calculates monthly pay from the annual salary.
 *
 * This class demonstrates abstraction, inheritance,
 * overloaded constructors, encapsulation, access
 * specifiers, and polymorphism.
 *******************************************************************/

public class SalariedEmployee extends Employee {

    // ACCESS SPECIFIER:
    // Private protects salary information from
    // direct modification outside this class.
    private double annualSalary;

    // PARAMETERIZED CONSTRUCTOR:
    // Initializes the employee and annual salary.
    public SalariedEmployee(int employeeId, String firstName,
                            String lastName, String department,
                            Address address, double annualSalary) {

        // Calls the protected constructor of the
        // abstract Employee superclass.
        super(employeeId, firstName, lastName, department, address);

        setAnnualSalary(annualSalary);
    }

    // OVERLOADED CONSTRUCTOR:
    // Allows an employee to be created before their
    // annual salary has been assigned.
    public SalariedEmployee(int employeeId, String firstName,
                            String lastName, String department,
                            Address address) {

        this(employeeId, firstName, lastName,
             department, address, 0.0);
    }

    // Public getter provides controlled access.
    public double getAnnualSalary() {
        return annualSalary;
    }

    // Public setter validates the annual salary.
    public void setAnnualSalary(double annualSalary) {

        if (!Double.isFinite(annualSalary) || annualSalary < 0) {
            throw new IllegalArgumentException(
                "Annual salary must be a valid non-negative number.");
        }

        this.annualSalary = annualSalary;
    }

    // Calculates the employee's monthly salary.
    public double calculateMonthlyPay() {
        return annualSalary / 12;
    }

    // ABSTRACTION AND POLYMORPHISM:
    // Implements the abstract calculatePay() method
    // inherited from Employee.
    @Override
    public double calculatePay() {
        return calculateMonthlyPay();
    }

    // METHOD OVERRIDING:
    // Displays common employee information along
    // with salaried-specific information.
    @Override
    public String toString() {
        return super.toString()
                + "\nEmployee Type: Salaried"
                + "\nAnnual Salary: $"
                + String.format("%.2f", annualSalary)
                + "\nMonthly Pay: $"
                + String.format("%.2f", calculatePay());
    }
}

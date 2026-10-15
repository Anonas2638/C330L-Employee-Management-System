
/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/15/2026
 * Assignment: C330L Week 2 Course Project
 * Title: Software Design, Interfaces, and Polymorphism
 *
 * Description:
 * This class represents a salaried employee in the Employee
 * Management System. It inherits basic employee information
 * from Employee and stores the employee's annual salary.
 *
 * This class demonstrates polymorphism by overriding the
 * calculatePay() method from the Employee superclass,
 * which implements the Payable interface.
 *******************************************************************/

// INHERITANCE:
// SalariedEmployee extends the Employee superclass.
//
// POLYMORPHISM:
// SalariedEmployee provides its own calculatePay() method
// to calculate monthly salary.

public class SalariedEmployee extends Employee {

    // Private class property
    private double annualSalary;

    // Constructor
    public SalariedEmployee(int employeeId, String firstName,
                            String lastName, String department,
                            Address address, double annualSalary) {

        // Call the parent Employee constructor
        super(employeeId, firstName, lastName, department, address);

        this.annualSalary = annualSalary;
    }

    // Getter and setter methods
    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    // Calculate the employee's monthly salary
    public double calculateMonthlyPay() {
        return annualSalary / 12;
    }

    // POLYMORPHISM:
    // Overrides calculatePay() to return monthly salary.
    @Override
    public double calculatePay() {
        return calculateMonthlyPay();
    }

    // Display all salaried employee information
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

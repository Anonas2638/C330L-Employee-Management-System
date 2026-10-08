/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/08/2026
 * Assignment: C330L Week 1 Project
 * Title: Inheritance, Composition, and User Interactions
 *
 * Description:
 * This class represents a salaried employee in the Employee
 * Management System. It inherits basic employee information
 * from the Employee class and adds annual salary information.
 *******************************************************************/

// INHERITANCE: SalariedEmployee is a child class of Employee.
public class SalariedEmployee extends Employee {

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

    // Display all salaried employee information
    @Override
    public String toString() {
        return super.toString()
                + "\nEmployee Type: Salaried"
                + "\nAnnual Salary: $"
                + String.format("%.2f", annualSalary)
                + "\nMonthly Pay: $"
                + String.format("%.2f", calculateMonthlyPay());
    }
}
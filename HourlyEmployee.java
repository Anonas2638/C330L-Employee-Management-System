
/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/21/2026
 * Assignment: C330L Week 3 Course Project
 * Title: Abstraction, Constructors, & Access Specifiers
 *
 * Description:
 * This class represents an hourly employee in the
 * Employee Management System.
 *
 * It extends the abstract Employee superclass and
 * calculates employee pay based on hourly rate
 * multiplied by hours worked.
 *
 * This class demonstrates abstraction, inheritance,
 * overloaded constructors, encapsulation, access
 * specifiers, and polymorphism.
 *******************************************************************/

public class HourlyEmployee extends Employee {

    // ACCESS SPECIFIERS:
    // Private fields prevent direct modification outside
    // this class.
    private double hourlyRate;
    private double hoursWorked;

    // PARAMETERIZED CONSTRUCTOR:
    // Initializes all employee information, including
    // hourly rate and hours worked.
    public HourlyEmployee(int employeeId, String firstName,
                          String lastName, String department,
                          Address address, double hourlyRate,
                          double hoursWorked) {

        // INHERITANCE:
        // Calls the protected constructor of the
        // abstract Employee superclass.
        super(employeeId, firstName, lastName, department, address);

        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    // OVERLOADED CONSTRUCTOR:
    // Allows an hourly employee to be created with
    // zero hours worked initially.
    public HourlyEmployee(int employeeId, String firstName,
                          String lastName, String department,
                          Address address, double hourlyRate) {

        this(employeeId, firstName, lastName,
             department, address, hourlyRate, 0.0);
    }

    // Public getter provides controlled access.
    public double getHourlyRate() {
        return hourlyRate;
    }

    // Public setter validates the hourly rate.
    public void setHourlyRate(double hourlyRate) {
        if (!Double.isFinite(hourlyRate) || hourlyRate < 0) {
            throw new IllegalArgumentException(
                "Hourly rate must be a valid non-negative number.");
        }

        this.hourlyRate = hourlyRate;
    }

    // Public getter for hours worked.
    public double getHoursWorked() {
        return hoursWorked;
    }

    // Public setter validates hours worked.
    public void setHoursWorked(double hoursWorked) {
        if (!Double.isFinite(hoursWorked) || hoursWorked < 0) {
            throw new IllegalArgumentException(
                "Hours worked must be a valid non-negative number.");
        }

        this.hoursWorked = hoursWorked;
    }

    // ABSTRACTION AND POLYMORPHISM:
    // Implements the abstract calculatePay() method
    // inherited from Employee.
    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    // METHOD OVERRIDING:
    // Displays shared employee information along with
    // hourly-specific details.
    @Override
    public String toString() {
        return super.toString()
                + "\nEmployee Type: Hourly"
                + "\nHourly Rate: $"
                + String.format("%.2f", hourlyRate)
                + "\nHours Worked: " + hoursWorked
                + "\nTotal Pay: $"
                + String.format("%.2f", calculatePay());
    }
}

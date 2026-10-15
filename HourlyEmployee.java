
/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/15/2026
 * Assignment: C330L Week 2 Course Project
 * Title: Software Design, Interfaces, and Polymorphism
 *
 * Description:
 * This class represents an hourly employee in the Employee
 * Management System. It inherits basic employee information
 * from the Employee class and adds hourly pay information.
 *
 * This class demonstrates polymorphism by overriding the
 * calculatePay() method defined in the Payable interface
 * and implemented by the Employee superclass.
 *******************************************************************/

// INHERITANCE:
// HourlyEmployee extends the Employee superclass.
//
// POLYMORPHISM:
// HourlyEmployee overrides calculatePay() to provide
// an hourly-specific pay calculation.

public class HourlyEmployee extends Employee {

    // Private class properties
    private double hourlyRate;
    private double hoursWorked;

    // Constructor
    public HourlyEmployee(int employeeId, String firstName,
                          String lastName, String department,
                          Address address, double hourlyRate,
                          double hoursWorked) {

        // Call the parent Employee constructor
        super(employeeId, firstName, lastName, department, address);

        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Getter and setter methods
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // POLYMORPHISM:
    // Overrides the interface method with an hourly calculation.
    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    // Display all hourly employee information
    @Override
    public String toString() {
        return super.toString()
                + "\nEmployee Type: Hourly"
                + "\nHourly Rate: $" + String.format("%.2f", hourlyRate)
                + "\nHours Worked: " + hoursWorked
                + "\nTotal Pay: $" + String.format("%.2f", calculatePay());
    }
}

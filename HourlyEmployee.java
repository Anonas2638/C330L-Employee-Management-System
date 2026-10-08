/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/08/2026
 * Assignment: C330L Week 1 Project
 * Title: Inheritance, Composition, and User Interactions
 *
 * Description:
 * This class represents an hourly employee in the Employee
 * Management System. It inherits basic employee information
 * from the Employee class and adds hourly pay information.
 *******************************************************************/

// INHERITANCE: HourlyEmployee is a child class of Employee.
public class HourlyEmployee extends Employee {

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

    // Calculate the employee's pay
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
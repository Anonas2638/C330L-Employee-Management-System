/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/08/2026
 * Assignment: C330L Week 1 Project
 * Title: Inheritance, Composition, and User Interactions
 *
 * Description:
 * This class represents a commission-based employee in the
 * Employee Management System. It inherits basic employee
 * information from the Employee class and adds a base salary,
 * total sales, and commission rate.
 *******************************************************************/

// INHERITANCE: CommissionEmployee is a child class of Employee.
public class CommissionEmployee extends Employee {

    private double baseSalary;
    private double totalSales;
    private double commissionRate;

    // Constructor
    public CommissionEmployee(int employeeId, String firstName,
                              String lastName, String department,
                              Address address, double baseSalary,
                              double totalSales, double commissionRate) {

        // Call the parent Employee constructor
        super(employeeId, firstName, lastName, department, address);

        this.baseSalary = baseSalary;
        this.totalSales = totalSales;
        this.commissionRate = commissionRate;
    }

    // Getter and setter methods
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    // Calculate commission earnings
    public double calculateCommission() {
        return totalSales * commissionRate;
    }

    // Calculate total pay including base salary and commission
    public double calculateTotalPay() {
        return baseSalary + calculateCommission();
    }

    // Display all commission employee information
    @Override
    public String toString() {
        return super.toString()
                + "\nEmployee Type: Commission"
                + "\nBase Salary: $"
                + String.format("%.2f", baseSalary)
                + "\nTotal Sales: $"
                + String.format("%.2f", totalSales)
                + "\nCommission Rate: "
                + String.format("%.1f%%", commissionRate * 100)
                + "\nCommission Earned: $"
                + String.format("%.2f", calculateCommission())
                + "\nTotal Pay: $"
                + String.format("%.2f", calculateTotalPay());
    }
}
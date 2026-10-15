
/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/15/2026
 * Assignment: C330L Week 2 Course Project
 * Title: Software Design, Interfaces, and Polymorphism
 *
 * Description:
 * This class represents a commission-based employee in the
 * Employee Management System. It inherits basic employee
 * information from Employee and stores base salary,
 * total sales, and commission rate.
 *
 * This class demonstrates polymorphism by overriding
 * calculatePay() with a commission-based calculation.
 *******************************************************************/

// INHERITANCE:
// CommissionEmployee extends the Employee superclass.
//
// POLYMORPHISM:
// CommissionEmployee overrides calculatePay() to calculate
// base salary plus commission earnings.

public class CommissionEmployee extends Employee {

    // Private class properties
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

    // POLYMORPHISM:
    // Overrides calculatePay() to use the commission pay formula.
    @Override
    public double calculatePay() {
        return calculateTotalPay();
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
                + String.format("%.2f", calculatePay());
    }
}

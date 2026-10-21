
/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/21/2026
 * Assignment: C330L Week 3 Course Project
 * Title: Abstraction, Constructors, & Access Specifiers
 *
 * Description:
 * This class represents a commission-based employee in
 * the Employee Management System.
 *
 * It extends the abstract Employee superclass and
 * calculates employee pay using base salary plus
 * commission earned from total sales.
 *
 * This class demonstrates abstraction, inheritance,
 * overloaded constructors, encapsulation, access
 * specifiers, and polymorphism.
 *******************************************************************/

public class CommissionEmployee extends Employee {

    // ACCESS SPECIFIERS:
    // Private fields protect compensation information
    // from direct modification outside this class.
    private double baseSalary;
    private double totalSales;
    private double commissionRate;

    // PARAMETERIZED CONSTRUCTOR:
    // Initializes all employee and commission information.
    public CommissionEmployee(int employeeId, String firstName,
                              String lastName, String department,
                              Address address, double baseSalary,
                              double totalSales, double commissionRate) {

        // INHERITANCE:
        // Calls the protected constructor of the
        // abstract Employee superclass.
        super(employeeId, firstName, lastName, department, address);

        setBaseSalary(baseSalary);
        setTotalSales(totalSales);
        setCommissionRate(commissionRate);
    }

    // OVERLOADED CONSTRUCTOR:
    // Allows an employee to be created before sales
    // information is available.
    // Total sales and commission rate default to zero.
    public CommissionEmployee(int employeeId, String firstName,
                              String lastName, String department,
                              Address address, double baseSalary) {

        this(employeeId, firstName, lastName, department,
             address, baseSalary, 0.0, 0.0);
    }

    // Public getter for base salary.
    public double getBaseSalary() {
        return baseSalary;
    }

    // Public setter validates base salary.
    public void setBaseSalary(double baseSalary) {
        if (!Double.isFinite(baseSalary) || baseSalary < 0) {
            throw new IllegalArgumentException(
                "Base salary must be a valid non-negative number.");
        }

        this.baseSalary = baseSalary;
    }

    // Public getter for total sales.
    public double getTotalSales() {
        return totalSales;
    }

    // Public setter validates total sales.
    public void setTotalSales(double totalSales) {
        if (!Double.isFinite(totalSales) || totalSales < 0) {
            throw new IllegalArgumentException(
                "Total sales must be a valid non-negative number.");
        }

        this.totalSales = totalSales;
    }

    // Public getter for commission rate.
    public double getCommissionRate() {
        return commissionRate;
    }

    // Commission rate is entered as a decimal.
    // For example, 0.05 represents 5%.
    public void setCommissionRate(double commissionRate) {
        if (!Double.isFinite(commissionRate)
                || commissionRate < 0
                || commissionRate > 1) {
            throw new IllegalArgumentException(
                "Commission rate must be between 0 and 1.");
        }

        this.commissionRate = commissionRate;
    }

    // Calculate commission earnings.
    public double calculateCommission() {
        return totalSales * commissionRate;
    }

    // Calculate total pay including base salary.
    public double calculateTotalPay() {
        return baseSalary + calculateCommission();
    }

    // ABSTRACTION AND POLYMORPHISM:
    // Implements the abstract calculatePay() method
    // inherited from Employee.
    @Override
    public double calculatePay() {
        return calculateTotalPay();
    }

    // METHOD OVERRIDING:
    // Displays common employee information along
    // with commission-specific compensation details.
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

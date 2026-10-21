
/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/21/2026
 * Assignment: C330L Week 3 Course Project
 * Title: Abstraction, Constructors, & Access Specifiers
 *
 * Description:
 * This abstract class represents a general employee in
 * the Employee Management System.
 *
 * It stores common employee information and provides
 * shared methods for hourly, salaried, and commission
 * employees.
 *
 * The class demonstrates abstraction, inheritance,
 * composition, constructors, and access specifiers.
 *******************************************************************/

// ABSTRACTION:
// Employee is abstract because a general employee does
// not have one specific method for calculating pay.
//
// INHERITANCE:
// HourlyEmployee, SalariedEmployee, and CommissionEmployee
// extend this abstract superclass.
//
// INTERFACE:
// Employee implements Payable, requiring subclasses
// to provide their own pay calculation.

public abstract class Employee implements Payable {

    // ACCESS SPECIFIERS:
    // Private fields protect employee information from
    // direct modification outside this class.
    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;

    // COMPOSITION:
    // Each employee contains an Address object.
    private Address address;

    // PARAMETERIZED CONSTRUCTOR:
    // Initializes an employee with complete information.
    protected Employee(int employeeId, String firstName,
                       String lastName, String department,
                       Address address) {

        setEmployeeId(employeeId);
        setFirstName(firstName);
        setLastName(lastName);
        setDepartment(department);
        setAddress(address);
    }

    // ACCESS SPECIFIERS:
    // Public getters and setters provide controlled
    // access to private employee information.

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        if (employeeId <= 0) {
            throw new IllegalArgumentException(
                "Employee ID must be greater than zero.");
        }

        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "First name cannot be empty.");
        }

        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Last name cannot be empty.");
        }

        this.lastName = lastName.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Department cannot be empty.");
        }

        this.department = department.trim();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException(
                "Employee address cannot be null.");
        }

        this.address = address;
    }

    // ABSTRACT METHOD:
    // Each employee subclass must implement its own
    // calculatePay() method.
    //
    // This method also fulfills the Payable interface.
    @Override
    public abstract double calculatePay();

    // SHARED METHOD:
    // All subclasses inherit this method to display
    // common employee information.
    public String getEmployeeInfo() {
        return "Employee ID: " + employeeId
                + "\nName: " + firstName + " " + lastName
                + "\nDepartment: " + department
                + "\nAddress: " + address;
    }

    // METHOD OVERRIDING:
    // Provides a common string representation.
    @Override
    public String toString() {
        return getEmployeeInfo();
    }
}

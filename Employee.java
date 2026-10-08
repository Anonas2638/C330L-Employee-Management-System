/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/08/2026
 * Assignment: C330L Week 1 Project
 * Title: Inheritance, Composition, and User Interactions
 *
 * Description:
 * This class represents a general employee in the Employee
 * Management System. It stores basic employee information and
 * serves as the parent class for different employee types.
 *
 * It also demonstrates composition by containing an Address object.
 *******************************************************************/

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private Address address;

    // Constructor
    public Employee(int employeeId, String firstName, String lastName,
                    String department, Address address) {

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.address = address;
    }

    // Getter and setter methods
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Displays basic employee information
    public String getEmployeeInfo() {
        return "Employee ID: " + employeeId
                + "\nName: " + firstName + " " + lastName
                + "\nDepartment: " + department
                + "\nAddress: " + address;
    }

    @Override
    public String toString() {
        return getEmployeeInfo();
    }
}
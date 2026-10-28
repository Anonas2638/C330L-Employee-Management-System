
/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/28/2026
 * Assignment: C330L Week 4 Course Project
 * Title: Database Interactions
 *
 * Description:
 * Employee Management System using SQLite database operations.
 * Demonstrates CRUD, abstraction, inheritance, composition,
 * interfaces, polymorphism, constructors, and access specifiers.
 *******************************************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeDatabase database = new EmployeeDatabase();

    public static void main(String[] args) {

        database.createTable();
        addSampleEmployees();

        System.out.println("\n==========================================");
        System.out.println("       EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("==========================================");
        System.out.println("Student: Anosha Naseri");
        System.out.println("Course: C330L");
        System.out.println("Week: 4");
        System.out.println("Assignment: Database Interactions");
        System.out.println("\nWelcome to the Employee Management System!");
        System.out.println("Manage employees using the SQLite database.");
        System.out.println("Select a menu option to continue.");

        boolean running = true;

        while (running) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. View All Employees");
            System.out.println("2. View Hourly Employees");
            System.out.println("3. View Salaried Employees");
            System.out.println("4. View Commission Employees");
            System.out.println("5. Search Employee by ID");
            System.out.println("6. Add Employee");
            System.out.println("7. Update Employee");
            System.out.println("8. Delete Employee");
            System.out.println("9. Demonstrate Polymorphism");
            System.out.println("10. Demonstrate OOP Concepts");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    displayEmployees("All");
                    break;
                case "2":
                    displayEmployees("Hourly");
                    break;
                case "3":
                    displayEmployees("Salaried");
                    break;
                case "4":
                    displayEmployees("Commission");
                    break;
                case "5":
                    searchEmployee();
                    break;
                case "6":
                    addEmployee();
                    break;
                case "7":
                    updateEmployee();
                    break;
                case "8":
                    deleteEmployee();
                    break;
                case "9":
                    demonstratePolymorphism();
                    break;
                case "10":
                    demonstrateOOP();
                    break;
                case "11":
                    System.out.println("Thank you! Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid menu selection.");
            }
        }

        scanner.close();
    }

    // Add realistic records only when the database is empty.
    private static void addSampleEmployees() {
        if (!database.getAllEmployees().isEmpty()) {
            return;
        }

        database.addEmployee(new HourlyEmployee(
                101, "Sarah", "Johnson", "Customer Service",
                new Address("123 Main Street", "Fairfax", "VA", "22030"),
                25.00, 40));

        database.addEmployee(new SalariedEmployee(
                102, "Michael", "Smith", "Administration",
                new Address("456 Oak Avenue", "Manassas", "VA", "20110"),
                72000.00));

        database.addEmployee(new CommissionEmployee(
                103, "Emily", "Davis", "Sales",
                new Address("789 Park Road", "Alexandria", "VA", "22314"),
                2000.00, 10000.00, 0.05));
    }

    // READ: Display employees from SQLite.
    private static void displayEmployees(String type) {
        ArrayList<Employee> employees = database.getAllEmployees();
        boolean found = false;

        System.out.println("\n===== " + type.toUpperCase() + " EMPLOYEES =====");

        for (Employee employee : employees) {
            if (type.equals("All")
                    || employee.getClass().getSimpleName()
                            .equals(type + "Employee")) {
                System.out.println(employee);
                System.out.println("-------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found.");
        }
    }

    // READ: Search by employee ID.
    private static void searchEmployee() {
        int id = readInt("Enter Employee ID: ");
        Employee employee = database.getEmployeeById(id);

        if (employee == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println("\n===== EMPLOYEE DETAILS =====");
            System.out.println(employee);
        }
    }

    // CREATE: Insert a new employee.
    private static void addEmployee() {
        System.out.println("\n===== ADD EMPLOYEE =====");
        Employee employee = collectEmployeeDetails(false);

        if (employee != null) {
            if (database.addEmployee(employee)) {
                System.out.println("Employee added successfully!");
            }
        }
    }

    // UPDATE: Modify an existing employee.
    private static void updateEmployee() {
        System.out.println("\n===== UPDATE EMPLOYEE =====");
        int id = readInt("Enter Employee ID to update: ");

        Employee existing = database.getEmployeeById(id);

        if (existing == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println("Current employee:");
        System.out.println(existing);
        System.out.println("\nEnter the new employee information.");

        Employee updated = collectEmployeeDetails(true, id);

        if (updated != null && database.updateEmployee(updated)) {
            System.out.println("Employee updated successfully!");
        }
    }

    // DELETE: Remove a record from SQLite.
    private static void deleteEmployee() {
        System.out.println("\n===== DELETE EMPLOYEE =====");
        int id = readInt("Enter Employee ID to delete: ");

        Employee employee = database.getEmployeeById(id);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println(employee);
        System.out.print("\nConfirm deletion (yes/no): ");
        String confirmation = scanner.nextLine().trim();

        if (confirmation.equalsIgnoreCase("yes")) {
            if (database.deleteEmployee(id)) {
                System.out.println("Employee deleted successfully!");
            }
        } else {
            System.out.println("Deletion canceled.");
        }
    }

    // Collect employee information using validated constructors.
    private static Employee collectEmployeeDetails(boolean updating) {
        int id = readInt("Employee ID: ");
        return collectEmployeeDetails(updating, id);
    }

    private static Employee collectEmployeeDetails(
            boolean updating, int id) {

        try {
            String firstName = readText("First Name: ");
            String lastName = readText("Last Name: ");
            String department = readText("Department: ");

            String street = readText("Street: ");
            String city = readText("City: ");
            String state = readText("State: ");
            String zip = readText("ZIP Code: ");

            Address address = new Address(street, city, state, zip);

            System.out.println("\nEmployee Type:");
            System.out.println("1. Hourly");
            System.out.println("2. Salaried");
            System.out.println("3. Commission");

            int type = readInt("Choose type: ");

            switch (type) {
                case 1:
                    double rate = readDouble("Hourly Rate: ");
                    double hours = readDouble("Hours Worked: ");

                    return new HourlyEmployee(
                            id, firstName, lastName,
                            department, address, rate, hours);

                case 2:
                    double salary = readDouble("Annual Salary: ");

                    return new SalariedEmployee(
                            id, firstName, lastName,
                            department, address, salary);

                case 3:
                    double base = readDouble("Base Salary: ");
                    double sales = readDouble("Total Sales: ");
                    double commission = readDouble(
                            "Commission Rate (example 0.05): ");

                    return new CommissionEmployee(
                            id, firstName, lastName,
                            department, address,
                            base, sales, commission);

                default:
                    System.out.println("Invalid employee type.");
                    return null;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid information: " + e.getMessage());
            return null;
        }
    }

    // POLYMORPHISM: Each employee calculates pay differently.
    private static void demonstratePolymorphism() {
        System.out.println("\n===== POLYMORPHISM DEMONSTRATION =====");

        for (Employee employee : database.getAllEmployees()) {
            Payable payable = employee;

            System.out.println("Employee: "
                    + employee.getFirstName() + " "
                    + employee.getLastName());
            System.out.println("Type: "
                    + employee.getClass().getSimpleName());
            System.out.printf("Calculated Pay: $%.2f%n",
                    payable.calculatePay());
            System.out.println("-------------------------");
        }
    }

    // Demonstrate Week 3 concepts retained in Week 4.
    private static void demonstrateOOP() {
        System.out.println("\n===== OOP DEMONSTRATION =====");

        System.out.println("\nABSTRACTION:");
        System.out.println("Employee is an abstract superclass.");
        System.out.println("Payable defines calculatePay().");

        System.out.println("\nINHERITANCE:");
        System.out.println("HourlyEmployee, SalariedEmployee,");
        System.out.println("and CommissionEmployee extend Employee.");

        System.out.println("\nCOMPOSITION:");
        System.out.println("Every employee contains an Address object.");

        System.out.println("\nOVERLOADED CONSTRUCTORS:");
        Address sampleAddress = new Address(
                "Fairfax", "VA", "22030");

        HourlyEmployee sample = new HourlyEmployee(
                999, "Demo", "Employee", "Training",
                sampleAddress, 20.00);

        System.out.println(sample);
        System.out.println("Default hours worked: "
                + sample.getHoursWorked());

        System.out.println("\nACCESS SPECIFIERS:");
        System.out.println("Employee fields are private.");
        System.out.println("Getters and setters control access.");

        sample.setHourlyRate(25.00);
        System.out.println("Updated hourly rate: $"
                + sample.getHourlyRate());

        System.out.println("\nPOLYMORPHISM:");
        Payable payable = sample;
        System.out.printf("Calculated Pay: $%.2f%n",
                payable.calculatePay());
    }

    // Input validation avoids InputMismatchException.
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(
                        scanner.nextLine().trim());

                if (Double.isFinite(value) && value >= 0) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // Prompt again.
            }

            System.out.println("Enter a valid non-negative number.");
        }
    }

    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This field cannot be empty.");
        }
    }
}

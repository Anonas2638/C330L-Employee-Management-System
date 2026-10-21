
/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/21/2026
 * Assignment: C330L Week 3 Course Project
 * Title: Abstraction, Constructors, & Access Specifiers
 *
 * Description:
 * This application demonstrates object-oriented programming
 * concepts through an Employee Management System.
 *
 * It demonstrates abstraction through the abstract Employee
 * superclass and Payable interface, inheritance through
 * employee subclasses, and composition through Address.
 *
 * The application also demonstrates overloaded constructors,
 * access specifiers, encapsulation, and polymorphism.
 *
 * A console menu allows users to view employees, search by
 * ID, calculate pay, and explore Week 3 OOP concepts.
 *******************************************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ABSTRACTION:
        // Employee is an abstract class, so we cannot create
        // an Employee object directly.
        //
        // However, Employee references can store objects
        // created from concrete employee subclasses.
        ArrayList<Employee> employees = new ArrayList<>();

        // COMPOSITION:
        // Each employee contains an Address object.
        Address address1 = new Address(
                "123 Main Street", "Fairfax", "VA", "22030");

        Address address2 = new Address(
                "456 Oak Avenue", "Manassas", "VA", "20110");

        Address address3 = new Address(
                "789 Park Road", "Alexandria", "VA", "22314");

        // PARAMETERIZED CONSTRUCTORS:
        // Create realistic employee objects using the
        // constructors provided by each subclass.
        HourlyEmployee hourlyEmployee = new HourlyEmployee(
                101, "Sarah", "Johnson", "Customer Service",
                address1, 25.00, 40);

        SalariedEmployee salariedEmployee = new SalariedEmployee(
                102, "Michael", "Smith", "Administration",
                address2, 72000.00);

        CommissionEmployee commissionEmployee =
                new CommissionEmployee(
                        103, "Emily", "Davis", "Sales",
                        address3, 2000.00, 10000.00, 0.05);

        employees.add(hourlyEmployee);
        employees.add(salariedEmployee);
        employees.add(commissionEmployee);

        // INTERFACE DEMONSTRATION:
        // Payable references can hold different employee types.
        ArrayList<Payable> payableEmployees = new ArrayList<>();

        payableEmployees.add(hourlyEmployee);
        payableEmployees.add(salariedEmployee);
        payableEmployees.add(commissionEmployee);

        // DISPLAY WEEK 3 ASSIGNMENT INFORMATION.
        System.out.println();
        System.out.println("==========================================");
        System.out.println("       EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("==========================================");
        System.out.println("Student: Anosha Naseri");
        System.out.println("Course: C330L");
        System.out.println("Week: 3");
        System.out.println(
                "Assignment: Abstraction, Constructors, & Access Specifiers");
        System.out.println();
        System.out.println("Welcome to the Employee Management System!");
        System.out.println("Use the menu to view employee information,");
        System.out.println("calculate pay, and demonstrate OOP concepts.");
        System.out.println("Enter a menu number to make your selection.");
        System.out.println();

        boolean running = true;

        // USER INTERACTION:
        // Continue displaying the menu until the user exits.
        while (running) {

            System.out.println("========== MAIN MENU ==========");
            System.out.println("1. View All Employees");
            System.out.println("2. View Hourly Employees");
            System.out.println("3. View Salaried Employees");
            System.out.println("4. View Commission Employees");
            System.out.println("5. View Employee by ID");
            System.out.println("6. Demonstrate Polymorphism");
            System.out.println("7. Demonstrate Week 3 OOP Concepts");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            // INPUT VALIDATION:
            // Read the user's choice as text to avoid
            // InputMismatchException.
            String choice = scanner.nextLine().trim();
            System.out.println();

            switch (choice) {

                case "1":
                    System.out.println("===== ALL EMPLOYEES =====");

                    for (Employee employee : employees) {
                        System.out.println(employee);
                        System.out.println("-------------------------");
                    }
                    break;

                case "2":
                    System.out.println("===== HOURLY EMPLOYEES =====");

                    for (Employee employee : employees) {
                        if (employee instanceof HourlyEmployee) {
                            System.out.println(employee);
                            System.out.println("-------------------------");
                        }
                    }
                    break;

                case "3":
                    System.out.println("===== SALARIED EMPLOYEES =====");

                    for (Employee employee : employees) {
                        if (employee instanceof SalariedEmployee) {
                            System.out.println(employee);
                            System.out.println("-------------------------");
                        }
                    }
                    break;

                case "4":
                    System.out.println("===== COMMISSION EMPLOYEES =====");

                    for (Employee employee : employees) {
                        if (employee instanceof CommissionEmployee) {
                            System.out.println(employee);
                            System.out.println("-------------------------");
                        }
                    }
                    break;

                case "5":
                    System.out.print("Enter Employee ID: ");
                    String idInput = scanner.nextLine().trim();

                    try {
                        int employeeId = Integer.parseInt(idInput);
                        boolean found = false;

                        for (Employee employee : employees) {
                            if (employee.getEmployeeId() == employeeId) {
                                System.out.println(
                                        "===== EMPLOYEE DETAILS =====");
                                System.out.println(employee);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println(
                                    "No employee found with ID "
                                    + employeeId);
                        }

                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid ID. Please enter a whole number.");
                    }
                    break;

                case "6":
                    System.out.println(
                            "===== POLYMORPHISM DEMONSTRATION =====");
                    System.out.println();

                    // POLYMORPHISM:
                    // Each Payable reference calls the appropriate
                    // calculatePay() implementation.
                    for (int i = 0; i < payableEmployees.size(); i++) {

                        Payable payable = payableEmployees.get(i);
                        Employee employee = employees.get(i);

                        System.out.println(
                                "Employee: "
                                + employee.getFirstName() + " "
                                + employee.getLastName());

                        System.out.println(
                                "Employee Type: "
                                + employee.getClass().getSimpleName());

                        System.out.printf(
                                "Calculated Pay: $%.2f%n",
                                payable.calculatePay());

                        if (employee instanceof HourlyEmployee) {
                            System.out.println(
                                    "Pay Basis: Hours worked");
                        } else if (employee instanceof SalariedEmployee) {
                            System.out.println(
                                    "Pay Basis: Monthly salary");
                        } else if (employee instanceof CommissionEmployee) {
                            System.out.println(
                                    "Pay Basis: Base salary plus commission");
                        }

                        System.out.println("-------------------------");
                    }
                    break;

                case "7":
                    System.out.println(
                            "===== WEEK 3 OOP DEMONSTRATION =====");
                    System.out.println();

                    // ABSTRACTION:
                    // Employee is abstract and cannot be
                    // instantiated directly.
                    System.out.println("1. ABSTRACTION");
                    System.out.println(
                            "Employee is an abstract superclass.");
                    System.out.println(
                            "Its subclasses implement calculatePay().");

                    // Demonstrate calling an abstract method
                    // through an Employee reference.
                    for (Employee employee : employees) {
                        System.out.printf(
                                "%s %s: $%.2f%n",
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.calculatePay());
                    }

                    System.out.println();

                    // OVERLOADED CONSTRUCTORS:
                    // Create sample objects using constructors
                    // with fewer parameters.
                    System.out.println("2. OVERLOADED CONSTRUCTORS");

                    Address sampleAddress = new Address(
                            "Fairfax", "VA", "22030");

                    HourlyEmployee newHourly = new HourlyEmployee(
                            104, "David", "Wilson", "Support",
                            sampleAddress, 22.00);

                    SalariedEmployee newSalaried = new SalariedEmployee(
                            105, "Jessica", "Brown", "Human Resources",
                            sampleAddress);

                    CommissionEmployee newCommission =
                            new CommissionEmployee(
                                    106, "Daniel", "Lee", "Sales",
                                    sampleAddress, 1800.00);

                    System.out.println(
                            "Hourly Employee (default hours = 0):");
                    System.out.println(newHourly);
                    System.out.println();

                    System.out.println(
                            "Salaried Employee (default salary = 0):");
                    System.out.println(newSalaried);
                    System.out.println();

                    System.out.println(
                            "Commission Employee (default sales = 0):");
                    System.out.println(newCommission);
                    System.out.println();

                    // ACCESS SPECIFIERS:
                    // Private fields cannot be accessed directly.
                    // Public getter and setter methods provide
                    // controlled access.
                    System.out.println("3. ACCESS SPECIFIERS");

                    System.out.println(
                            "Employee fields are private.");
                    System.out.println(
                            "Public getters and setters provide access.");
                    System.out.println(
                            "The Employee constructor is protected.");

                    System.out.println(
                            "Original hourly rate: $"
                            + String.format(
                                    "%.2f", newHourly.getHourlyRate()));

                    newHourly.setHourlyRate(24.00);

                    System.out.println(
                            "Updated hourly rate: $"
                            + String.format(
                                    "%.2f", newHourly.getHourlyRate()));

                    System.out.println();
                    System.out.println(
                            "Week 3 concepts demonstrated successfully.");
                    break;

                case "8":
                    System.out.println(
                            "Thank you for using the Employee Management System!");
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid selection. Please enter a number from 1 to 8.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}

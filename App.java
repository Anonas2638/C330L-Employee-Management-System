
/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/15/2026
 * Assignment: C330L Week 2 Course Project
 * Title: Software Design, Interfaces, and Polymorphism
 *
 * Description:
 * This application demonstrates object-oriented programming
 * concepts through an Employee Management System.
 *
 * It uses inheritance for different employee types,
 * composition through Address objects, and the Payable
 * interface to demonstrate polymorphism in pay calculations.
 *
 * The application provides a console menu with input
 * validation and continues until the user chooses to exit.
 *******************************************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Store employees using their common superclass.
        ArrayList<Employee> employees = new ArrayList<>();

        // COMPOSITION:
        // Each employee contains an Address object.
        Address address1 = new Address(
                "123 Main Street", "Fairfax", "VA", "22030");

        Address address2 = new Address(
                "456 Oak Avenue", "Manassas", "VA", "20110");

        Address address3 = new Address(
                "789 Park Road", "Alexandria", "VA", "22314");

        // INHERITANCE:
        // Different employee types extend the Employee class.
        HourlyEmployee hourlyEmployee = new HourlyEmployee(
                101, "Sarah", "Johnson", "Customer Service",
                address1, 25.00, 40);

        SalariedEmployee salariedEmployee = new SalariedEmployee(
                102, "Michael", "Smith", "Administration",
                address2, 72000.00);

        CommissionEmployee commissionEmployee = new CommissionEmployee(
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

        // Display Week 2 assignment information.
        System.out.println();
        System.out.println("==========================================");
        System.out.println("       EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("==========================================");
        System.out.println("Anosha Naseri");
        System.out.println("C330L - Week 2 Project");
        System.out.println("Software Design, Interfaces, and Polymorphism");
        System.out.println();
        System.out.println("Welcome to the Employee Management System!");
        System.out.println("Use the menu to view employee information");
        System.out.println("and demonstrate employee pay calculations.");
        System.out.println("Enter a menu number to make your selection.");
        System.out.println();

        boolean running = true;

        // USER INTERACTION:
        // Keep displaying the menu until the user exits.
        while (running) {

            System.out.println("========== MAIN MENU ==========");
            System.out.println("1. View All Employees");
            System.out.println("2. View Hourly Employees");
            System.out.println("3. View Salaried Employees");
            System.out.println("4. View Commission Employees");
            System.out.println("5. View Employee by ID");
            System.out.println("6. Demonstrate Polymorphism");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            // INPUT VALIDATION:
            // Reading text avoids InputMismatchException.
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
                    // Every object is accessed through Payable.
                    // Java selects the correct calculatePay()
                    // method for each employee type.
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
                            "Thank you for using the Employee Management System!");
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid selection. Please enter a number from 1 to 7.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}

/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/08/2026
 * Assignment: C330L Week 1 Project
 * Title: Inheritance, Composition, and User Interactions
 *
 * Description:
 * This is the main application for the Employee Management System.
 * It displays a welcome message, accepts user input through a
 * console menu, and displays realistic employee information.
 *
 * The application demonstrates inheritance using different
 * employee types and composition using employee Address objects.
 *******************************************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Store sample employee objects in a list
        ArrayList<Employee> employees = new ArrayList<>();

        // COMPOSITION: Each Employee contains an Address object.
        Address address1 = new Address(
                "123 Main Street", "Fairfax", "VA", "22030");

        Address address2 = new Address(
                "456 Oak Avenue", "Manassas", "VA", "20110");

        Address address3 = new Address(
                "789 Park Road", "Alexandria", "VA", "22314");

        // INHERITANCE: These child classes extend Employee.
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

        // Display assignment information and welcome message
        System.out.println();
        System.out.println("==========================================");
        System.out.println("    EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("==========================================");
        System.out.println("Anosha Naseri");
        System.out.println("C330L - Week 1 Project");
        System.out.println("Inheritance, Composition, and User Interactions");
        System.out.println();
        System.out.println("Welcome to the Employee Management System!");
        System.out.println("Use the menu to view employee information.");
        System.out.println("Enter the number of your selection.");
        System.out.println();

        boolean running = true;

        // USER INTERACTION: Continue until the user selects Exit.
        while (running) {

            System.out.println("========== MAIN MENU ==========");
            System.out.println("1. View All Employees");
            System.out.println("2. View Hourly Employees");
            System.out.println("3. View Salaried Employees");
            System.out.println("4. View Commission Employees");
            System.out.println("5. View Employee by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

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
                                System.out.println("===== EMPLOYEE DETAILS =====");
                                System.out.println(employee);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println(
                                    "No employee found with ID " + employeeId);
                        }

                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid ID. Please enter a whole number.");
                    }
                    break;

                case "6":
                    System.out.println("Thank you for using the Employee Management System!");
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid selection. Please enter a number from 1 to 6.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}
# Employee Management System

**Developer:** Anosha Naseri  
**Programming Language:** Java  
**Database:** SQLite  
**Application Type:** Console-Based Employee Management Application

## Project Description

The Employee Management System is a Java-based console application designed to manage employee records and compensation information. The application supports hourly, salaried, and commission-based employees, allowing users to add, view, search, update, and delete employee records.

The project demonstrates object-oriented programming principles, including inheritance, abstraction, interfaces, composition, polymorphism, constructors, and encapsulation. SQLite is used to store employee information persistently.

## Project Features

- Add new hourly, salaried, and commission employees.
- View all employees or filter by employee type.
- Search for employees using their unique employee ID.
- Update existing employee information.
- Delete employee records with confirmation.
- Calculate employee compensation based on employee type.
- Store and retrieve employee information using SQLite.
- Validate user input and display helpful error messages.
- Demonstrate object-oriented programming concepts.
- Continue operating until the user chooses to exit.

## Object-Oriented Programming Concepts

**Inheritance:** The `HourlyEmployee`, `SalariedEmployee`, and `CommissionEmployee` classes extend the abstract `Employee` superclass.

**Abstraction:** The abstract `Employee` class defines common employee information and requires subclasses to implement `calculatePay()`.

**Interface:** The `Payable` interface establishes a common method for calculating employee compensation.

**Composition:** Each employee contains an `Address` object that stores address information.

**Polymorphism:** Different employee subclasses implement `calculatePay()` according to their compensation structures. The application demonstrates this through shared `Employee` and `Payable` references.

**Constructors:** Parameterized and overloaded constructors initialize employee and address objects.

**Encapsulation:** Private fields and public getter and setter methods protect employee information and validate input.

## Database Implementation

The application uses SQLite through JDBC to store employee records in an `employees` table.

The database supports the following CRUD operations:

- **Create:** Add employee records.
- **Read:** Retrieve all employees or search by ID.
- **Update:** Modify existing employee records.
- **Delete:** Remove employee records.

The database stores employee identification, names, departments, addresses, employee types, and compensation information.

## Project Files

| File | Purpose |
|---|---|
| `App.java` | Main application and interactive console menu |
| `Employee.java` | Abstract employee superclass |
| `HourlyEmployee.java` | Hourly employee information and pay calculation |
| `SalariedEmployee.java` | Salaried employee information and monthly pay calculation |
| `CommissionEmployee.java` | Commission employee information and pay calculation |
| `Address.java` | Employee address information and composition |
| `Payable.java` | Interface defining employee pay calculation |
| `EmployeeDatabase.java` | SQLite database connection and CRUD operations |

## Technologies Used

- Java
- SQLite
- JDBC
- Visual Studio Code
- Git and GitHub
- Object-Oriented Programming

## Running the Application

1. Install a compatible Java Development Kit.
2. Download or clone the project repository.
3. Ensure the SQLite JDBC driver is available.
4. Open the project in Visual Studio Code or another Java development environment.
5. Configure the SQLite JDBC dependency on the classpath.
6. Compile the Java source files.
7. Run the `App` class.
8. Use the numbered menu to manage employee records.
9. Select option 11 to exit.

The application creates its SQLite database table if it does not already exist.

## Project Demonstration

### Employee Management System — Final Project Video

**Developer:** Anosha Naseri  
**Application:** Employee Management System  
**Technologies:** Java, SQLite, JDBC  
**Video Duration:** Approximately 7 minutes

**Watch the Final Project Demonstration:**

[Employee Management System — Java & SQLite Demonstration](https://youtu.be/WBjMAfWKndc))

### Video Overview

This demonstration provides a walkthrough of the completed Employee Management System, including the Java source code, object-oriented programming concepts, and SQLite database functionality.

The video covers:

- **Application Overview:** Introduction to the Employee Management System and its features.
- **Object-Oriented Programming:** Demonstration of inheritance, abstraction, interfaces, composition, polymorphism, constructors, and encapsulation.
- **Employee Management:** Viewing, searching, and filtering hourly, salaried, and commission-based employees.
- **Database Operations:** Adding, updating, retrieving, and deleting employee records using SQLite.
- **Compensation Calculations:** Demonstrating how each employee type calculates pay differently.
- **Application Navigation:** Using the interactive console menu and exiting the application.

The demonstration highlights how Java object-oriented programming and SQLite database integration work together to create a functional employee management application.

---

## Final Project Summary

### Project Overview

The Employee Management System was developed throughout the five-week course project to demonstrate the practical application of object-oriented programming and database management using Java.

The application combines employee information management, compensation calculations, an interactive console interface, and SQLite database storage into one program.

### Development Process

The project was completed in phases:

**Week 1 — Inheritance and Composition:** Created the employee class hierarchy and introduced the Address class to organize shared employee information.

**Week 2 — Interfaces and Polymorphism:** Developed the software design and implemented common behaviors for different employee types.

**Week 3 — Abstraction, Constructors, and Access Specifiers:** Implemented an abstract superclass, overloaded constructors, private fields, and controlled access through methods.

**Week 4 — Database Integration:** Connected the application to SQLite and implemented database operations for creating, reading, updating, and deleting employee records.

**Week 5 — Final Application:** Combined the previous development phases into a complete employee management application and prepared the final documentation and demonstration.

### What Went Well

One successful part of the project was organizing employee information into separate classes. Using inheritance reduced repeated code, while polymorphism allowed each employee type to calculate compensation differently through a shared method.

The SQLite integration also provided a practical way to save and retrieve employee information instead of relying only on temporary program data.

### Challenges and Improvements

One challenge was integrating the object-oriented class structure with database operations. Different employee types require different compensation fields, so the application needed to store and reconstruct the appropriate subclass when retrieving records.

Another important consideration was user input validation. The console application uses validation methods to handle invalid numerical input and prevent empty required text fields.

Future improvements could include a graphical user interface, employee reporting tools, more advanced search options, and additional automated testing.

### Requirements Completed

The final application demonstrates the required object-oriented concepts, including interfaces, abstract classes, inheritance, composition, polymorphism, constructors, and access specifiers.

It also includes SQLite database operations, an interactive console menu that continues until the user exits, and source-code comments explaining the implementation.

### Skills Developed

This project provided practical experience in Java programming, object-oriented software design, SQLite database integration, JDBC, input validation, debugging, application documentation, and GitHub version control.

### Conclusion

The Employee Management System demonstrates how object-oriented programming and database technology can work together to create a structured and maintainable application.

Completing the project strengthened my understanding of Java application development and provided a portfolio project that can be expanded with additional functionality in the future.

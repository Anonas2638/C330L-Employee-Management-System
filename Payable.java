
/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/21/2026
 * Assignment: C330L Week 3 Course Project
 * Title: Abstraction, Constructors, & Access Specifiers
 *
 * Description:
 * This interface defines a common contract for calculating
 * employee pay in the Employee Management System.
 *
 * It demonstrates abstraction by declaring a method
 * without providing its implementation.
 *
 * The abstract Employee class implements this interface,
 * while HourlyEmployee, SalariedEmployee, and
 * CommissionEmployee provide their own pay calculations.
 *
 * This interface supports abstraction and polymorphism.
 *******************************************************************/

// ABSTRACTION:
// The Payable interface defines a required behavior
// without specifying how the calculation is performed.
//
// ACCESS SPECIFIER:
// The interface is public so other classes can use it.

public interface Payable {

    // INTERFACE METHOD:
    // Interface methods are implicitly public and abstract.
    // Each concrete employee subclass must provide
    // its own implementation of calculatePay().

    double calculatePay();

}

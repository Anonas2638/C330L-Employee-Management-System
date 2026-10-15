
/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/15/2026
 * Assignment: C330L Week 2 Course Project
 *
 * Description:
 * This interface defines a common method for calculating
 * employee pay. Different employee types can implement
 * this method using their own payment calculations.
 *
 * This interface will help demonstrate polymorphism
 * in the Employee Management Application.
 *******************************************************************/

// INTERFACE DEMONSTRATION:
// Defines a common behavior for different employee types.

public interface Payable {

    // Calculates the pay for an employee.
    double calculatePay();

}

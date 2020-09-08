/* Program Name: RGG_LoanPayable.java
 * Purpose: interface which holds constant value and function to be implemented in other
 * class which implements it
 * Coder: Ramon Gnan Garcia - 0926596
 * Date: Apr 04, 2020
 */

package payables;

public interface RGG_LoanPayable
{
    // variable declaration
    final double ANNUAL_RATE_TO_MONTLY_RATE = (double)1/1200;

    /*
     * Method Name: calculateLoanPayment()
     * Purpose: abstract method to be later implemented
     * Accepts: double, double, int
     * Returns: double
     * Date: Apr 12, 2020
     */
    public abstract double calculateLoanPayment(double oslOrCsl, double annualPrimeInterestRate, int amortPeriod);

}//end of class

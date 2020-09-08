/* Program Name: Calculations.java
 * Purpose: calculate loan payment with given parameters
 * Coder: Ramon Gnan Garcia - 0926596
 * Date: Apr 12, 2020
 */

package payables;

public class Calculations implements RGG_LoanPayable
{
    // constructor
    public Calculations()
    {
    }

    /*
     * Method Name: calculateLoanPayment()
     * Purpose: calculate loan payment for given values
     * Accepts: double, double, int
     * Returns: double
     * Date: Apr 12, 2020
     */
    public double calculateLoanPayment(double oslOrCsl, double annualPrimeInterestRate, int amortPeriod)
    {
        return (oslOrCsl) * (annualPrimeInterestRate) * Math.pow((1 + annualPrimeInterestRate), amortPeriod) /
            (Math.pow(1 + annualPrimeInterestRate, amortPeriod) - 1);
    }


}//end of class

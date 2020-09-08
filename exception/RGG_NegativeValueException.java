/* Program Name: RGG_NegativeValueException.java
 * Purpose: custom exception class to throw exception if a negative value is given as
 * parameter in loan amount
 * Coder: Ramon Gnan Garcia - 0926596
 * Date: Apr 12, 2020
 */

package exception;

public class RGG_NegativeValueException extends Exception
{
    private static final long serialVersionUID = 1L;

    // constructor
    public RGG_NegativeValueException()
    {
        super("Negative value exception triggered");
    }

    /*
     * Method Name: checkLoanAmount()
     * Purpose: method to check if the loan amount is greater than 0(zero), if not, throw
     * a new Exception
     * Accepts: double
     * Returns: void
     * Date: Apr 12, 2020
     */
    public static void checkLoanAmount(double amount) throws RGG_NegativeValueException
    {
        if(amount < 0)
            throw new RGG_NegativeValueException();
    }


}//end of class

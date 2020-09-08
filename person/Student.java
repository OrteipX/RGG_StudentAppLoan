/* Program Name: Student.java
 * Purpose: this class holds students values
 * Coder: Ramon Gnan Garcia - 0926596
 * Date: Apr 04, 2020
 */

package person;

import java.text.DecimalFormat;

public class Student
{
    // variable declaration
    private String studentID, surname, middleName, firstName, aptNumber, streetNumber,
            streetName, city, province, postalCode;
    private double cslLoanAmount, oslLoanAmount;
    private DecimalFormat frmNum  = new DecimalFormat("$#0.00");


    // constructor multi args
    public Student(String studentID, String surname, String middleName, String firstName,
            String aptNumber, String streetNumber, String streetName, String city,
            String province, String postalCode, double cslLoanAmount, double oslLoanAmount)
    {
        this.studentID = ("0000000" + studentID).substring(studentID.length());
        this.surname = surname;
        this.middleName = middleName;
        this.firstName = firstName;
        this.aptNumber = aptNumber;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.cslLoanAmount = cslLoanAmount;
        this.oslLoanAmount = oslLoanAmount;
    }

    // setter - surname
    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    // setter - middleName
    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    // setter - firstName
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    // setter - aptNumber
    public void setAptNumber(String aptNumber)
    {
        this.aptNumber = aptNumber;
    }

    // setter - streetNumber
    public void setStreetNumber(String streetNumber)
    {
        this.streetNumber = streetNumber;
    }

    // setter - streetName
    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    // setter - city
    public void setCity(String city)
    {
        this.city = city;
    }

    // setter - province
    public void setProvince(String province)
    {
        this.province = province;
    }

    // setter - porstalCode
    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    // setter - cslLoanAmount
    public void setCslLoanAmount(double cslLoanAmount)
    {
        this.cslLoanAmount = cslLoanAmount;
    }

    // setter - oslLoanAmount
    public void setOslLoanAmount(double oslLoanAmount)
    {
        this.oslLoanAmount = oslLoanAmount;
    }

    // getter - studentID
    public String getStudentID()
    {
        return studentID;
    }

    // getter - surname
    public String getSurname()
    {
        return surname;
    }

    // getter - middleName
    public String getMiddleName()
    {
        return middleName;
    }

    // getter - firstName
    public String getFirstName()
    {
        return firstName;
    }

    // getter - aptNumber
    public String getAptNumber()
    {
        return aptNumber;
    }

    // getter - streetNumber
    public String getStreetNumber()
    {
        return streetNumber;
    }

    // getter - streetName
    public String getStreetName()
    {
        return streetName;
    }

    // getter - city
    public String getCity()
    {
        return city;
    }

    // getter - province
    public String getProvince()
    {
        return province;
    }

    // getter - postalCode
    public String getPostalCode()
    {
        return postalCode;
    }

    // getter - cslLoanAmount
    public double getCslLoanAmount()
    {
        return cslLoanAmount;
    }

    // getter - oslLoanAmount
    public double getOslLoanAmount()
    {
        return oslLoanAmount;
    }

    public void setStudentID(String studentID)
    {
        this.studentID = studentID;
    }


    /*
     * Method Name: toString()
     * Purpose: overridden method to print student data
     * Accepts: nothing
     * Returns: String
     * Date: Apr 04, 2020
     */
    @Override
    public String toString()
    {
        return "Student Name: "
            + surname
            + ", "
            +
            firstName
            +
            " "
            + middleName
            + "\nStudent Number: "
            + ("0000000" + studentID).substring(studentID.length())
            + "\nCSL Amount is "
            + frmNum.format(cslLoanAmount)
            + "\nOSL Amount is "
            +
            frmNum.format(oslLoanAmount);
    }

}//end of class

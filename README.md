# OrteipX

## Canada Student Loan

This project is a prototype GUI student loan calculator app to let them see how modifying their repayment schedules would affect the loan cost in terms of the amount of interest that the student would pay.

NOTE: the current Ontario Student Assistance Program is being modified by the current provincial government, so actual repayment rules are in a state of flux. This app will follow fictional repayment rules created for this project only.

## Additional Information

### Formula for Calculating the Monthly Payments:

The interest rate on a Canada Student Loan is prime rate plus 2.5% (in other words if the
primeinterest rate is 4.25%, the interest rate on a CSL is (4.25 + 2.5) = 6.75%.
The interest on an Ontario Student Loan is prime rate plus 1.0% (in other words if the prime interest rate is 4.25%, the interest rate on an OSL is ( 4.25 + 1.0) = 5.25%.
The formula for calculating the monthly payment P on a loan of amount A with a monthly interest rate of i over an amortization period of N months is:

    P=A*i*(1+i)N /((1+i)N –1)

IMPORTANT! The above formula uses a monthly interest rate expressed as a decimal equivalent rate. To obtain this, you need to multiply the annual interest rate by 1/1200.

### Canada Student Loan (CSL):

    A = $2500.00        The loan amount is $2500.
    
    i = 0.005625        The prime interest rate is 4.25%. The CSL uses an interest                    rate of prime plus 2.5, which would be 6.75%. To convert                      this annual rate to a monthly interest rate expressed as a                    decimal we multiply 6.75 * 1/1200 to get a monthly rate of                    0.005625.
    
    N = 60              The amortization period is 60 months.
    
Step by step calculations: 

    P   = A * i * (1 + i)^N / ((1 + i)^N - 1)
        = 2500 * 0.005625 * (1 + 0.005625)^60 / ( (1 + 0.005625)^60 – 1)
        = 2500 * 0.005625 * (1.40011493) / (0.40011493)
        = 49.20865
        = $49.21 per month (rounded)

### Ontario Student Loan (OSL):

    A = $1500.00        The loan amount is $1500.
    
    i = 0.004375        The OSL uses an interest rate of prime plus 1.0, which is                     5.25%. To convert this to a monthly interest rate expressed                   as a decimal this would be 5.25 * 1/1200 or 0.004375.
    
    N = 60              The amortization period is 60 months.
    
Step by step calculations: 

    P   = A * i * (1 + i)^N / ((1 + i)^N - 1)
        = 1500 * 0.004375 * (1 + 0.004375)^60 / ((1 + 0.004375)^60 - 1)
        = 1500 * 0.004375 * (1.299432266) / (0.299432266)
        = 28.47897576
        = $28.48 per month (rounded)

Total monthly payment is the sum of the two individual loan payment amounts.

Therefore the monthly payments are $49.21 for the CSL and $28.48 for the OSL for a combined monthly payment of $77.69 on an amortization period of 60 months.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update the tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)

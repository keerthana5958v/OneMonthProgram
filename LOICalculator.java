package org.example;

class LOICalculator extends Interest{
    LOICalculator(int tenure, long principalAmount, float interestRate){
        setTenure(tenure);
        setPrincipalAmount(principalAmount);
        setInterestRate(interestRate);
    }

    LOICalculator(){}
    /*
    calculate credit loss

    The total amount formula in case of simple interest can also be written as:

A = P(1 + RT)
     */
    void calculateLoanAmount(long principalAmount, float interestRate, int tenure){
        setROI(principalAmount*(1 + (interestRate * tenure)));
    }
    void calculateLoanAmount(){
        setROI(getPrincipalAmount()*(1 + ( getInterestRate() * getTenure())));
    }
}
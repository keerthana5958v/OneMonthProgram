package org.example;

class ROICalculator extends Interest{
    ROICalculator(){}
    ROICalculator(int tenure, long principalAmount, float interestRate){
        setTenure(tenure);
        setPrincipalAmount(principalAmount);
        setInterestRate(interestRate);
    }

    public void calculateRD(long principalAmount, float interestRate, float tenure){
        setROI(Math.pow(principalAmount*((1 + interestRate/12)), (12*tenure)));
    }
    public void calculateRD(){
        setROI(Math.pow(getPrincipalAmount()*((1 + getInterestRate()/12)), (12*getTenure())));
    }
    public void calculateFD(long principalAmount,float interestRate,int tenure){
        setROI(principalAmount * (1 + ( interestRate * tenure)));
    }
    public void calculateFD(){
        setROI(getPrincipalAmount() * (1 + ( getInterestRate() * getTenure())));
    }

}
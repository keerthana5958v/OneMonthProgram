package org.example;

class Interest{
    /*
    get tenure , principal amount , interest rate,
     */
    private double ROI = 0;

    private int tenure = 1; //default value
    private long principalAmount = 1000;
    private float interestRate = 8;
    //////////////////////////////////////////////////////////////////
    public int getTenure(){
        return this.tenure;
    }
    public void setTenure(int tenure){
        this.tenure= tenure;
    }
    public long getPrincipalAmount(){
        return this.principalAmount;
    }
    public void setPrincipalAmount(long principalAmount){
        this.principalAmount = principalAmount;
    }
    public float getInterestRate(){
        return this.interestRate;
    }
    public void setInterestRate(float interestRate){
        this.interestRate = interestRate;
    }
    public double getROI(){
        return this.ROI;
    }
    public void setROI(double ROI){
        this.ROI = ROI;
    }

    Interest(){}
//    Interest(int tenure, long principalAmount, float interestRate){
//        this.tenure = tenure;
//        this.principalAmount = principalAmount;
//        this.interestRate = interestRate;
//    }
}

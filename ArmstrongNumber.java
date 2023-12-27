package org.example;

public class ArmstrongNumber {
    int getNumberOfDigits(int num){
        int noOfDigits = 0;
        int tem = 1;
        while(num/tem > 0){
            noOfDigits++;
            tem *= 10;
        }
        return (noOfDigits);
    }
    int armstrongValue(int num){
        int powerSumOfDigits = 0;
        int temp = 10;
        int count = 0;
        do{
            int digit = ( (num%temp) - (num%(temp/10)) ) /(temp/10);
            powerSumOfDigits += (int) (Math.pow( digit, getNumberOfDigits(num)));
            temp *= 10;
            count++;
        }

        while(count < getNumberOfDigits(num));
//        System.out.println(powerSumOfDigits);
        return powerSumOfDigits;
    }
    boolean isPalindrome(int num){
        return (num==armstrongValue(num));
    }

    public static void main(String []args){
        int num = 24;
        ArmstrongNumber obj = new ArmstrongNumber();
        boolean isPalindrome = obj.isPalindrome(num);
        System.out.println(isPalindrome);
    }

}

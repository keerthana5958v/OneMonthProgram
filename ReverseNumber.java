package org.example;

public class ReverseNumber {
    long sumOfDigits(long num){
        long temp = 0 ;
        long sum = 0;
        while(num!=0){
            temp = num % 10;
            num = num / 10;
            sum+=temp;
        }
        return sum;
    }
    long reverseLong1(long num){
        long temp1 = 10;
        long temp2 = 1;
        long revNum = 0;
        while(temp2<num){
            temp2 = temp2 * 10;
        }
        while(num>0){
            revNum += temp2*(num % temp1);
            temp2 = temp2/10;
            num = num/10;
        }
        revNum/=10;
        return (revNum);
    }
    long reverseLong2(long num){
        long revNum = 0;
        while(num>0){
            revNum += num % 10;
            num = num / 10;
            revNum = revNum * 10;
        }
        revNum/=10;
        return (revNum);
    }

}

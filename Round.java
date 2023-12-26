package org.example;

import java.math.BigInteger;
import java.util.Scanner;

public class Round {
    double roundOff(double num , int round){
//        double num = 36.6;
//        int round = 2;
        int numberOfDecimalValues = 0;
        if(num % 10 != 0) {
            while (num % 10 != 0) {
                num = num * 10;
                numberOfDecimalValues++;
            }
            num = num / 10;
            numberOfDecimalValues--;
        }
//        System.out.println(num);
        long number = (long)num;
        //
        int digitToRoundedNumber = (int) ((((number % (Math.pow(10,round))) - (number % (Math.pow(10,round-1))))));
//        System.out.println("    "+digitToRoundedNumber);

        int beforeRound = (int) (num/(Math.pow(10,round) ));
        beforeRound = (int)(beforeRound * (Math.pow(10,round)));

//        System.out.println(beforeRound); // == 300

        int atDigit = (int) (digitToRoundedNumber/(Math.pow(10, round-1)));
//        System.out.println("at digit "+ atDigit);
        if(atDigit < 5){
//            System.out.println("inside if");
            num = (beforeRound + digitToRoundedNumber) / Math.pow(10,numberOfDecimalValues);
        }
        else {
            beforeRound =(int) (beforeRound + (Math.pow(10,round) ));
//            System.out.println("inside else");
            num = (beforeRound + digitToRoundedNumber) / Math.pow(10,numberOfDecimalValues) ;
        }
//        System.out.println(num);
        return num;
    }

    public static void main(String[] args) {

        Round obj = new Round();
        double roundNum = obj.roundOff(104.3 , 1);
        System.out.println(roundNum);
    }
}

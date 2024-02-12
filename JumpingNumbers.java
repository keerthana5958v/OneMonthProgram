package org.example;

import java.util.Scanner;

/*
    Program 3:
    A number is called a jumping number if it comes under the below criteria:
    1. All of its adjacent digits should differ by 1.
    2. The first and the last digits should differ by 1.

    For example, 8789 is a jumping number whereas 234 and 121 are not.
    A single digit number is considered as jumping number.

    Writer a program to find all the jumping numbers between the give range.

    Input: 4000, 5000
    Output: 4323, 4343, 4345, 4543, 4545, 4565

    Input: 0, 21
    Output: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 21

    Input: 100, 150
    Output: No jumping numbers found
 */
public class JumpingNumbers {
    boolean checkAdjacentDigits(int num){
        int currentDigit;
        int nextDigit;
        while(num > 10){
            currentDigit = num%10;
            nextDigit = ((num % 100) - currentDigit)/10;
            num = num / 10;
            if(!(currentDigit == nextDigit-1 || currentDigit == nextDigit + 1)){
                return false;
            }
        }
        return true;
    }
    boolean checkExtremeNumbers(int num){
        if(num<=10)return true;
        int ones = num%10;
        int max;
        int temp = num;
        int numOfDigits = 1;
        while(temp>=10){
            temp = temp/10;
            numOfDigits++;
        }
        max = (int) ((num % Math.pow(10,numOfDigits) - num % Math.pow(10,numOfDigits-1)) / Math.pow(10,numOfDigits-1));
        return (ones == max-1 || ones == max + 1);
    }
    void printJumpingNumbers(int startRange, int endRange){
        System.out.println("Jumping numbers between "+ startRange + " and "+ endRange);
        String res= "";
        for(int i = startRange ; i <= endRange; i++){
            if(checkExtremeNumbers(i)&&checkAdjacentDigits(i))res+= i + " ";
        }
        if(res.isEmpty()){
            System.out.println("no available jumping numbers");
        }
        else System.out.println(res);
        System.out.println();
    }
    void printJumpingNumbers(int endRange){
        System.out.println("Jumping numbers till "+endRange);
        String res= "";
        for(int i = 0 ; i <= endRange; i++){
            if(checkExtremeNumbers(i)&&checkAdjacentDigits(i))res+= i + " ";
        }
        if(res.isEmpty()){
            System.out.println("no available jumping numbers");
        }
        else System.out.println(res);
        System.out.println();
    }


    public static void main(String[] args) {
        JumpingNumbers obj = new JumpingNumbers();
        obj.printJumpingNumbers(100);
        obj.printJumpingNumbers(100,150);
        obj.printJumpingNumbers(4000,5000);

    }


}

package org.example;

import java.util.Arrays;
import java.util.Scanner;

/*
Program 1:
Given an array of scores of a student for five subjects.
If the difference between score and the next multiple of 5 is less than 3,
then the result will be rounding off to next multiple of 5.
If the score is less than 35, then no round off occurs, the result will be as it is.

Example:
Input:
[47, 58, 32, 60, 79]

Output:
[47, 60, 32, 60, 80]
 */
public class ScoreRounder {
    int[] scores = new int[]{45,67,23,89,56,48,94};
    public static void main(String[] args) {
        ScoreRounder obj = new ScoreRounder();
        System.out.println("Original mark-->");
        System.out.println(Arrays.toString(obj.scores));
        System.out.println("\nRound off mark-->");
        System.out.print("[");
        for(int i = 0 ; i < obj.scores.length ; i++){
            if(i < obj.scores.length - 1) {
                System.out.print(obj.roundOffToCondition(obj.scores[i]) + ", ");
            }else {
                System.out.print(obj.roundOffToCondition(obj.scores[i]) + "]");
            }
        }
    }
    int getLastDigit(int num){
        return num%10;
    }
    int roundOffToCondition(int num){
        if(num>35) {
            if(num%5==0){
                return num;
            }
            else if (getLastDigit(num) > 2 && getLastDigit(num) < 5) {
                num = (num/10) ;
                num = num*10 + 5;
//                System.out.println("\t"+num);
                return num;
            }
            else if (getLastDigit(num) > 7 && getLastDigit(num) < 10) {
                num = (num / 10);
                num = num*10 + 10;
//                System.out.println("\t"+num);
                return num;
            }
        }

        return num;

    }

}

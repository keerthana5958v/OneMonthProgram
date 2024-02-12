package org.example;

import java.util.Scanner;

/*

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted
 into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of substrings
such that each substring contains exactly one unique digit. Then for each substring, say the number of digits,
 then say the digit. Finally, concatenate every digit.

For example, the saying and conversion for the digit string "3322251":

Given a positive integer n, return the nth term of the count-and-say sequence
 */
public class RepeatedNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input  --> ");
        long num = sc.nextLong();
        String numb = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numb.length() - 1 ; i++){
            int count = 1;
            while(numb.charAt(i) == numb.charAt(i+1)){
                i++;
                count++;
                if(i==numb.length()-1){
                    break;
                }
            }
            sb.append(count);
            sb.append(numb.charAt(i));
        }
        if(numb.charAt(numb.length()-2)!=numb.charAt(numb.length()-1)){
            sb.append(1);
            sb.append(numb.charAt(numb.length()-1));
        }
        System.out.println("Output --> "+sb);
    }
}
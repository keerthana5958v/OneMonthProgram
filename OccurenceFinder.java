package org.example;
/*
    Program 2:
    There is a string,of lowercase English letters that is repeated infinitely many times.
     Given an integer,find and print the number of letter a's in the first letters of the infinite string.

    Example:
    Input:
    s = "aba";
    n = 10;

    Output:
    7

    Explanation:
    The substring we consider is "abaabaabaa", the first  characters of the infinite string.
    There are 7 occurrences of the letter 'a' in the substring.
 */

import java.util.Scanner;

public class OccurenceFinder {
    String s = "aba";
    int length = 10;
    String createInfiniteString(String s, int length){
        if(length>s.length()){
            StringBuilder sb = new StringBuilder(s);
            for(int i = 0 ; i < (length/s.length()) ; i++){
                sb.append(s);
            }
            s = sb.toString();
            return s.substring(0,length);
        }
        return s.substring(0,length);
    }
    int findNoOfOccurrence(String s){
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == s.charAt(0))count++;
        }
        return count;
    }

    public static void main(String[] args) {
        OccurenceFinder obj = new OccurenceFinder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your String");
        String s = sc.nextLine();
        System.out.println("enter string length");
        int length = sc.nextInt();
        System.out.println("Output-->  "+obj.findNoOfOccurrence(obj.createInfiniteString(s,length)));
    }

}
//try it for a , 100000000000

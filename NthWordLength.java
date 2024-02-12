package org.example;

import java.util.Scanner;

/*
    Today's Programs
    Program 1:
    Write a program to find the length of the nth word in a given string, return  -1
    if there is no nth word in the given string.
    (The string contains any number of spaces).

    Input: s = "Hello World", n = 2
    Output: 5
    Explanation: The 2nd word is "World" and its length is 5.

    Input: s = "   fly me   to   the moon  " , n = 4
    Output: 3
    Explanation: The 4th word in the above string is "the" and its length is 3.

    Input: s = "Luffy is still joyboy" , n = 5
    Output: -1
    Explanation: There is no 5th word in the above string.
 */
public class NthWordLength {
    int nthWordLength(String str, int n){
        String[] arr = str.split(" ");
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(!arr[i].isEmpty()) {
                count++;
                if(count==n){
                    return (removeSpecialCharacters(arr[i]).length());
                }
            }
        }
        return -1;
    }
    String removeSpecialCharacters(String s){
        String specialCharacters = "!@#$%^&*()<>,./?";
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if(!(specialCharacters.contains(s.charAt(i)+""))) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your string");
        String str = sc.nextLine();
        System.out.println("enter the n value");
        int n = sc.nextInt();
        NthWordLength obj = new NthWordLength();
        System.out.println(obj.nthWordLength(str,n));

    }
}


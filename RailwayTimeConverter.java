package org.example;

import java.nio.charset.CodingErrorAction;
import java.util.Scanner;

/*
    Program 5:
    Write a program to convert time from 12-hour format to 24-hour format.

    Example 1:
    Input:
    02:30:00PM

    Output:
    14:30:00

    Example 2:
    Input:
    11:20:00AM

    Output:
    11:20:00

 */
public class RailwayTimeConverter {
    boolean isValidLength(String input){
        return input.length() == 10;
    }
    boolean hasBothColons(String input){
        if(isValidLength(input)){
            return ((input.charAt(2)) == ':' &&
                    ((input.charAt(5)))==':');
        }
        else return false;
    }
    boolean containsAllDigit(String input){
        StringBuilder sb = new StringBuilder(input.substring(0,input.length()-2));
        if(isValidLength(input)){
            if(hasBothColons(input)){
                sb.deleteCharAt(5);
                sb.deleteCharAt(2);
            }
            for(int i = 0 ; i < sb.length() ; i++){
                if(!Character.isDigit(sb.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    boolean isValidHourMinuteSecond(String input){
        int hour;
        int min;
        int sec;
        if(containsAllDigit(input)){
            hour = Integer.parseInt(input.substring(0,2));
//            System.out.println("\t"+hour);
            min = Integer.parseInt(input.substring(3,5));
//            System.out.println(min);
            sec = Integer.parseInt(input.substring(6,8));
//            System.out.println(sec);
            return (!(hour>12 || min > 59 || sec>59));
        }
        return false;
    }
    boolean isValidMeridiem(String input){
        if(isValidLength(input)){
            return (Character.toLowerCase((input.charAt(input.length()-1))) == 'm' &&
                    (Character.toLowerCase((input.charAt(input.length()-2))) == 'p' ||
                    (Character.toLowerCase((input.charAt(input.length()-2)))) == 'a') );
        }
        return false;
    }
    int isAmOrPm(String input){
        if(isValidLength(input)){
            if(Character.toLowerCase(input.charAt(8)) == 'a'){
                return 0;
            }
            if(Character.toLowerCase(input.charAt(8)) == 'p'){
                return 1;
            }
        }
        return -1;
    }
    boolean isValidInput(String input){
        if(!isValidLength(input)) {
            System.out.println("input is not proper length");
        }
        else if(!hasBothColons(input)){
            System.out.println("your input does not have both semi colon in proper place");
        }
        else if(!containsAllDigit(input)){
            System.out.println("your input is not proper");
        }
        else if(!isValidHourMinuteSecond(input)){
            System.out.println("the given time is not valid");
        }
        else if (!isValidMeridiem(input)) {
            System.out.println("enter if time is AM or PM");
        }
        else if(isAmOrPm(input) == -1){
            System.out.println("enter AM or PM");
        }
        else{
            return true;
        }
        return false;
    }
    String convertTime(String input){
        if(isAmOrPm(input)==0){
            return input.substring(0,input.length()-2);
        }
        else if(isAmOrPm(input)==1){
            int hour = Integer.parseInt(input.substring(0,2));
            return (hour+12)+input.substring(2,input.length()-2);
        }
        return "";
    }



    public static void main(String[] args) {
        System.out.println("Railway time converter");
        System.out.println("Sample input --> 02:30:12PM");

        RailwayTimeConverter obj = new RailwayTimeConverter();

        String input = "12:30:32pm";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("enter your input time");
            input = sc.nextLine();
        }while (!obj.isValidInput(input));
            System.out.println(obj.convertTime(input));

    }
}

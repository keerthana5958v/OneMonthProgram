package org.example;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

/*
Program 4:
Write a program to find the relative time.

Input:
03:50:00PM
If the current time is 04:00:00PM

Output:
10 minutes ago.

Explanation:
If the input is 03:50:00PM and the current time is 04:00:00PM,
then the difference between the current time and input time is 10 minutes, so the output will be 10 minutes ago.
(You can give input in any format)
only time - 03:00:00PM/AM
with date - Jan 31 2024 15:00:00
With day and date - Wed Jan 31 2024 15:00:00
and also in milliseconds.
But the result should be the relative time (which is, 10 minutes ago / a few seconds ago / two days ago / ...)
 */
public class RelativeTime {
    String input = "15:00:00";
    boolean isValidLength(String input){
        return input.length() == 8;
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

    boolean isValidHourMinuteSecond(String input) {
        int hour;
        int min;
        int sec;
        if (containsAllDigit(input)) {
            hour = Integer.parseInt(input.substring(0, 2));
//            System.out.println("\t"+hour);
            min = Integer.parseInt(input.substring(3, 5));
//            System.out.println(min);
            sec = Integer.parseInt(input.substring(6));
//            System.out.println(sec);
            return (!(hour > 12 || min > 59 || sec > 59));
        }
        return false;
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
        else{
            return true;
        }
        return false;
    }

    String currentTime(){
        Date now = new Date();
        return now.toString().substring(11,19);
    }
    void calculateTimeDifference(String inputTime, String currentTime){
        int hourDifference = 0;
        int minDifference  = 0;
        int secDifference  = 0;
        int hour1 = Integer.parseInt(inputTime.substring(0,2));
        int hour2 = Integer.parseInt(currentTime.substring(0,2));
        int min1  = Integer.parseInt(inputTime.substring(3,5));
        int min2  = Integer.parseInt(currentTime.substring(3,5));
        int sec1  = Integer.parseInt(inputTime.substring(6,8)) ;
        int sec2  = Integer.parseInt(currentTime.substring(6,8));

        hourDifference = hour1 - hour2;
        minDifference = min1 - min2;
        secDifference = sec1 - sec2;
//        if(secDifference<0){
//            minDifference--;
//            while (secDifference<-60) {
//                secDifference = secDifference / 60;
//                minDifference--;
//            }
//        }
        System.out.println(hourDifference + ":"+ minDifference + ":" + secDifference);
    }

    public static void main(String[] args) {
        RelativeTime obj = new RelativeTime();
        System.out.println(obj.currentTime());
        String input = "12:45:18";
        System.out.println(obj.isValidInput(input));

        obj.calculateTimeDifference(input , obj.currentTime());
    }

}

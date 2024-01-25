package org.example;

import java.util.Scanner;

public class RemoveFive {
    public static void main(String[] args) {
        RemoveFive obj = new RemoveFive();
        Scanner sc= new Scanner(System.in);
        System.out.println("enter starting number ");
        int start = sc.nextInt();
        System.out.println("enter  ending  number");
        int end = sc.nextInt();
        for(int i = start ; i < end ; i++){
            if(!obj.isDigitFive(i)){
                System.out.print(i+ " ");
            }
        }
    }
    boolean isDigitFive(int num){
        int currentDigit = 0;
        while(num>0){
            currentDigit = num % 10;
            num = num / 10;
            if(currentDigit==5){
                return true;
            }
        }
        return false;
    }
}

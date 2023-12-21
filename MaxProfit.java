package org.example;

import java.util.Scanner;

public class MaxProfit {
    public static void main(String[] args) {

        System.out.println("enter number of days in total");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] prices = new int[n];
        for(int i = 0 ; i < prices.length ; i++){
            System.out.println("enter price "+(i+1));
            prices[i]=sc.nextInt();
        }

        System.out.println("enter the day you are buying");
        int day = sc.nextInt();
        int max = 0;
        int maxDay = 0;
        for(int idx = day-1 ; idx < prices.length ; idx++){
            if(prices[idx] > max){
                max = prices[idx];
                maxDay = idx;
            }
        }
        maxDay = maxDay - day + 1;
        int maximumProfit = max - prices[day-1];
        System.out.println("your maximum profit is: "+maximumProfit+", "+maxDay+" days after your purchase");
        sc.close();
    }
}

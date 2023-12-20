package org.example;

import java.util.Scanner;

public class MaxProfit {
    public static void main(String[] args) {
//        int[] prices = new int[]{9,5,4,7,2,7,2,8,3,9,8,3,2,8,4};
        System.out.println("enter number with space");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();

        String[] str = a.split(" ");
        int[] prices = new int[str.length];
        for(int i = 0 ; i < str.length ; i++){
            prices[i] = Integer.parseInt(str[i]);
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

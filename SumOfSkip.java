package org.example;

import java.util.Arrays;

public class SumOfSkip {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,6,2,6,3,9,3,5};
        int k = 3;
        int i = 0;
        int[] sum = new int[k];
        while(i<k){
            for(int j = i ; j < arr1.length ; j = j + k){
                sum[i] += arr1[j];
            }
            i++;
        }
        System.out.println(Arrays.toString(sum));

    }
}

package org.example;
/*
    Given an integer array nums, move all 0's to the end of it
    while maintaining the order of the non-zero elements.

    NOTE: Try doing this in-place without making a copy of the array.


    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:

    Input: nums = [0]
    Output: [0]
 */
public class MoveZeroArray {
    int numberOfZeroes(int[] arr){
        int numberOfZeroes = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]==0)numberOfZeroes++;
        }
        return numberOfZeroes;
    }
    int[] moveNumbers(int[] arr){
        if(numberOfZeroes(arr)>0){
            int count = 0;
            for(int i = 0 ; i < arr.length ; i++){
                if(arr[i]==0){
                    count++;
                }
                else arr[i-count] = arr[i];
            }
            while(count>0){
                arr[arr.length-count] = 0;
                count--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        MoveZeroArray obj = new MoveZeroArray();
        int[] arr = obj.moveNumbers(new int[]{0,4,6,8,0,3}) ;
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

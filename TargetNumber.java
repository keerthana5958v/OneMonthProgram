package org.example;

//1.Given an array of integers nums and an integer target, return indices
// of the two numbers such that they add up to target.
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//        You can return the answer in any order.
//        Example 1:
//        Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//        Example 2:
//        Input: nums = [3,2,4], target = 6 Output: [1,2]

public class TargetNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1,8,3,7,5,6,4,0,9};
        int target = 7;
        for(int i =0 ; i < nums.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if((nums[i]+nums[j]) == target){
                    System.out.println("["+i +","+ j+"]");
                }
            }
        }
    }
}
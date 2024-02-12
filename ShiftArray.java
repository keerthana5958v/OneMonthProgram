package org.example;

import java.util.Arrays;
import java.util.Scanner;

/*
    Program 3:
    Write a program to rotate the given array n number of times to its left.
    Example:
    Input:
    arr = [1, 2, 3, 4, 5]
    n = 3

    Output:
    [4, 5, 1, 2, 3]
 */
public class ShiftArray {
    int[] arr = new int[]{1,2,3,4,5};
    int n = 7;
    int[] rotateElements(int[] arr, int n){
        if(n>arr.length)n = n% arr.length;
        int[] shiftingElements = new int[n];
        for (int i = 0; i < n; i++) {
            shiftingElements[i] = arr[i];
        }
        for(int i = n ; i < arr.length ; i++) {
                arr[i-n] = arr[i];
        }
        for(int i = 0 ; i < n ; i++) {
            arr[arr.length - n + i] = shiftingElements[i];
        }
        return arr;
    }
    int[] createArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of elements ");
        int numEle = sc.nextInt();
        int[] arr = new int[numEle];
        for(int i = 1 ; i <= numEle ; i++){
            System.out.println("enter the element "+ i);
            int ele = sc.nextInt();
            arr[i-1] = ele;
        }
        return arr;
    }
    public static void main(String[] args) {
        ShiftArray obj = new ShiftArray();
        Scanner sc = new Scanner(System.in);
        int[] arr = obj.createArray();
        System.out.println("enter the number of rotations");
        int n = sc.nextInt();
        System.out.println(Arrays.toString(obj.rotateElements(new int[]{1,2,3,4,5}, n)));
    }
}

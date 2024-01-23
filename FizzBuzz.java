package org.example;

// Consider the series of numbers beginning at start
// and running up to but not including end, so for example start=1 and end=5 gives the series 1, 2, 3, 4.
// Return a new String[] array containing the string form of these numbers,
// except for multiples of 3, use "Fizz" instead of the number, for multiples of 5 use "Buzz",
// and for multiples of both 3 and 5 use "FizzBuzz".
// In Java, String.valueOf(xxx) will make the String form of an int or other type.
// This version is a little more complicated than the usual version since you
// have to allocate and index into an array instead of just printing, and we vary the start/end
// instead of just always doing 1..100.

import java.util.Arrays;
import java.util.Scanner;

public class FizzBuzz {
    Object[] arr;

    public static void main(String[] args) {
        FizzBuzz obj = new FizzBuzz();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter starting number");
        int startingNum = sc.nextInt();
        System.out.println("enter ending number");
        int endingNum = sc.nextInt();


        System.out.println(Arrays.toString(obj.fizzBuzzArray(startingNum,endingNum)));
    }
    Object[] fizzBuzzArray(int startNum, int endNumb){
        arr = new Object[(endNumb - startNum)];
        for(int i = 0 ; i < arr.length ; i++){
//            System.out.println(i +1);
            if((startNum+i )% 15 == 0){
                arr[i] = "FizzBuzz";
            }
            else if((startNum+i) % 5 == 0){
                arr[i] = "Buzz";
            }
            else if((startNum+i)%3 ==0){
                arr[i] = "Fizz";
            }
            else {
                arr[i] = startNum+i;
            }
        }
        return arr;
    }

}

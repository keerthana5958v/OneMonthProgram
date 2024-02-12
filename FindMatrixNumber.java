package org.example;
/*
    Program 4:
    Find the number x in a matrix. x is defined as the smallest number in a row
    and the largest number in the same column. Print -1 if there is no such element.

    Input:
    Enter the size of array: 3 3
    Array :     3  11  7
                5   9  14
                2   4   5
    Output: 5
    Explanation: 5 is the smallest number in the row [5  9  14] and largest number in the column [3  5  2]

    Input:
    Enter the size of array: 4 2
    Array: 4 11
               9  8
               3  27
               7  7
    Output: -1
    Explanation: There is no matching number for the given input.
 */
public class FindMatrixNumber {
    int[][] arr = new int[][]{{3,11,7},{5,9,14},{2,4,5}};
    int findSmallestRowNumber(int[] a){
        int smallest = a[0];
        int smallInd = 0;
        for(int i = 0 ; i < a.length ; i++){
            if(a[i]<smallest) {
                smallest = a[i];
                smallInd = i;
            }
        }
        return smallInd;
    }
    int findLargestColumnNumber(int[][] a){
        int largest = 0;
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[i].length ; j++) {
                if (a[i][findSmallestRowNumber(a[j])]>largest) largest = a[i][findSmallestRowNumber(a[j])];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        FindMatrixNumber obj = new FindMatrixNumber();
        System.out.println(obj.findLargestColumnNumber(obj.arr));
    }


}

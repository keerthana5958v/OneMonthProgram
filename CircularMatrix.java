package org.example;
/*
    Program 3:
    Write a program to print circular matrix
     Input: n=3
    Output:

    1 2 3
    8 9 4
    7 6 5

     Input: n = 4

    Output:

    1    2    3    4
    12   13   14   5
    11   16   15   6
    10   9    8     7
 */

public class CircularMatrix {
    int rows = 5;
    int[][] arr;
    CircularMatrix(int[][] arr){
        this.arr = arr;
    }
    CircularMatrix(){
        this.arr = new int[rows][rows];
    }

    CircularMatrix createCircularMatrix(int rows){
        int[][] arr = new int[rows][rows];
        int element = 1;
        int currentRowIndex = 0;
        int revRowIndex = rows-1;
        int whileLoopCount = 0;

        while(currentRowIndex<revRowIndex){
            for (int i = 0; i < rows; i++) {
                if(whileLoopCount>0 && i == rows-1) {
                    int whileCount = 0;
                    while(whileCount != whileLoopCount) {
                        element--;
                        whileCount++;
                    }
                }
                if(arr[currentRowIndex][i] == 0) {
                    arr[currentRowIndex][i] = element;
                }
                if (i < revRowIndex) {
                    element++;
                }
            }
            for (int i = 0; i < rows; i++) {
                if (whileLoopCount > 0 && i == rows-1) {
                    int whileCount = 0;
                    while(whileCount != whileLoopCount) {
                        element--;
                        whileCount++;
                    }
                }
                if(arr[i][revRowIndex]==0) arr[i][revRowIndex] = element;
                if (i < revRowIndex) {
                    element++;
                }
            }
            for (int i = rows - 1; i >= 0; i--) {
                if(whileLoopCount>0 && i<1) {
                    int whileCount = 0;
                    while(whileCount != whileLoopCount) {
                        element--;
                        whileCount++;
                    }
                }
                if(arr[revRowIndex][i]==0) arr[revRowIndex][i] = element;
                if (i > currentRowIndex) {
                    element++;
                }
            }
            for (int i = rows - 1; i >= 0; i--) {
                if(whileLoopCount>0 && i<1) {
                    int whileCount = 0;
                    while(whileCount != whileLoopCount) {
                        element--;
                        whileCount++;
                    }
                }
                if (arr[i][currentRowIndex] == 0) arr[i][currentRowIndex] = element;
                if (i > currentRowIndex + 1) {
                    element++;
                }
            }
            currentRowIndex++;
            revRowIndex--;
            whileLoopCount++;
        }
//        if(rows%2!=0) {
        if(arr[rows/2][rows/2]==0) arr[rows/2][rows/2] = whileLoopCount+element;
        return new CircularMatrix(arr);
    }

    public String toString(){
        String res= "";
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length ; j++){
                if(arr[i][j]>9) res += arr[i][j]+" ";
                if(arr[i][j]<=9)res += arr[i][j]+"  ";
            }
            res+="\n";
        }
        return res;
    }

    public static void main(String[] args) {
        CircularMatrix obj = new CircularMatrix();
        System.out.println(obj.createCircularMatrix(6));
    }


}

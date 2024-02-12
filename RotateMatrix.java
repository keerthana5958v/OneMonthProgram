package org.example;
/*
    1. Rotate a matrix clockwise
    Example:
    Matrix:
    1 2 3
    4 5 6
    7 8 9

    Output:
    7 4 1
    8 5 2
    9 6 3
 */
public class RotateMatrix {
    RotateMatrix(int[][] matrix){
        this.matrix = matrix;
    }
    RotateMatrix(){
        this.matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    }
    int[][] matrix;

    public String toString(){
        String res= "";
        for(int i = 0 ; i < matrix.length ; i++){
            res += "[ ";
            for(int j = 0 ; j < matrix[i].length ; j++){
                if(j<matrix[i].length-1) {
                    res += matrix[i][j] + ", ";
                }
                else {
                    res += matrix[i][j];
                }
            }
            res+= " ]\n";
        }
        res+="";
        return res;
    }

    RotateMatrix rotateMatrix(int[][] matrix){
        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < rotatedMatrix.length ; i++){
            for(int j = 0 ; j < rotatedMatrix[i].length ; j++){
                rotatedMatrix[i][j] = matrix[j][i];
                if(j <  (rotatedMatrix[i].length/2) -1) {
                    rotatedMatrix[i][j] = rotatedMatrix[i][rotatedMatrix.length-j];
                }
            }
            rotatedMatrix[i] = swapElements(rotatedMatrix[i]);
        }
        return new RotateMatrix(rotatedMatrix);
    }
    int[] swapElements(int[] arr){
        for(int i =  0 ; i < arr.length ; i++){
            if (i < arr.length / 2) {
//                arr[arr.length - i] = arr[i - arr.length];
                int temp = arr[i];
                arr[i] = arr[arr.length- i-1];
                arr[arr.length- i-1] = temp;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        RotateMatrix obj = new RotateMatrix();
        System.out.println(obj);
        System.out.println(obj.rotateMatrix(obj.matrix));
    }
}

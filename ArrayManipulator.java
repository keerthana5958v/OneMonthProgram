package org.example;

import java.sql.Array;

public class ArrayManipulator {
    int[] data;
    public ArrayManipulator(){
        this.data = new int[]{1,2,3,4,5};
    }
    public ArrayManipulator(int[] data){
        this.data = data;
    }
    public ArrayManipulator add(int num){
        int[] arr = new int[this.data.length+1];
        for(int i = 0 ; i < data.length ; i++){
            arr[i] = data[i];
        }
        arr[arr.length-1] = num;
        return new ArrayManipulator(arr);
    }
    public ArrayManipulator remove(int index){
        int[] arr = new int[data.length-1];
//        data[index] = '\0';
        for(int i = 0 ; i < data.length ; i++){
            if(i<index){
                arr[i]=data[i];
            }
            if(i>index){
                arr[i-1] = data[i];
            }
        }
        return new ArrayManipulator(arr);
    }
    public String toString(){
        String res = "[";
        for(int i = 0 ; i < data.length ; i++){
            if(i == data.length - 1){
                res += data[i];
            }
            else {
                res += data[i] + ", ";
            }
        }
        res += "]";
        return res;
    }

    public static void main(String[] a){
        ArrayManipulator ob = new ArrayManipulator();
        ob = ob.remove(2);
        System.out.println(ob);
    }




}

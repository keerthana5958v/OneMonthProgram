package org.example;

public class CharSort {
    static String sortCharArrayToString(char[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                char temp = ' ';
                if(Character.toLowerCase(arr[i])>Character.toLowerCase(arr[j])){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < arr.length ; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        char[] arr = {'m','a','g','s','k'};
        System.out.println(sortCharArrayToString(arr));
    }
}

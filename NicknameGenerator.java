package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class NicknameGenerator {
    public static void main(String[] args) {
        NicknameGenerator obj = new NicknameGenerator();
        String[] nameArr = obj.createNameArray();
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.toString(nameArr));
        for(int i = 0 ; i < nameArr.length ; i++){
            if(nameArr[i]!=null) {
                sb.append(nameArr[i].charAt(obj.randomNumGenerator(nameArr[i].length() - 1)));
            }
        }
        System.out.println(sb);
    }
    String[] createNameArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of names to create combination nickname: ");
        int number = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[number];
        for(int i = 0 ; i < number ; i++){
            System.out.println("enter name "+(i+1));
            arr[i] = sc.nextLine();
        }
        return arr;
    }
    int randomNumGenerator(int max){
        return  (int) (Math.random()*(max+1));
    }
}

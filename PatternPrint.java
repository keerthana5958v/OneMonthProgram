package org.example;

public class PatternPrint {
    public static void main(String[] args) {
        int n = 9;

        for (int i = n; i > 0; i--) {
            int temp = n;
            temp = temp - i;
            for (int j = temp; j > 0 ; j--) {
                System.out.print(" ");
                temp--;
            }
//            System.out.print(i);
            for(int k = 0 ; k < i ; k++){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}

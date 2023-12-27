package org.example;

public class Fibonacci {
    void fibonacci(int limit){
        int first = 1;
        int next = 1;
        int sum;
        for(int i = 0 ; i < limit ; i++){
            System.out.print(first+" ");
            sum = first+next;
            first = next;
            next = sum;

        }
        System.out.println();
    }
    void recursionFibonacci(int limit, int previousNum, int currentNum, int recur){
        if(recur>=limit){
            return;
        }
        recur++;
        int nextNum = previousNum + currentNum;
        previousNum = currentNum;
        currentNum = nextNum;
        System.out.print(previousNum+" ");
        recursionFibonacci(limit , previousNum , currentNum, recur );
        System.out.println();
    }

    public static void main(String[] args) {
        Fibonacci obj = new Fibonacci();
        obj.fibonacci(10);
        obj.recursionFibonacci( 10 , 0 , 1 ,  0);
    }
}

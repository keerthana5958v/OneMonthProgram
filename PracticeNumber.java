package org.example;
import java.util.Scanner;

public class PracticeNumber {
    int getNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        int num = sc.nextInt();
        if(num<=100 && num>0) {
            return num;
        }
        else return 0;
    }
    int sumOfDigits(int num){
//        String number = String.valueOf(num);
//        int idx = number.length() - 1;
//        int sum = 0;
//        while(idx>=0){
//            sum += Integer.parseInt(number.charAt(idx)+"");
//            idx--;
//        }
//        return sum;
        int sum = 0;
        int temp = 0;
        while(num!=0){
            temp = num%10;
            num = num/10;
            sum+=temp;
        }
        return sum;
    }
    int reverseDigits(int num){
        if(num<0){
            return 0;
        }
        if(num>=0 && num<10){
            return num;
        }
        String number = String.valueOf(num);
        int idx = number.length() - 1;
        String revNumber = "";
        while(idx>=0){
            revNumber += number.charAt(idx)+"";
            idx--;
        }
        return Integer.parseInt(revNumber);
    }

    int productOfSumAndReversedDigits(int sum , int reversedNum){
        return sum * reversedNum;
    }
    boolean isNumberEqualToOriginal(int originalNum , int productOfSumAndReversedDigits){
        return (originalNum == productOfSumAndReversedDigits);
    }
    void printCorrespondingNumber(){
        int limit = 10;
        for(int number = 0 ; number <= limit ; number++){
            int reversed = reverseDigits(number);
            int sumOfDigits = sumOfDigits(number);
            int productOfSumAndReverse = productOfSumAndReversedDigits(sumOfDigits , reversed);
            boolean isNumberEqualToOriginal = isNumberEqualToOriginal(number , productOfSumAndReverse);
            if(isNumberEqualToOriginal){
                System.out.print(number + " ");
            }
        }
    }

    public static void main(String[] args) {
        PracticeNumber obj = new PracticeNumber();
//        System.out.println(obj.reverseDigits(21));

//        int number = 10;
//        int sum = obj.sumOfDigits(number);
//        int rev = obj.reverseDigits(number);
//        int product = obj.productOfSumAndReversedDigits(sum , rev);
//        System.out.println(product==number);


        obj.printCorrespondingNumber();
//        System.out.println(obj.sumOfDigits(2));
    }
}

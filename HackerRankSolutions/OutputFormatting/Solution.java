import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("================================");
         for(int i=0;i<3;i++)
         {
            String s1=sc.next();
            int x=sc.nextInt();
            int temp = 18 - s1.length();
            String x1;
            if(x<10){
                x1 = "00" + String.valueOf(x);
            }
            else if(x<100){
                x1 = "0" + String.valueOf(x);
            }
            else{
                x1 = String.valueOf(x);
            }
            System.out.printf("%s%"+temp+"s",s1,x1);
            
             System.out.println();
         }

        System.out.println("================================");

    }
}





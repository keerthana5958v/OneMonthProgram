import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int length = A.length()+B.length();
        System.out.println(length);
        boolean larger = false;
        int i = 0;
        A = A.toLowerCase();
        B = B.toLowerCase();
        
        while(i< Math.min(A.length(),B.length())){
            if((int)A.charAt(i)<(int)B.charAt(i)){
                larger = false;
                break;
            }
            else if((int)A.charAt(i)>(int)B.charAt(i)){
                larger = true;
                break;
            }
            i++;
        }
        // if(A.compareTo(B)>0)System.out.println("Yes");
        // else if(A.compareTo(B)==0)System.out.println("Yes");
        
        if(larger == false && A.equals(B)){
            larger = false;
        }
        
        if(larger)System.out.println("Yes");
        else System.out.println("No");
        A = Character.toUpperCase(A.charAt(0))+A.substring(1);
        B = Character.toUpperCase(B.charAt(0))+B.substring(1);
        System.out.println(A+" "+B);
    }
}





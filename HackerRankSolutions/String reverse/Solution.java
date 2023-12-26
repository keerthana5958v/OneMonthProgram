import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */

        String backward = "";
        // for(int i = A.length() ; i < 0 ; i--){
        //     backward.concat(A.charAt(i)+"");
        // }
        
        for (int i = 0; i < A.length(); i++) {
            backward = A.charAt(i) + backward;
        }
        if(A.equals(backward)){
            System.out.println("Yes");
        }
        else System.out.println("No");
    }
}





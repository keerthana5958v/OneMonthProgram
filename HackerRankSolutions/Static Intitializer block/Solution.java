import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        try{
        int h = sc.nextInt();
        int b = sc.nextInt();
        
        if((b>0) && (h>0) &&(h<=100)&&(b<=100)){ // h<100 , b<100
            int area = b*h;
            System.out.println(area);
        }
        else{
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
        }
        catch(Exception e){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }
}


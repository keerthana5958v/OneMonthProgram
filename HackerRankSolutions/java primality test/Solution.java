import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String n = bufferedReader.readLine();
        boolean isPrime = false;
        int n1 = 0;
        try{
            n1 = Integer.parseInt(n);  
        }
        catch(Exception e){
            // System.out.println("not prime");
        } 
            BigInteger n2 = new BigInteger(n);
            if(n1<0)isPrime = false;
            else if(n1==1)isPrime=false;
            else if(n1==2|| n1 == 3)isPrime = true;
            else if(n2 == BigInteger.ZERO)isPrime = false;
            
            else if(n1>3){
                isPrime = true;
                for(int i = 2 ; i < Math.sqrt(n1) ; i++){
                    if(n1 % i==0){
                        isPrime = false;
                        break;
                    }
                }
            }
            else{
                if(n2.isProbablePrime(100))isPrime=true;
            }        
        
        if(isPrime)System.out.println("prime");
        else System.out.println("not prime");
        bufferedReader.close();
    }
}


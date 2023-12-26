import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        BigInteger n1 = new BigInteger(a);
        BigInteger n2 = new BigInteger(b);
        System.out.println(n1.add(n2));
        System.out.println(n1.multiply(n2));
    }
        
}

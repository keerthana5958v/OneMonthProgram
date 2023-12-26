import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        String[] miniStr = new String[s.length()-k+1];
        for(int i = 0 ; i < miniStr.length ; i++){
            miniStr[i] = s.substring(i , i+k);
        }
        String fLex = miniStr[0];
        for(int i = 0 ; i < miniStr.length; i++){
            if(miniStr[i].compareTo(fLex) < 0){
                fLex = miniStr[i];       
            }
        }
        String lLex = miniStr[0];
        for(int i = 0 ; i < miniStr.length; i++){
            if(miniStr[i].compareTo(lLex) > 0){
                lLex = miniStr[i];       
            }   
        }
        smallest = fLex;
        largest = lLex;
                
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}

import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if(a.length()!=b.length()){
            return false;
        }
        if(a.equalsIgnoreCase(b)){
            return true;
        }
        // if(a.equalsIgnoreCase(reversed(b))){
        //    return true; 
        // }
        // if(a.contains(b) &&(a.length()==b.length())){
        //     return true;
        // }
        // if(b.contains(a) &&(a.length()==b.length())){
        //     return true;
        // }
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] char1 = a.toCharArray();
        char[] char2 = b.toCharArray();
        
        if(sortCharArrayToString(char1).equals(sortCharArrayToString(char2))){
            return true;
        }
        return false;
    }
    static String sortCharArrayToString(char[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                char temp = ' ';
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0 ; i < arr.length ; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    
    // static String reversed(String A){
    //     StringBuilder rev=new StringBuilder("");
    //     for(int i = A.length()-1 ; i >= 0; i--){
    //         rev.append(A.charAt(i));
    //     }
    //     return rev.toString();
    // }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}


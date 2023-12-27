package org.example;

public class SubstringPalindrome {
    public static void main(String[] args) {
        SubstringPalindrome obj = new SubstringPalindrome();
        obj.getAllSubstringPalindrome("abbabcddcbab");
    }
    boolean isPalindrome(String a){
        StringBuilder revStr = new StringBuilder();
        for(int i = a.length()-1 ; i >= 0 ; i-- ){
            revStr.append(a.charAt(i));
        }
        return (revStr.toString().equals(a));
    }
    void getAllSubstringPalindrome(String str){
//        String str = "abbabcddcbab";
//        int count = 0;
        String s ="";
        String s1 = "";
        String[] arr;

        for(int i = 0 ; i < str.length()  ; i++){
            for(int j = 1 ; j + i < str.length(); j++){
//                arr[i][j] = str.substring(j , (j+1) );
//                if(i != 0 && j !=0) {
                s = str.substring(i, i + j);
                s1 += s + " ";
//                }
//                s += str.substring(i + j);
//                s += "\n";
            }
        }
        arr = s1.split(" ");
//        SubstringPalindrome obj = new SubstringPalindrome();

        for(int i = 0 ; i < arr.length ; i++){
//            System.out.println(arr[i]);
            if(isPalindrome(arr[i])&& arr[i].length()>1){
                System.out.println(arr[i]);
            }
        }
    }

}

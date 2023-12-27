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
        for(int i = 0 ; i < str.length()  ; i++){
            for(int j = 1 ; j + i < str.length(); j++){
                String s = str.substring(i, i + j);
                if(isPalindrome(s)&& s.length()>1){
                    System.out.println(s);
                }
            }
        }

    }

}

package org.example;

import java.util.Scanner;

public class StringExchange {
    public static void main(String[] args) {
        StringExchange obj = new StringExchange();
        Scanner sc = new Scanner(System.in);
        System.out.println(obj.reverseWordsWithoutSpecialCharacters(sc.nextLine()));

    }
    String reverseWordsWithoutSpecialCharacters(String s){
        String specChar = "@!.*#,@#$%^&*()/`~';:\\|][{}><?";
        char lastChar = s.charAt(s.length()-1);
        int count = 1;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i)==' '||(specChar.contains(s.charAt(i)+"")))count++; // counts the number of words or special chars
        }
//        System.out.println(count);
        char[] symbols = new char[count+2];
        int index = 0;
        for(int i = 1 ; i < s.length() ; i++){
            if(specChar.contains(s.charAt(i-1)+"")&&(s.charAt(i)==' ')){ // inserts special characters or space into char array
                symbols[index] = s.charAt(i-1);
                index++;
            }
            if((!specChar.contains(s.charAt(i-1)+""))&&(s.charAt(i)==' ')){
                symbols[index] = '\0';
                index++;
            }

        }

//        System.out.println(symbols);

        for(int i = 0 ; i < s.length() ; i++){
            if(specChar.contains(s.charAt(i)+"")){ // remove special characters to replace words to help reverse
                s = s.substring(0,i) + s.substring(i + 1);
            }
        }


        StringBuilder sb= new StringBuilder();
        String[] rev = s.split(" ");

        for(int i = rev.length ; i > 0 ; i--){
            sb.append(rev[i-1]);
            sb.append(" ");
        }
        //System.out.println(sb);//string builder reversed

        rev = sb.toString().split(" ");
        sb.delete(0 , sb.length());

        for(int i = 0 ; i < Math.min(rev.length , symbols.length) ; i++){
            sb.append(rev[i]);
            if((symbols[i]!='\0')) {
                sb.append(symbols[i]);
            }
            if(i < Math.min(rev.length , symbols.length)-1) {
                sb.append(" ");
            }
        }
        if(specChar.contains(lastChar+"")){
            sb.append(lastChar);
        }
//        System.out.println(sb);
        return sb.toString();
    }
}
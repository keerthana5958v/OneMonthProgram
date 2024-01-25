package org.example;

public class RemoveVowels {
    public static void main(String[] args) {
        String sentence = "today is another day to write code!";
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < sentence.length() ; i++){
            if(!"aeiou".contains((sentence.charAt(i)+"").toLowerCase())){
                sb.append(sentence.charAt(i));
            }
        }
        System.out.println(sb);
    }
}

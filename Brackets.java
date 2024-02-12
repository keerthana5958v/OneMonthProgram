package org.example;
/*
    Today's Programs
    Program 1:
    Given a string containing different types of parenthesis '(' , ')', '{', '}', '[', ']',
    determine if the input is valid

    An input string is valid if:

    1. Open brackets must be closed by the same type of brackets.
    2. Open brackets must be closed in the correct order.
    3. Every close bracket has a corresponding open bracket of the same type.

    Input: s = "( )"
    Output: true

    Input: s = "( ) [ ] { }"
    Output: true

    Input: s = "( ]"
    Output: false
 */
public class Brackets {
    char[] open = new char[]{'(','[','{'};
    char[] close = new char[]{')',']','}'};
    String removeCharacters(String input){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < input.length() ; i++){
            int index = 0;
            char curChar = input.charAt(i);
            while(index<open.length) {
                if ((curChar == open[index] || curChar == close[index])) {
                    sb.append(input.charAt(i));
                    break;
                }
                index++;
            }
        }
        input = sb.toString();
        return input;
    }

    int hasOpenBracket(String input){
        input = removeCharacters(input);
        int index = 0;
        int bracket = -1;
        while(index < open.length){
            if(input.charAt(0) == open[index]){
                bracket = index;
                break;
            }
            index++;

        }
        return bracket;
    }
    boolean hasCloseBracket(String input){
        input = removeCharacters(input);
        int bracketType = hasOpenBracket(input);
        if(bracketType!=-1){
            return (input.charAt(1)==close[bracketType]);
        }
        return false;
    }
    boolean isValidInput(String input){
        input = removeCharacters(input);
        if(input.length()==2)return hasCloseBracket(input);
        while(hasCloseBracket(input) && input.length()>2){
//            System.out.println(input);
            input = input.substring(2);
            if(!hasCloseBracket(input))return false;
        }
        return hasCloseBracket(input);
//            input = (input.substring(input.indexOf(close[hasOpenBracket(input)])+1));
    }

    public static void main(String[] args) {
        Brackets obj = new Brackets();
        String input = "{     }(  ) {sdb}{f}";
        System.out.println(obj.isValidInput(input));
    }


}

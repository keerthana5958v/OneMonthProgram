package org.example;
/*
    Program 2:
    Given two strings string1 and string2, return the index of the first occurrence
    of string2 in string1 or return -1, if string2 is not occurred in string1.

    Input: s1 = "zohocorporation" , s2 = "corp"
    Output: 4
    Explanation:
    "corp" occurs from index 4 to 7 in s1, since the first index of occurrence is 4, it should return 4 as answer.
 */
public class FindSubstringIndex {
    int findSubstringIndex(String input, String substring){
        if(input.contains(substring)){
            return input.indexOf(substring);
        }
        return -1;
    }

    public static void main(String[] args) {
        FindSubstringIndex obj = new FindSubstringIndex();
        System.out.println(obj.findSubstringIndex("zohocorporation","corp"));
    }

}

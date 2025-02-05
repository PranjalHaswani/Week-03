package com.day4.StringBuilder;
import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        //Example text
        String text = "Hello children, How are you?";
        //Calling the removeDuplicates method and printing the text
        String result = removeDuplicates(text);
        System.out.println("Original String: "+ text);
        System.out.println("String without duplicates: " + result);
    }
    public static String removeDuplicates(String str){
        //Create a StringBuilder to store the result
        StringBuilder string= new StringBuilder();
        //Create a HashSet to keep track of characters repeated or seen
        HashSet<Character> seen= new HashSet<>();
        for(char ch: str.toCharArray()) {
            if(!seen.contains(ch)){
                string.append(ch);
                //Add the character to HashSet
                seen.add(ch);
            }
        }
        return string.toString();
    }
}


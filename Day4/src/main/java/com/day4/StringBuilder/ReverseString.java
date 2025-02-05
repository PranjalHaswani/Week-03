package com.day4.StringBuilder;
public class ReverseString {

    // Function to reverse a string using StringBuilder
    public static String reverseString(String input) {
        // Create a StringBuilder object with the input string
        StringBuilder sb = new StringBuilder(input);

        // Use the reverse() method of StringBuilder
        sb.reverse();

        // Convert the StringBuilder back to a string and return it
        return sb.toString();
    }

    public static void main(String[] args) {
        // Example input
        String input = "hello";

        // Call the reverseString function and print the result
        String reversed = reverseString(input);
        System.out.println("Reversed string: " + reversed);
    }
}
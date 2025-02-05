package com.day5.LinearSearch;

public class LinearSearch {

    // Method to find the first negative number's index
    public static int findFirstNegative(int[] arr) {
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element is negative
            if (arr[i] < 0) {
                return i; // Return the index of the first negative number
            }
        }
        // If no negative number is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Sample array
        int[] array = {3, 5, -1, 4, 2};

        // Call the method and print the result
        int index = findFirstNegative(array);

        if (index != -1) {
            System.out.println("First negative number is at index: " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }
}
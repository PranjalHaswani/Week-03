package com.day2;
import java.util.HashMap;

public class CheckForPair {
    public static boolean hasPairWithSum(int[] arr, int target) {
        // Create a HashMap to store the numbers we've visited
        HashMap<Integer, Integer> visitedNumbers = new HashMap<>();

        // Loop through each number in the array
        for (int num : arr) {
            // Check if the difference between the target and current number is in the map
            int complement = target - num;
            if (visitedNumbers.containsKey(complement)) {
                // If found, return true (pair exists)
                return true;
            }
            // Otherwise, add the current number to the map
            visitedNumbers.put(num, 1);
        }
        // If no pair is found, return false
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        boolean result = hasPairWithSum(arr, target);
        if (result) {
            System.out.println("Pair exists with the given target sum.");
        } else {
            System.out.println("No pair exists with the given target sum.");
        }
    }
}


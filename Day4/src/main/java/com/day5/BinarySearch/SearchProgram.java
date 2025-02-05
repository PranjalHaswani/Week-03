package com.day5.BinarySearch;
import java.util.Arrays;

public class SearchProgram {

    // Method to find the first missing positive integer using Linear Search
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace negative numbers and numbers larger than n with a number outside the valid range (e.g., n + 1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Use the index to mark the presence of elements
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // Step 3: Find the first index where the number is positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // If no index is positive, return n + 1
        return n + 1;
    }

    // Method to perform Binary Search to find the index of a given target number
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is found
            if (nums[mid] == target) {
                return mid;
            }

            // If target is smaller, discard the right half
            if (nums[mid] > target) {
                right = mid - 1;
            }
            // If target is larger, discard the left half
            else {
                left = mid + 1;
            }
        }

        return -1; // If target is not found
    }

    public static void main(String[] args) {
        // Test the first missing positive method
        int[] nums = {3, 4, -1, 1};
        int missingPositive = firstMissingPositive(nums);
        System.out.println("The first missing positive integer is: " + missingPositive);  // Expected: 2

        // Test the binary search method
        int[] sortedNums = {1, 3, 4, 5, 6};
        int target = 4;
        int index = binarySearch(sortedNums, target);
        System.out.println("The index of " + target + " is: " + index);  // Expected: 2
    }
}




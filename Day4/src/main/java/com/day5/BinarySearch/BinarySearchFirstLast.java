package com.day5.BinarySearch;


public class BinarySearchFirstLast {

    // Method to find the first occurrence of the target element
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If we find the target, move left to check for the first occurrence
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;  // Continue searching to the left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Method to find the last occurrence of the target element
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If we find the target, move right to check for the last occurrence
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;  // Continue searching to the right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test the binary search for first and last occurrences
        int[] arr = {1, 2, 2, 2, 3, 3, 5, 6, 6, 7};

        int target = 2;
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);

        System.out.println("First occurrence of " + target + ": " + first);
        System.out.println("Last occurrence of " + target + ": " + last);

        // If the target does not exist in the array
        target = 4;
        first = findFirstOccurrence(arr, target);
        last = findLastOccurrence(arr, target);

        System.out.println("First occurrence of " + target + ": " + first);
        System.out.println("Last occurrence of " + target + ": " + last);
    }
}




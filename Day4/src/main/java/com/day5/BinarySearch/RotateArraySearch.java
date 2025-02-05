package com.day5.BinarySearch;

public class RotateArraySearch {

    // Method to find the index of the smallest element (rotation point)
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search
        while (left < right) {
            int mid = (left + right) / 2;

            // If mid element is greater than the right element, the smallest is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }

            else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        // Sample rotated sorted array
        int[] arr = {6, 7, 9, 15, 19, 2, 3};

        // Call the method and print the result
        int index = findRotationPoint(arr);
        System.out.println("The rotation point is at index: " + index);
        System.out.println("The smallest element is: " + arr[index]);
    }
}

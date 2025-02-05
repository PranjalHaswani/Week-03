package com.day5.BinarySearch;


public class PeakElement {

    // Method to find a peak element using Binary Search
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak element
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
                return mid;
            }

            // If the element on the left is greater, move to the left half
            else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            }
            // If the element on the right is greater, move to the right half
            else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test case 1: Array with a clear peak element
        int[] arr1 = {1, 3, 20, 4, 1, 0};
        int peakIndex1 = findPeakElement(arr1);
        System.out.println("Peak element in arr1 is at index " + peakIndex1 + " with value " + arr1[peakIndex1]);

        // Test case 2: Array where the peak is at the beginning
        int[] arr2 = {10, 9, 8, 7, 6};
        int peakIndex2 = findPeakElement(arr2);
        System.out.println("Peak element in arr2 is at index " + peakIndex2 + " with value " + arr2[peakIndex2]);

        // Test case 3: Array where the peak is at the end
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int peakIndex3 = findPeakElement(arr3);
        System.out.println("Peak element in arr3 is at index " + peakIndex3 + " with value " + arr3[peakIndex3]);

        // Test case 4: Array with multiple peaks
        int[] arr4 = {1, 3, 4, 5, 3, 2, 1};
        int peakIndex4 = findPeakElement(arr4);
        System.out.println("Peak element in arr4 is at index " + peakIndex4 + " with value " + arr4[peakIndex4]);
    }
}



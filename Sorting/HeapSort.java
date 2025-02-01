package com.day3;
public class HeapSort {

    // Function to perform heap sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build a Max Heap from the array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (maximum) element with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Function to heapify a subtree rooted with node i, which is an index in arr[].
    // n is the size of the heap
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child index
        int right = 2 * i + 2; // right child index

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // A utility function to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the heap sort implementation
    public static void main(String[] args) {
        int[] salaries = { 50000, 30000, 60000, 20000, 45000, 70000, 40000 };

        System.out.println("Original salary demands:");
        printArray(salaries);

        heapSort(salaries);

        System.out.println("Sorted salary demands in ascending order:");
        printArray(salaries);
    }
}

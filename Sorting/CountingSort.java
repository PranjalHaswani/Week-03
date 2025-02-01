package com.day3;
public class CountingSort {

    // Function to perform Counting Sort
    public static void countingSort(int[] ages) {
        int maxAge = 18; // Maximum possible age (as per the problem statement)
        int minAge = 10; // Minimum possible age (as per the problem statement)

        // Create a count array to store the frequency of each age
        int[] count = new int[maxAge - minAge + 1];

        // Count the frequency of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Update the count array to hold the cumulative frequency
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Create an output array to store the sorted ages
        int[] output = new int[ages.length];

        // Place the elements in their correct position in the output array
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        // Copy the sorted array back into the original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // A utility function to print the array
    public static void printArray(int[] arr) {
        for (int age : arr) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    // Main method to test the Counting Sort implementation
    public static void main(String[] args) {
        int[] ages = { 15, 12, 18, 14, 16, 10, 13, 17, 11, 15 };

        System.out.println("Original ages:");
        printArray(ages);

        countingSort(ages);

        System.out.println("Sorted ages:");
        printArray(ages);
    }
}

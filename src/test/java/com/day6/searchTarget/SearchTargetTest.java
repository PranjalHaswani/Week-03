package com.day6.searchTarget;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

public class SearchTargetTest {

    private int[] arr;

    @BeforeEach
    public void setUp() {
        // Setup a default array before each test
        Random random = new Random();
        arr = new int[1000]; // Example size for testing
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
    }

    @Test
    public void testLinearSearch() {
        int target = 500;

        // Perform LinearSearch
        double timeTaken = SearchTarget.LinearSearch(arr, target);

        // Check that it prints the result
        assertTrue(timeTaken >= 0, "Time taken by LinearSearch should be a non-negative value.");
    }

    @Test
    public void testBinarySearch() {
        int target = 500;

        // Sort the array before performing BinarySearch
        Arrays.sort(arr);

        // Perform BinarySearch
        double timeTaken = SearchTarget.BinarySearch(arr, target);

        // Check that it prints the result
        assertTrue(timeTaken >= 0, "Time taken by BinarySearch should be a non-negative value.");
    }

    @Test
    public void testComparisonOfSearches() {
        int target = 500;

        // Sort the array for Binary Search
        Arrays.sort(arr);

        // Get time for Linear Search
        double timeLinear = SearchTarget.LinearSearch(arr, target);

        // Get time for Binary Search
        double timeBinary = SearchTarget.BinarySearch(arr, target);

        // Check if the comparison logic works
        assertDoesNotThrow(() -> {
            SearchTarget.compare(timeLinear, timeBinary);
        }, "Comparison method should not throw any exceptions.");
    }

    @Test
    public void testLinearSearchNotFound() {
        int target = 10000;

        // Perform LinearSearch
        double timeTaken = SearchTarget.LinearSearch(arr, target);

        // Since target is not in the array, it should take some time but not find anything.
        assertTrue(timeTaken >= 0, "Time taken by LinearSearch should be a non-negative value.");
    }

    @Test
    public void testBinarySearchNotFound() {
        int target = 10000; // A target that's not in the array

        // Sort the array for Binary Search
        Arrays.sort(arr);

        // Perform BinarySearch
        double timeTaken = SearchTarget.BinarySearch(arr, target);

        assertTrue(timeTaken >= 0, "Time taken by BinarySearch should be a non-negative value.");
    }
}

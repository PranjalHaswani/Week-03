package com.day6.sortLargeData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class SortLargeDataTest {

    private int[] arr;

    @BeforeEach
    public void setUp() {
        // Initialize a random array for testing
        Random random = new Random();
        arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
    }

    @Test
    public void testBubbleSort() {
        int[] arrClone = arr.clone();
        double timeTaken = SortLargeData.bubbleSort(arrClone);

        // Check that the array is sorted
        assertTrue(isSorted(arrClone), "Bubble Sort did not sort the array correctly.");

        // Validate that time is non-negative
        assertTrue(timeTaken >= 0, "Bubble Sort time should be non-negative.");
    }

    @Test
    public void testMergeSort() {
        // Create a clone of the array for sorting
        int[] arrClone = arr.clone();
        double timeTaken = SortLargeData.mergeSort(arrClone);

        // Check that the array is sorted
        assertTrue(isSorted(arrClone), "Merge Sort did not sort the array correctly.");

        // Validate that time is non-negative
        assertTrue(timeTaken >= 0, "Merge Sort time should be non-negative.");
    }

    @Test
    public void testQuickSort() {
        int[] arrClone = arr.clone();
        double timeTaken = SortLargeData.quickSort(arrClone);

        // Check that the array is sorted
        assertTrue(isSorted(arrClone), "Quick Sort did not sort the array correctly.");

        // Validate that time is non-negative
        assertTrue(timeTaken >= 0, "Quick Sort time should be non-negative.");
    }

    @Test
    public void testComparison() {
        int[] arrClone = arr.clone();
        // Perform sorting and capture time taken
        double bubbleTime = SortLargeData.bubbleSort(arrClone.clone());
        double mergeTime = SortLargeData.mergeSort(arrClone.clone());
        double quickTime = SortLargeData.quickSort(arrClone.clone());

        // Ensure comparison method doesn't throw exceptions
        assertDoesNotThrow(() -> {
            SortLargeData.compare(bubbleTime, mergeTime, quickTime);
        }, "Comparison method should not throw exceptions.");
    }

    // Helper method to check if the array is sorted
    private boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}

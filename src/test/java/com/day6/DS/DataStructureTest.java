package com.day6.DS;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DataStructureTest {

    // Test the searchArray function
    @Test
    public void testSearchArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        double time = DataStructureSearch.searchArray(arr, target);
        assertTrue(time >= 0, "Search time should be non-negative");
    }

    // Test the searchHashSet function
    @Test
    public void testSearchHashSet() {
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        int target = 3;
        double time = DataStructureSearch.searchHashSet(hashSet, target);
        assertTrue(time >= 0, "Search time should be non-negative");
    }

    // Test the searchTreeSet function
    @Test
    public void testSearchTreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        int target = 3;
        double time = DataStructureSearch.searchTreeSet(treeSet, target);
        assertTrue(time >= 0, "Search time should be non-negative");
    }

    // Test the compare function to ensure no exceptions are thrown and it produces output
    @Test
    public void testCompare() {
        double timeArray = 1.0;  // Sample time in milliseconds
        double timeHashSet = 0.5;  // Sample time in milliseconds
        double timeTreeSet = 0.8;  // Sample time in milliseconds

        // As we can't directly check console output, we'll ensure no exception is thrown
        assertDoesNotThrow(() -> DataStructureSearch.compare(timeArray, timeHashSet, timeTreeSet));
    }

    // Additional Test: Test with random numbers (simulates larger datasets)
    @Test
    public void testRandomSearch() {
        Random random = new Random();
        int N = 1000; // A small random dataset for testing
        int[] arr = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Fill structures with random values
        for (int i = 0; i < N; i++) {
            int num = random.nextInt(N);
            arr[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        // Random target to search
        int target = random.nextInt(N);

        // Measure search times
        double timeArray = DataStructureSearch.searchArray(arr, target);
        double timeHashSet = DataStructureSearch.searchHashSet(hashSet, target);
        double timeTreeSet = DataStructureSearch.searchTreeSet(treeSet, target);

        // Checking that search times are non-negative
        assertTrue(timeArray >= 0, "Array search time should be non-negative");
        assertTrue(timeHashSet >= 0, "HashSet search time should be non-negative");
        assertTrue(timeTreeSet >= 0, "TreeSet search time should be non-negative");
    }
}

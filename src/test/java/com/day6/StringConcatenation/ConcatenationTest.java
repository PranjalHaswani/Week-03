package com.day6.StringConcatenation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConcatenationTest {

    // Number of concatenations
    private static final int N = 100000;

    @Test
    public void testStringConcatenationPerformance() {
        // Measure time taken by String concatenation
        long startTime = System.nanoTime();
        String string = "";
        for (int i = 0; i < N; i++) {
            string += "a";
        }
        long endTime = System.nanoTime();
        double stringPerformance = (endTime - startTime) / 1e6;

        // Check that time is non-negative
        assertTrue(stringPerformance >= 0, "Time taken by String concatenation should be non-negative.");

        // Measure time taken by StringBuilder concatenation
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        endTime = System.nanoTime();
        double stringBuilderPerformance = (endTime - startTime) / 1e6;

        // Check that time is non-negative
        assertTrue(stringBuilderPerformance >= 0, "Time taken by StringBuilder concatenation should be non-negative.");

        // Measure time taken by StringBuffer concatenation
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a");
        }
        endTime = System.nanoTime();
        double stringBufferPerformance = (endTime - startTime) / 1e6;

        // Check that time is non-negative
        assertTrue(stringBufferPerformance >= 0, "Time taken by StringBuffer concatenation should be non-negative.");

        // Check the performance comparison logic
        assertTrue(stringPerformance >= stringBuilderPerformance, "StringBuilder should be faster than String.");
        assertTrue(stringPerformance >= stringBufferPerformance, "StringBuffer should be faster than String.");
        assertTrue(stringBuilderPerformance <= stringBufferPerformance, "StringBuilder should be faster or equal to StringBuffer.");

        // Output comparison result (for manual inspection)
        System.out.println("String performance: " + stringPerformance + " ms");
        System.out.println("StringBuilder performance: " + stringBuilderPerformance + " ms");
        System.out.println("StringBuffer performance: " + stringBufferPerformance + " ms");
    }
}

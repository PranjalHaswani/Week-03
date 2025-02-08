import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringConcatenationPerformanceTest {

    private static final int N = 10000;

    @Test
    public void testStringPerformance() {
        long startTime = System.nanoTime();
        String string = "";
        for (int i = 0; i < N; i++) {
            string += "a";
        }
        long endTime = System.nanoTime();
        double stringPerformance = (endTime - startTime) / 1e6;

        assertTrue(stringPerformance >= 0, "String concatenation should not have negative time.");
        assertEquals(N, string.length(), "The final string length should be equal to N.");
        System.out.println("Time taken by String: " + stringPerformance + " ms");
    }

    @Test
    public void testStringBuilderPerformance() {
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        long endTime = System.nanoTime();
        double stringBuilderPerformance = (endTime - startTime) / 1e6;

        assertTrue(stringBuilderPerformance >= 0, "StringBuilder concatenation should not have negative time.");
        assertEquals(N, sb.length(), "The final StringBuilder length should be equal to N.");
        System.out.println("Time taken by StringBuilder: " + stringBuilderPerformance + " ms");
    }

    @Test
    public void testStringBufferPerformance() {
        long startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a");
        }
        long endTime = System.nanoTime();
        double stringBufferPerformance = (endTime - startTime) / 1e6;

        assertTrue(stringBufferPerformance >= 0, "StringBuffer concatenation should not have negative time.");
        assertEquals(N, sbf.length(), "The final StringBuffer length should be equal to N.");
        System.out.println("Time taken by StringBuffer: " + stringBufferPerformance + " ms");
    }

    @Test
    public void testComparison() {
        long startTime = System.nanoTime();
        String string = "";
        for (int i = 0; i < N; i++) {
            string += "a";
        }
        long endTime = System.nanoTime();
        double stringPerformance = (endTime - startTime) / 1e6;

        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        endTime = System.nanoTime();
        double stringBuilderPerformance = (endTime - startTime) / 1e6;

        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a");
        }
        endTime = System.nanoTime();
        double stringBufferPerformance = (endTime - startTime) / 1e6;

        // Compare times and print the results
        if (stringPerformance < stringBufferPerformance && stringPerformance < stringBuilderPerformance) {
            System.out.println("String was the fastest.");
        } else if (stringBufferPerformance < stringPerformance && stringBufferPerformance < stringBuilderPerformance) {
            System.out.println("StringBuffer was the fastest.");
        } else {
            System.out.println("StringBuilder was the fastest.");
        }

        assertTrue(stringPerformance >= 0, "String performance should not have negative time.");
        assertTrue(stringBuilderPerformance >= 0, "StringBuilder performance should not have negative time.");
        assertTrue(stringBufferPerformance >= 0, "StringBuffer performance should not have negative time.");
    }
}

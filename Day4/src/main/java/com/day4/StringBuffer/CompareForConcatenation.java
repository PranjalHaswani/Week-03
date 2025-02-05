package com.day4.StringBuffer;

public class CompareForConcatenation {

    // Method to perform string concatenation using StringBuffer
    public static long measureStringBufferTime(int numStrings) {
        // String to concatenate
        String str = "hello";
        long startTime = System.nanoTime();

        // Using StringBuffer for concatenation
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numStrings; i++) {
            stringBuffer.append(str);
        }

        long endTime = System.nanoTime();
        // Return time difference in nanoseconds
        return endTime - startTime;
    }

    // Method to perform string concatenation using StringBuilder
    public static long measureStringBuilderTime(int numStrings) {
        // String to concatenate
        String str = "hello";
        long startTime = System.nanoTime();

        // Using StringBuilder for concatenation
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numStrings; i++) {
            stringBuilder.append(str);
        }

        long endTime = System.nanoTime();
        // Return time difference in nanoseconds
        return endTime - startTime;
    }

    public static void main(String[] args) {
        // Number of strings to concatenate (1 million)
        int numStrings = 1000000;

        // Measure time for StringBuffer
        long timeForStringBuffer = measureStringBufferTime(numStrings);
        System.out.println("Time taken by StringBuffer: " + timeForStringBuffer + " nanoseconds.");

        // Measure time for StringBuilder
        long timeForStringBuilder = measureStringBuilderTime(numStrings);
        System.out.println("Time taken by StringBuilder: " + timeForStringBuilder + " nanoseconds.");
    }
}

package com.day4.InputStreamReader;
import java.io.*;

public class PerformanceProgram {

    public static void main(String[] args) {
        // Test for StringBuilder and StringBuffer concatenation
        long startTime, endTime;

        // Create a list of strings to concatenate
        String str = "hello";

        // Test StringBuilder
        StringBuilder sb = new StringBuilder();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            sb.append(str);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ms");

        // Test StringBuffer
        StringBuffer sbf = new StringBuffer();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            sbf.append(str);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ms");

        // Test FileReader and BufferedReader to read a large file
        File file = new File("C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\Week-3\\Day4\\src\\main\\java\\com\\day4\\InputStreamReader\\File3"); // Assume a large 100MB file exists
        countWordsInFile(file);
    }

    // Method to count words in a file
    public static void countWordsInFile(File file) {
        long startTime, endTime;
        long wordCount = 0;

        // Use FileReader and BufferedReader to read the file
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            startTime = System.currentTimeMillis();
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into words and count them
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            endTime = System.currentTimeMillis();
            System.out.println("Time taken to read the file: " + (endTime - startTime) + " ms");
            System.out.println("Total words in the file: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

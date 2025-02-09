package com.day6.FileReading;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReadingEfficiency {
    public static void main(String[] args) {
        // File Path
        String filePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\DAY-06\\src\\main\\java\\com\\day6\\FileReading\\File1";

        System.out.println("Benchmarking FileReader...");
        long fileReaderTime = measureFileReaderTime(filePath);
        System.out.println("Time taken by FileReader: " + fileReaderTime + " ms\n");

        System.out.println("Benchmarking InputStreamReader...");
        long inputStreamReaderTime = measureInputStreamReaderTime(filePath);
        System.out.println("Time taken by InputStreamReader: " + inputStreamReaderTime + " ms");

        System.out.println("\nComparison:");
        if(inputStreamReaderTime < fileReaderTime) {
            System.out.println("InputStreamReader was the fastest");
        } else {
            System.out.println("FileReader was the fastest");
        }
    }

    // FileReader: Reads character by character
    static long measureFileReaderTime(String filePath) {
        long startTime = System.currentTimeMillis();
        try (FileReader reader = new FileReader(filePath)) {
            // Read character by character
            while (reader.read() != -1) {}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }

    // InputStreamReader: Reads bytes and converts to characters
    static long measureInputStreamReaderTime(String filePath) {
        long startTime = System.currentTimeMillis();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)) {
            char[] buffer = new char[8192]; // Read in chunks
            while (reader.read(buffer) != -1) {} // Read in bulk
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }
}



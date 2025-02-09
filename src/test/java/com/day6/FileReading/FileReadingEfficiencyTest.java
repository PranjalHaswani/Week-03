package com.day6.FileReading;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReadingEfficiencyTest {

    private String filePath;

    @BeforeEach
    public void setUp() throws IOException {
        // Set up a test file to benchmark
        filePath = "testFile.txt";

        // Create a test file with some content
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8)) {
            for (int i = 0; i < 10000; i++) {
                writer.write("This is a test line number " + i + "\n");
            }
        }
    }

    @Test
    public void testFileReaderTime() {
        // Measure time taken by FileReader
        long timeTaken = FileReadingEfficiency.measureFileReaderTime(filePath);

        // Check that the time is non-negative
        assertTrue(timeTaken >= 0, "Time taken by FileReader should be non-negative.");
    }

    @Test
    public void testInputStreamReaderTime() {
        // Measure time taken by InputStreamReader
        long timeTaken = FileReadingEfficiency.measureInputStreamReaderTime(filePath);

        // Check that the time is non-negative
        assertTrue(timeTaken >= 0, "Time taken by InputStreamReader should be non-negative.");
    }

    @Test
    public void testComparison() {
        // Measure time taken by both readers
        long fileReaderTime = FileReadingEfficiency.measureFileReaderTime(filePath);
        long inputStreamReaderTime = FileReadingEfficiency.measureInputStreamReaderTime(filePath);

        // Ensure no exceptions were thrown during the comparison
        assertDoesNotThrow(() -> {
            if (inputStreamReaderTime < fileReaderTime) {
                System.out.println("InputStreamReader was the fastest");
            } else {
                System.out.println("FileReader was the fastest");
            }
        }, "Comparison method should not throw any exceptions.");
    }
}

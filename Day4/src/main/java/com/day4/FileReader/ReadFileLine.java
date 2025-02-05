package com.day4.FileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLine {

    // Method to read and print each line of a file
    public void readFile(String filePath) {
        BufferedReader reader = null;
        try {
            // Create a FileReader object to read from the file
            FileReader fileReader = new FileReader(filePath);

            // Wrap the FileReader in a BufferedReader for efficient line-by-line reading
            reader = new BufferedReader(fileReader);

            String line;

            // Read each line using readLine() and print it to the console
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            // Handle potential IOException
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            try {
                // Close the BufferedReader (and FileReader) after reading
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing the file: " + e.getMessage());
            }
        }
    }
}


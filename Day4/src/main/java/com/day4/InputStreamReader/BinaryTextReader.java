package com.day4.InputStreamReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class BinaryTextReader {

    // Method to read binary data from a file and print it as characters
    public static void readFileAndPrint(String filePath, String charset) {

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            // Read the file line by line and print it
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Print each line to the console
            }
        } catch (IOException e) {

            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    // New method to call readFileAndPrint with specified filePath and charset
    public static void startReading(String filePath, String charset) {

        readFileAndPrint(filePath, charset);
    }

    // Main method to test the functionality directly
    public static void main(String[] args) {

        String filePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\Week-3\\Day4\\src\\main\\java\\com\\day4\\InputStreamReader\\File";
        String charset = "UTF-8";

        startReading(filePath, charset);
    }
}


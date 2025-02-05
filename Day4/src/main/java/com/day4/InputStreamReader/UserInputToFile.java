package com.day4.InputStreamReader;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInputToFile {
    public static void main(String[] args) {
        // InputStreamReader and BufferedReader to read from System.in (console)
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fileWriter = new FileWriter("C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\Week-3\\Day4\\src\\main\\java\\com\\day4\\InputStreamReader\\File2", true)) { // Open file in append mode
            String input;
            System.out.println("Enter text to write to the file (type 'exit' to stop):");

            // Read user input and write to file until "exit" is entered
            while (true) {
                input = br.readLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                fileWriter.write(input + System.lineSeparator()); // Write input followed by a new line
            }

            System.out.println("Input has been written to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

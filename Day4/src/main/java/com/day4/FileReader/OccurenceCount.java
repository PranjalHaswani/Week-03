package com.day4.FileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OccurenceCount {
    // Method to count occurrences of a word in a file
    public static int countWordOccurrences(String filePath, String targetWord) {
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words
                String[] words = line.split("\\s+");
                // Check each word and count occurrences of the target word
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        wordCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordCount;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\Week-3\\Day4\\src\\main\\java\\com\\day4\\FileReader\\File2";
        // The word to search
        String targetWord = "Object";
        int count = countWordOccurrences(filePath, targetWord);
        System.out.println("The word \"" + targetWord + "\" appears " + count + " times.");
    }
}


package com.day5.LinearSearch;

public class SentenceSearch {

    // Method to find the first sentence containing a specific word
    public static String findSentenceWithWord(String[] sentences, String word) {
        // Iterate through the array of sentences
        for (String sentence : sentences) {
            // Check if the sentence contains the specific word
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "Java programming is fun.",
                "I love coding in Java.",
                "Linear search is an algorithm."
        };

        String word = "Java"; // Word to search for

        // Call the method and print the result
        String result = findSentenceWithWord(sentences, word);
        System.out.println(result); // Output the sentence or "Not Found"
    }
}
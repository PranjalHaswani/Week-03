import static org.junit.jupiter.api.Assertions.*;

import com.day5.LinearSearch.SentenceSearch;
import org.junit.jupiter.api.Test;

class SentenceSearchTest {

    @Test
    void testFindSentenceWithWord() {
        // Test with sentences containing the word "Java"
        String[] sentences1 = {
                "Java programming is fun.",
                "I love coding in Java.",
                "Linear search is an algorithm."
        };
        String word1 = "Java";
        String result1 = SentenceSearch.findSentenceWithWord(sentences1, word1);
        assertEquals("Java programming is fun.", result1, "The first sentence containing 'Java' should be returned.");

        // Test with sentences containing the word "algorithm"
        String[] sentences2 = {
                "Java programming is fun.",
                "I love coding in Java.",
                "Linear search is an algorithm."
        };
        String word2 = "algorithm";
        String result2 = SentenceSearch.findSentenceWithWord(sentences2, word2);
        assertEquals("Linear search is an algorithm.", result2, "The first sentence containing 'algorithm' should be returned.");

        // Test with no sentence containing the word "Python"
        String[] sentences3 = {
                "Java programming is fun.",
                "I love coding in Java.",
                "Linear search is an algorithm."
        };
        String word3 = "Python";
        String result3 = SentenceSearch.findSentenceWithWord(sentences3, word3);
        assertEquals("Not Found", result3, "If no sentence contains the word, 'Not Found' should be returned.");
    }
}
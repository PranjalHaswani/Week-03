import com.day4.InputStreamReader.PerformanceProgram;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

class PerformanceTest {

    @Test
    void testStringConcatenationPerformance() {
        long startTime, endTime;

        // Test StringBuilder
        StringBuilder sb = new StringBuilder();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }
        endTime = System.currentTimeMillis();
        long stringBuilderTime = endTime - startTime;
        System.out.println("StringBuilder time: " + stringBuilderTime + " ms");

        // Test StringBuffer
        StringBuffer sbf = new StringBuffer();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            sbf.append("hello");
        }
        endTime = System.currentTimeMillis();
        long stringBufferTime = endTime - startTime;
        System.out.println("StringBuffer time: " + stringBufferTime + " ms");

        // Check if StringBuilder is faster
        assertTrue(stringBuilderTime < stringBufferTime, "StringBuilder should be faster than StringBuffer in this scenario.");
    }

    @Test
    void testWordCountInLargeFile() {
        File file = new File("C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\Week-3\\Day4\\src\\main\\java\\com\\day4\\InputStreamReader\\File3");
        assertTrue(file.exists(), "The file largeFile.txt must exist for this test.");

        // Run the word count method
        PerformanceProgram.countWordsInFile(file);
    }
}

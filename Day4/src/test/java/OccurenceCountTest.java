import com.day4.FileReader.OccurenceCount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

public class OccurenceCountTest {
    // Helper method to create a sample file for testing
    private void createSampleFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Object Oriented Programming works on concept of Object and classes.\n");
            writer.write("Object Oriented Programming helps us in solving real world problems.\n");
            writer.write("Object oriented programming works on four pillars.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCountWordOccurrences() {
        String filePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\Week-3\\Day4\\src\\main\\java\\com\\day4\\FileReader\\File2";
        String targetWord = "Object";

        createSampleFile(filePath);

        // Run the method to count occurrences
        int count = OccurenceCount.countWordOccurrences(filePath, targetWord);

        // Assert the word appears 4 times in the sample file
        assertEquals(4, count);
    }
}


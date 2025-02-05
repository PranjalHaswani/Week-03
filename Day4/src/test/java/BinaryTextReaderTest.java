import com.day4.InputStreamReader.BinaryTextReader;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class BinaryTextReaderTest{

    // Helper method to create a test file with sample content
    private static void createTestFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content); // Write the test content to the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Define the file path and content
        String filePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\Week-3\\Day4\\src\\main\\java\\com\\day4\\InputStreamReader\\File";
        String content = "UTF-8";

        // Create a test file with the content
        createTestFile(filePath, content);

        // Call the method to read and print the file contents
        BinaryTextReader.startReading(filePath, "UTF-8");

    }
}

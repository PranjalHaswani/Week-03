import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserInputToFileTest {

    @Test
    void testWriteInputToFile() {
        try {
            // Simulate user input and write to file
            String testInput = "Hello, Hope you are doing well.";

            String expectedOutput = "Hello, Hope you are doing well." + System.lineSeparator();

            // Prepare the file writer and simulate writing to file
            FileWriter fileWriter = new FileWriter("C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\Week-3\\Day4\\src\\main\\java\\com\\day4\\InputStreamReader\\File2");
            fileWriter.write(testInput + System.lineSeparator());
            fileWriter.close();

            // Read the file content back to verify
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\Week-3\\Day4\\src\\main\\java\\com\\day4\\InputStreamReader\\File2"));
            String actualOutput = bufferedReader.readLine();
            bufferedReader.close();
            // Verify the output
            assertEquals(expectedOutput.trim(), actualOutput.trim());
        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException occurred during test.");
        }
    }
}

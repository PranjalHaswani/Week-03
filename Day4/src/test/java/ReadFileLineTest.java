import com.day4.FileReader.ReadFileLine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ReadFileLineTest {

    @Test
    void test() {

        String filePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\Week-3\\Day4\\src\\main\\java\\com\\day4\\FileReader\\File";

        // Create an instance of ReadFileLine
        ReadFileLine obj = new ReadFileLine();

        // Redirect System.out to capture printed lines
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        obj.readFile(filePath);
        String output = outputStream.toString();

        assertTrue(output.contains("Hello Students, Hope you are doing well."));
    }
}

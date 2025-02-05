import com.day4.StringBuilder.ReverseString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringTest {
    @Test
    void test(){
        ReverseString obj= new ReverseString();
        String str= "hello";
        assertEquals("olleh", obj.reverseString(str));
    }
}
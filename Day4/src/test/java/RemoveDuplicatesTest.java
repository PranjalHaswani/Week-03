import com.day4.StringBuilder.RemoveDuplicates;
import com.day4.StringBuilder.ReverseString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseDuplicatesTest {
    @Test
    void test(){
        RemoveDuplicates obj= new RemoveDuplicates();
        String str= "Hello children, How are you?";
        assertEquals("Helo chidrn,wayu?", obj.removeDuplicates(str));
    }
}
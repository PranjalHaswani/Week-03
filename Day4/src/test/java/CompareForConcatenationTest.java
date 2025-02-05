import com.day4.StringBuffer.CompareForConcatenation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompareForConcatenateStringTest {
    @Test
    void test(){
        CompareForConcatenation obj1= new CompareForConcatenation();
        CompareForConcatenation obj2= new CompareForConcatenation();
        int abs= 1000000;
        assertEquals("Time taken by StringBuffer: 34482400 nanoseconds.", obj1.measureStringBufferTime(abs));
        assertEquals("Time taken by StringBuilder: 21449500 nanoseconds.",obj2.measureStringBuilderTime(abs));
    }
}

import com.day4.StringBuffer.ConcatenateStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcatenateStringTest{
    @Test
    void test(){
        ConcatenateStrings obj= new ConcatenateStrings();
        String[] str= {"Hello", " ", "Children", " How", " Are", " You", " ?"};
        assertEquals("Hello Children How Are You ?", obj.stringConcatenate(str));
    }
}
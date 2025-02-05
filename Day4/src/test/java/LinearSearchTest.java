import static org.junit.jupiter.api.Assertions.*;

import com.day5.LinearSearch.LinearSearch;
import org.junit.jupiter.api.Test;

class LinearSearchTest {

    @Test
    void testFindFirstNegative() {
        // Test with an array that contains a negative number
        int[] array1 = {3, 5, -1, 4, 2};
        int result1 = LinearSearch.findFirstNegative(array1);
        assertEquals(2, result1, "The first negative number should be at index 2.");

        // Test with an array where no negative number is present
        int[] array2 = {3, 5, 1, 4, 2};
        int result2 = LinearSearch.findFirstNegative(array2);
        assertEquals(-1, result2, "There should be no negative number, so the result should be -1.");

        // Test with an array where the first element is negative
        int[] array3 = {-3, 5, 1, 4, 2};
        int result3 = LinearSearch.findFirstNegative(array3);
        assertEquals(0, result3, "The first negative number should be at index 0.");

        // Test with an array that only contains negative numbers
        int[] array4 = {-1, -5, -3};
        int result4 = LinearSearch.findFirstNegative(array4);
        assertEquals(0, result4, "The first negative number should be at index 0.");

        // Test with an empty array
        int[] array5 = {};
        int result5 = LinearSearch.findFirstNegative(array5);
        assertEquals(-1, result5, "An empty array should return -1.");
    }
}
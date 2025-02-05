import static org.junit.jupiter.api.Assertions.*;

import com.day5.BinarySearch.RotateArraySearch;
import org.junit.jupiter.api.Test;

class RotateArraySearchTest {

    @Test
    void testFindRotationPoint() {
        // Test case 1: Normal rotated array
        int[] arr1 = {6, 7, 9, 15, 19, 2, 3};
        int result1 = RotateArraySearch.findRotationPoint(arr1);
        assertEquals(5, result1, "The rotation point should be at index 5.");
        assertEquals(2, arr1[result1], "The smallest element should be 2.");

        // Test case 2: Array with no rotation (sorted array)
        int[] arr2 = {1, 2, 3, 4, 5};
        int result2 = RotateArraySearch.findRotationPoint(arr2);
        assertEquals(0, result2, "The rotation point should be at index 0.");
        assertEquals(1, arr2[result2], "The smallest element should be 1.");

        // Test case 3: Array with only one element
        int[] arr3 = {5};
        int result3 = RotateArraySearch.findRotationPoint(arr3);
        assertEquals(0, result3, "The rotation point should be at index 0.");
        assertEquals(5, arr3[result3], "The smallest element should be 5.");

        // Test case 4: Array with all elements the same (no real rotation)
        int[] arr4 = {7, 7, 7, 7, 7};
        int result4 = RotateArraySearch.findRotationPoint(arr4);
        assertEquals(0, result4, "The rotation point should be at index 0.");
        assertEquals(7, arr4[result4], "The smallest element should be 7.");

        // Test case 5: Array with multiple rotations
        int[] arr5 = {10, 15, 20, 25, 30, 5, 7};
        int result5 = RotateArraySearch.findRotationPoint(arr5);
        assertEquals(5, result5, "The rotation point should be at index 5.");
        assertEquals(5, arr5[result5], "The smallest element should be 5.");
    }
}

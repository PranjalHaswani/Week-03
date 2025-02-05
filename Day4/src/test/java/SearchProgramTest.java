import static org.junit.jupiter.api.Assertions.*;

import com.day5.BinarySearch.SearchProgram;
import org.junit.jupiter.api.Test;

public class SearchProgramTest {

    // Test the firstMissingPositive method
    @Test
    public void testFirstMissingPositive() {
        // Test case 1: Standard case with positive and negative integers
        int[] nums1 = {3, 4, -1, 1};
        assertEquals(2, SearchProgram.firstMissingPositive(nums1)); // Expected: 2

        // Test case 2: Array with numbers in sequence starting from 1
        int[] nums2 = {1, 2, 3};
        assertEquals(4, SearchProgram.firstMissingPositive(nums2)); // Expected: 4

        // Test case 3: Array with all negative numbers
        int[] nums3 = {-1, -2, -3};
        assertEquals(1, SearchProgram.firstMissingPositive(nums3)); // Expected: 1

        // Test case 4: Array with no missing positive numbers
        int[] nums4 = {1, 2, 3, 4};
        assertEquals(5, SearchProgram.firstMissingPositive(nums4)); // Expected: 5

        // Test case 5: Array with a single element greater than 1
        int[] nums5 = {10};
        assertEquals(1, SearchProgram.firstMissingPositive(nums5)); // Expected: 1

        // Test case 6: Array with only zeros
        int[] nums6 = {0, 0, 0};
        assertEquals(1, SearchProgram.firstMissingPositive(nums6)); // Expected: 1
    }

    // Test the binarySearch method
    @Test
    public void testBinarySearch() {
        // Test case 1: Target present in the array
        int[] sortedNums1 = {1, 3, 4, 5, 6};
        int target1 = 4;
        assertEquals(2, SearchProgram.binarySearch(sortedNums1, target1)); // Expected: 2

        // Test case 2: Target not present in the array
        int[] sortedNums2 = {1, 3, 4, 5, 6};
        int target2 = 2;
        assertEquals(-1, SearchProgram.binarySearch(sortedNums2, target2)); // Expected: -1

        // Test case 3: Target is the first element
        int[] sortedNums3 = {1, 3, 4, 5, 6};
        int target3 = 1;
        assertEquals(0, SearchProgram.binarySearch(sortedNums3, target3)); // Expected: 0

        // Test case 4: Target is the last element
        int[] sortedNums4 = {1, 3, 4, 5, 6};
        int target4 = 6;
        assertEquals(4, SearchProgram.binarySearch(sortedNums4, target4)); // Expected: 4

        // Test case 5: Empty array
        int[] sortedNums5 = {};
        int target5 = 4;
        assertEquals(-1, SearchProgram.binarySearch(sortedNums5, target5)); // Expected: -1 (empty array)

        // Test case 6: Array with one element (element is present)
        int[] sortedNums6 = {5};
        int target6 = 5;
        assertEquals(0, SearchProgram.binarySearch(sortedNums6, target6)); // Expected: 0 (only one element)

        // Test case 7: Array with one element (element is not present)
        int[] sortedNums7 = {5};
        int target7 = 3;
        assertEquals(-1, SearchProgram.binarySearch(sortedNums7, target7)); // Expected: -1 (element not found)
    }
}

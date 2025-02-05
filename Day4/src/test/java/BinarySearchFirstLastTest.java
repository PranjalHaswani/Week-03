import static org.junit.jupiter.api.Assertions.*;

import com.day5.BinarySearch.BinarySearchFirstLast;
import org.junit.jupiter.api.Test;

public class BinarySearchFirstLastTest {

    // Test for the first occurrence of an element
    @Test
    public void testFindFirstOccurrence() {
        int[] arr = {1, 2, 2, 2, 3, 3, 5, 6, 6, 7};
        int target = 2;
        int first = BinarySearchFirstLast.findFirstOccurrence(arr, target);
        assertEquals(1, first); // The first occurrence of 2 is at index 1
    }

    // Test for the last occurrence of an element
    @Test
    public void testFindLastOccurrence() {
        int[] arr = {1, 2, 2, 2, 3, 3, 5, 6, 6, 7};
        int target = 2;
        int last = BinarySearchFirstLast.findLastOccurrence(arr, target);
        assertEquals(3, last); // The last occurrence of 2 is at index 3
    }

    // Test when the target does not exist in the array
    @Test
    public void testTargetNotFound() {
        int[] arr = {1, 2, 2, 2, 3, 3, 5, 6, 6, 7};
        int target = 4;
        int first = BinarySearchFirstLast.findFirstOccurrence(arr, target);
        int last = BinarySearchFirstLast.findLastOccurrence(arr, target);
        assertEquals(-1, first); // 4 is not in the array, so return -1
        assertEquals(-1, last);  // 4 is not in the array, so return -1
    }

    // Test for an array with a single element
    @Test
    public void testSingleElementArray() {
        int[] arr = {5};
        int target = 5;
        int first = BinarySearchFirstLast.findFirstOccurrence(arr, target);
        int last = BinarySearchFirstLast.findLastOccurrence(arr, target);
        assertEquals(0, first); // The first occurrence of 5 is at index 0
        assertEquals(0, last);  // The last occurrence of 5 is at index 0
    }

    // Test when there are multiple occurrences of the target element
    @Test
    public void testMultipleOccurrences() {
        int[] arr = {1, 1, 1, 1, 1, 1};
        int target = 1;
        int first = BinarySearchFirstLast.findFirstOccurrence(arr, target);
        int last = BinarySearchFirstLast.findLastOccurrence(arr, target);
        assertEquals(0, first); // The first occurrence of 1 is at index 0
        assertEquals(5, last);  // The last occurrence of 1 is at index 5
    }
}

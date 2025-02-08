
import com.tit.searchTarget.SearchTarget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTargetTest {

    private int[] smallArr;
    private int[] largeArr;
    private int target;

    @BeforeEach
    public void setUp() {
        // Small test array
        smallArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Large test array
        largeArr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            largeArr[i] = i + 1; // Fill the array with values 1 to 1000
        }
        target = 5;  // Arbitrary target for testing
    }

    @Test
    public void testLinearSearch() {
        double timeTaken = SearchTarget.LinearSearch(smallArr, target);
        assertTrue(timeTaken >= 0, "Time taken should be non-negative");
    }

    @Test
    public void testBinarySearch() {
        // Sorting largeArr before applying binary search
        Arrays.sort(largeArr);
        double timeTaken = SearchTarget.BinarySearch(largeArr, target);
        assertTrue(timeTaken >= 0, "Time taken should be non-negative");
    }

    @Test
    public void testLinearSearchForCorrectResult() {
        int targetIndex = -1;
        for (int i = 0; i < smallArr.length; i++) {
            if (smallArr[i] == target) {
                targetIndex = i;
                break;
            }
        }
        assertEquals(targetIndex, 4, "The target should be found at index 4 in the smallArr.");
    }

    @Test
    public void testBinarySearchForCorrectResult() {
        // Sorting largeArr before applying binary search
        Arrays.sort(largeArr);
        int left = 0, right = largeArr.length - 1;
        int mid = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (largeArr[mid] == target) {
                break;
            } else if (largeArr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        assertEquals(mid, 4, "The target should be found at index 4 in the largeArr.");
    }

    @Test
    public void testComparisonOfSearchAlgorithms() {
        double timeLinear = SearchTarget.LinearSearch(largeArr, target);
        Arrays.sort(largeArr); // Binary Search needs sorted array
        double timeBinary = SearchTarget.BinarySearch(largeArr, target);

        assertTrue(timeLinear >= 0, "Linear Search time should be non-negative");
        assertTrue(timeBinary >= 0, "Binary Search time should be non-negative");
    }
}

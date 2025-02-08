import com.tit.SortingLargeData.SortLargeData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SortLargeDataTest {

    private int[] smallArr;
    private int[] mediumArr;
    private int[] largeArr;
    private Random random;

    @BeforeEach
    public void setUp() {
        // Initialize arrays with random numbers
        random = new Random();

        // Small, medium, and large arrays for testing
        smallArr = new int[100];
        mediumArr = new int[1000];
        largeArr = new int[10000];

        fillArray(smallArr);
        fillArray(mediumArr);
        fillArray(largeArr);
    }

    // Helper method to fill arrays with random integers
    private void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length);
        }
    }

    @Test
    public void testBubbleSort() {
        int[] arr = smallArr.clone();
        double timeTaken = SortLargeData.bubbleSort(arr);

        assertTrue(timeTaken >= 0, "Bubble Sort time should be non-negative.");
        assertTrue(isSorted(arr), "Array should be sorted after bubble sort.");
    }

    @Test
    public void testMergeSort() {
        int[] arr = smallArr.clone();
        double timeTaken = SortLargeData.mergeSort(arr);

        assertTrue(timeTaken >= 0, "Merge Sort time should be non-negative.");
        assertTrue(isSorted(arr), "Array should be sorted after merge sort.");
    }

    @Test
    public void testQuickSort() {
        int[] arr = smallArr.clone();
        double timeTaken = SortLargeData.quickSort(arr);

        assertTrue(timeTaken >= 0, "Quick Sort time should be non-negative.");
        assertTrue(isSorted(arr), "Array should be sorted after quick sort.");
    }

    @Test
    public void testComparisonForSmallArray() {
        int[] arrBubble = smallArr.clone();
        int[] arrMerge = smallArr.clone();
        int[] arrQuick = smallArr.clone();

        double bubbleTime = SortLargeData.bubbleSort(arrBubble);
        double mergeTime = SortLargeData.mergeSort(arrMerge);
        double quickTime = SortLargeData.quickSort(arrQuick);

        SortLargeData.compare(bubbleTime, mergeTime, quickTime);
    }

    @Test
    public void testComparisonForMediumArray() {
        int[] arrBubble = mediumArr.clone();
        int[] arrMerge = mediumArr.clone();
        int[] arrQuick = mediumArr.clone();

        double bubbleTime = SortLargeData.bubbleSort(arrBubble);
        double mergeTime = SortLargeData.mergeSort(arrMerge);
        double quickTime = SortLargeData.quickSort(arrQuick);

        SortLargeData.compare(bubbleTime, mergeTime, quickTime);
    }

    @Test
    public void testComparisonForLargeArray() {
        int[] arrBubble = largeArr.clone();
        int[] arrMerge = largeArr.clone();
        int[] arrQuick = largeArr.clone();

        double bubbleTime = SortLargeData.bubbleSort(arrBubble);
        double mergeTime = SortLargeData.mergeSort(arrMerge);
        double quickTime = SortLargeData.quickSort(arrQuick);

        SortLargeData.compare(bubbleTime, mergeTime, quickTime);
    }

    // Helper method to check if an array is sorted
    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testEmptyArray() {
        int[] emptyArr = new int[0];

        // Test all three algorithms on an empty array
        double bubbleTime = SortLargeData.bubbleSort(emptyArr);
        double mergeTime = SortLargeData.mergeSort(emptyArr);
        double quickTime = SortLargeData.quickSort(emptyArr);

        assertTrue(bubbleTime >= 0, "Bubble Sort time should be non-negative for empty array.");
        assertTrue(mergeTime >= 0, "Merge Sort time should be non-negative for empty array.");
        assertTrue(quickTime >= 0, "Quick Sort time should be non-negative for empty array.");
    }
}

import static org.junit.jupiter.api.Assertions.*;

import com.day5.BinarySearch.PeakElement;
import org.junit.jupiter.api.Test;

public class PeakElementTest {

    // Test case 1: Array with a clear peak element
    @Test
    public void testFindPeakElement_ClearPeak() {
        int[] arr1 = {1, 3, 20, 4, 1, 0};
        int peakIndex1 = PeakElement.findPeakElement(arr1);
        assertEquals(2, peakIndex1); // The peak is at index 2 (value 20)
    }

    // Test case 2: Array where the peak is at the beginning
    @Test
    public void testFindPeakElement_PeakAtBeginning() {
        int[] arr2 = {10, 9, 8, 7, 6};
        int peakIndex2 = PeakElement.findPeakElement(arr2);
        assertEquals(0, peakIndex2); // The peak is at index 0 (value 10)
    }

    // Test case 3: Array where the peak is at the end
    @Test
    public void testFindPeakElement_PeakAtEnd() {
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int peakIndex3 = PeakElement.findPeakElement(arr3);
        // The peak could be at index 8 (value 9)
        assertTrue(peakIndex3 == 8);
    }

    // Test case 4: Array with multiple peaks
    @Test
    public void testFindPeakElement_MultiplePeaks() {
        int[] arr4 = {1, 3, 4, 5, 3, 2, 1};
        int peakIndex4 = PeakElement.findPeakElement(arr4);
        // The peak could be at index 3 (value 5) or index 1 (value 3), so we check for both
        assertTrue(peakIndex4 == 1 || peakIndex4 == 3);
    }

    // Test case 5: Array with only one element (edge case)
    @Test
    public void testFindPeakElement_OneElement() {
        int[] arr5 = {10};
        int peakIndex5 = PeakElement.findPeakElement(arr5);
        assertEquals(0, peakIndex5); // The only element is a peak
    }

    // Test case 6: Array with two elements, peak at the first element
    @Test
    public void testFindPeakElement_TwoElements_PeakAtFirst() {
        int[] arr6 = {10, 5};
        int peakIndex6 = PeakElement.findPeakElement(arr6);
        assertEquals(0, peakIndex6); // The peak is at index 0 (value 10)
    }

    // Test case 7: Array with two elements, peak at the second element
    @Test
    public void testFindPeakElement_TwoElements_PeakAtSecond() {
        int[] arr7 = {1, 10};
        int peakIndex7 = PeakElement.findPeakElement(arr7);
        assertEquals(1, peakIndex7); // The peak is at index 1 (value 10)
    }
}

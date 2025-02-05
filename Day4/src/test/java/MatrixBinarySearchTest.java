import static org.junit.jupiter.api.Assertions.*;

import com.day5.BinarySearch.MatrixBinarySearch;
import org.junit.jupiter.api.Test;

public class MatrixBinarySearchTest {

    // Test case 1: Matrix with target present
    @Test
    public void testSearchMatrix_TargetPresent() {
        int[][] matrix1 = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        int target1 = 4;
        assertTrue(MatrixBinarySearch.searchMatrix(matrix1, target1)); // Expected: true
    }

    // Test case 2: Matrix with target not present
    @Test
    public void testSearchMatrix_TargetNotPresent() {
        int[][] matrix2 = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        int target2 = 20;
        assertFalse(MatrixBinarySearch.searchMatrix(matrix2, target2)); // Expected: false
    }

    // Test case 3: Empty matrix
    @Test
    public void testSearchMatrix_EmptyMatrix() {
        int[][] matrix3 = {};
        int target3 = 3;
        assertFalse(MatrixBinarySearch.searchMatrix(matrix3, target3)); // Expected: false
    }

    // Test case 4: Matrix with a single element (target found)
    @Test
    public void testSearchMatrix_SingleElementTargetFound() {
        int[][] matrix4 = {
                {1}
        };
        int target4 = 1;
        assertTrue(MatrixBinarySearch.searchMatrix(matrix4, target4)); // Expected: true
    }

    // Test case 5: Matrix with a single element (target not found)
    @Test
    public void testSearchMatrix_SingleElementTargetNotFound() {
        int[][] matrix4 = {
                {1}
        };
        int target4 = 2;
        assertFalse(MatrixBinarySearch.searchMatrix(matrix4, target4)); // Expected: false
    }

    // Test case 6: Matrix with multiple rows and columns (target found)
    @Test
    public void testSearchMatrix_MultipleRowsColumns_TargetFound() {
        int[][] matrix5 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int target5 = 8;
        assertTrue(MatrixBinarySearch.searchMatrix(matrix5, target5)); // Expected: true
    }

    // Test case 7: Matrix with multiple rows and columns (target not found)
    @Test
    public void testSearchMatrix_MultipleRowsColumns_TargetNotFound() {
        int[][] matrix6 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int target6 = 10;
        assertFalse(MatrixBinarySearch.searchMatrix(matrix6, target6)); // Expected: false
    }
}

package com.day5.BinarySearch;


public class MatrixBinarySearch {

    // Method to perform binary search on the 2D matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            // Return false if the matrix is empty
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            // Find the middle index
            int mid = left + (right - left) / 2;

            // Convert the mid index to row and column indices
            int midRow = mid / cols;
            int midCol = mid % cols;

            // Compare the middle element with the target
            if (matrix[midRow][midCol] == target) {
                return true;
            } else if (matrix[midRow][midCol] < target) {
                // Target is larger, move right
                left = mid + 1;
            } else {
                // Target is smaller, move left
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test case 1: Matrix with target present
        int[][] matrix1 = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        int target1 = 4;
        System.out.println("Target " + target1 + " found: " + searchMatrix(matrix1, target1));

        // Test case 2: Matrix with target not present
        int[][] matrix2 = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        int target2 = 20;
        System.out.println("Target " + target2 + " found: " + searchMatrix(matrix2, target2)); // Expected: false

        // Test case 3: Empty matrix
        int[][] matrix3 = {};
        int target3 = 3;
        System.out.println("Target " + target3 + " found: " + searchMatrix(matrix3, target3)); // Expected: false

        // Test case 4: Matrix with a single element
        int[][] matrix4 = {
                {1}
        };
        int target4 = 1;
        System.out.println("Target " + target4 + " found: " + searchMatrix(matrix4, target4)); // Expected: true

        // Test case 5: Matrix with multiple rows and columns
        int[][] matrix5 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int target5 = 8;
        System.out.println("Target " + target5 + " found: " + searchMatrix(matrix5, target5)); // Expected: true
    }
}



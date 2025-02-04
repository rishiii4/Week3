package binarysearch;

public class MatrixSearch {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true; // Target found
            } else if (midValue < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return false; // Target not found
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {7, 10, 11},
                {12, 14, 16}
        };
        int target = 10; // Example target value
        boolean found = searchMatrix(matrix, target);
        System.out.println("Target found: " + found);
    }
}

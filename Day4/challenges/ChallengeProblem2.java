package challenges;

import java.util.Arrays;

public class ChallengeProblem2 {

    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] present = new boolean[n + 1];

        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i; // Return the first missing positive integer
            }
        }
        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1}; // Example list of integers
        int target = 4; // Example target value

        int missingPositive = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missingPositive);

        Arrays.sort(arr); // Sort the array before binary search
        int index = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}

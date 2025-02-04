package binarysearch;

public class RotationPointFinder {

    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1; // Smallest element is in the right half
            } else {
                right = mid; // Smallest element is in the left half
            }
        }
        return left; // Rotation point index
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2}; // Example rotated sorted array
        int index = findRotationPoint(arr);
        System.out.println("Rotation point index: " + index);
    }
}

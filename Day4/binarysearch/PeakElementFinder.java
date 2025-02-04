package binarysearch;

public class PeakElementFinder {

    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid; // Search in the left half
            } else {
                left = mid + 1; // Search in the right half
            }
        }
        return left; // Peak element index
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0}; // Example array
        int index = findPeakElement(arr);
        System.out.println("Peak element index: " + index);
    }
}

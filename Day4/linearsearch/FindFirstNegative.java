package linearsearch;

public class FindFirstNegative {

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; // Return the index of the first negative number
            }
        }
        return -1; // Return -1 if no negative number is found
    }
    public static void main(String[] args) {
        int[] numbers = {3, 5, 7, -2, 8, -6, 10}; // Example array
        int index = findFirstNegative(numbers);
        System.out.println("First negative number is at index: " + index);
    }
}

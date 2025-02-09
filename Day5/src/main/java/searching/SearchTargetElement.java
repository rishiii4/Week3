package searching;

import java.util.Arrays;


public class SearchTargetElement {
    public static void main(String[] args) {

        int dataset[] = new int[10_00_000];

        // Inserting values in array
        for (int i = 0; i < dataset.length; i++) {
            dataset[i] =  i;
        }

        Arrays.sort(dataset); // Sorting array

        // Calculating time taken by linear search
        LinearSearch linearSearch = new LinearSearch();

        long startTimeL = System.nanoTime(); // Start time
        int idx = linearSearch.findTarget(dataset, 10_00_000 - 1);
        long endTimeL = System.nanoTime(); // End time

        System.out.println("Target is at Index: "+idx);
        System.out.println("Time Taken by Linear Search: " + (endTimeL - startTimeL)+" ms");


        // Calculating time taken by binary search
        BinarySearch binarySearch = new BinarySearch();

        long startTime = System.nanoTime(); // Start time
        int idxBinary = binarySearch.findTarget(dataset, 10_00_000 - 1);
        long endTime = System.nanoTime(); // End time

        System.out.println("Target is at Index: "+idxBinary);
        System.out.println("Time Taken by Binary Search: " + (endTime - startTime) +" ms");
    }
}

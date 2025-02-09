package sorting;

import java.util.Arrays;
import java.util.Random;

public class SortingMain {
    public static void main(String[] args) {
        int[] dataSet = new int[10_000];

        // Inserting random values in array
        Random random = new Random();
        for (int i = 0; i < dataSet.length; i++) {
            dataSet[i] = random.nextInt();
        }

        // Copying data of array to new array for future use
        int[] copyData = dataSet.clone();

        // Calculating time taken by bubble sort
        BubbleSort bubble = new BubbleSort();

        long bubbleStart = System.nanoTime(); // Start time
        bubble.bubbleSort(dataSet);
        long bubbleEnd = System.nanoTime(); // End time

        System.out.println(Arrays.toString(dataSet));
        System.out.println("Time Taken by Bubble Sort: "+ (bubbleEnd - bubbleStart)+" ms");

        dataSet = copyData.clone(); // Updating dataSet array

        // Calculating time taken by merge sort
        MergeSort merge = new MergeSort();

        long mergeStart = System.nanoTime(); // Start time
        merge.mergeSort(dataSet,0, dataSet.length-1);
        long mergeEnd = System.nanoTime(); // End time

        System.out.println(Arrays.toString(dataSet));
        System.out.println("Time Taken by Merge Sort: "+ (mergeEnd - mergeStart)+" ms");

        dataSet = copyData.clone(); // Updating dataSet array

        // Calculating time taken by quick sort
        QuickSort quick = new QuickSort();

        long quickStart = System.nanoTime(); // Start time
        quick.quickSort(dataSet, 0, dataSet.length-1);
        long quickEnd = System.nanoTime(); // End time

        System.out.println(Arrays.toString(dataSet));
        System.out.println("Time Taken by Quick Sort: "+ (quickEnd - quickStart)+" ms");

    }
}

package sortingalgorithms.quicksort;

import java.util.Arrays;

public class SortProductPrices {

    //Quick Sort function
    public static void quickSort(int prices[], int low, int high) {
        if (low < high) {
            int partitionIndex = partition(prices, low, high);
            quickSort(prices, low, partitionIndex - 1);
            quickSort(prices, partitionIndex + 1, high);
        }
    }

    //Partition function
    private static int partition(int prices[], int low, int high) {
        //Choosing the last element as pivot
        int pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                swap(prices, i, j);
            }
        }
        swap(prices, i + 1, high);
        return i + 1;
    }

    //Swap function
    private static void swap(int prices[], int i, int j) {
        int temp = prices[i];
        prices[i] = prices[j];
        prices[j] = temp;
    }

    public static void main(String[] args) {
        int productPrices[] = {199, 999, 499, 299, 1499, 799};

        quickSort(productPrices, 0, productPrices.length - 1);
        System.out.println(Arrays.toString(productPrices));
    }
}

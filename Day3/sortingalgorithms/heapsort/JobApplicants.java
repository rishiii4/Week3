package sortingalgorithms.heapsort;

import java.util.Arrays;

public class JobApplicants {

    //Heap Sort function
    public static void heapSort(double salaries[]) {
        int n = salaries.length;

        //Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        //Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(salaries, 0, i);
            heapify(salaries, i, 0);
        }
    }

    //Heapify function
    private static void heapify(double salaries[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(salaries, i, largest);
            heapify(salaries, n, largest);
        }
    }

    //Swap function
    private static void swap(double salaries[], int i, int j) {
        double temp = salaries[i];
        salaries[i] = salaries[j];
        salaries[j] = temp;
    }

    public static void main(String[] args) {

        double salaryDemands[] = {55000, 70000, 48000, 60000, 75000, 50000};


        heapSort(salaryDemands);
        System.out.println(Arrays.toString(salaryDemands));
    }
}


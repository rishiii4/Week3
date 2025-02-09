package comparingdatastructures;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class ComparingDiffDataStructures {
    public static void main(String[] args) {
        LinearSearch linear = new LinearSearch();
        HashSearch hash = new HashSearch();
        BST bst = new BST();

        int n = 1_000_000;
        // Generating dataset
        Random rand = new Random();
        int[] array = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int num = rand.nextInt(n * 10);
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        // Random element to search
        int target = array[rand.nextInt(n)];

        // Calculating time taken by linear search
        long startLinear = System.nanoTime(); // Start time
        boolean linearSearch = linear.find(array, target);
        long endLinear = System.nanoTime(); // End time

        System.out.println("Target Found using linear: "+linearSearch);
        System.out.println("Time taken by linear search: "+(endLinear - startLinear)+" ms");

        // Calculating time taken by hash search
        long startHash = System.nanoTime(); // Start time
        boolean hashSearch = hash.find(hashSet, target);
        long endHash = System.nanoTime(); // End time

        System.out.println("Target Found using Hash: "+hashSearch);
        System.out.println("Time taken by linear search: "+(endHash - startHash)+" ms");

        // Calculating time taken by BST
        long startBST = System.nanoTime(); // Start time
        boolean binarySearch = bst.find(treeSet, target);
        long endBST = System.nanoTime(); // End time

        System.out.println("Target Found using BST: "+hashSearch);
        System.out.println("Time taken by BST: "+(endBST - startBST)+" ms");

    }
}

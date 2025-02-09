package fibonaccicomputation;

public class FibonacciComputation {
    public static void main(String[] args) {
        int n = 20;
        FibonacciRecursive fiboRecursive = new FibonacciRecursive();
        FibonacciIterative fiboIterative = new FibonacciIterative();

        // Calculating time taken by Recursive method
        long startRecursive = System.nanoTime(); // Start time
        int fibRecursive = fiboRecursive.fibonacciRecursive(n);
        long endRecursive = System.nanoTime(); // End time

        System.out.println("Recursive Fibonacci Result: " + fibRecursive);
        System.out.println("Recursive Time: " + (endRecursive - startRecursive) + " ms");

        // Calculating time taken by Iterative method
        long startIterative = System.nanoTime(); // Start time
        int fibIterative = fiboIterative.fibonacciIterative(n);
        long endIterative = System.nanoTime(); // End time

        System.out.println("Iterative Fibonacci Result: " + fibIterative);
        System.out.println("Iterative Time: " + (endIterative - startIterative) + " ms");
    }
}

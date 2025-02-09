package stringconcatenation;

public class StringPerformance {
    public void stringPerformance(){
        String str = "Hey";

        // Calculating time take by string
        long startTime = System.nanoTime(); // Start time
        for(int i=0;i<10_000;i++){
            str += "Hey";
        }
        long endTime = System.nanoTime(); // End time

        // Total time taken
        System.out.println("Time Taken by String: "+ (endTime - startTime)+" ms");

    }
}

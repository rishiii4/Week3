package stringconcatenation;

public class StringBuilderPerformance {
    public void stringBuilderPerformance(){
        StringBuilder sb = new StringBuilder();
        sb.append("Hey");

        // Calculating time take by string builder
        long startTime = System.nanoTime(); // Start time
        for (int i = 0; i < 10_000; i++) {
            sb.append("Hey");
        }
        long endTime = System.nanoTime(); // End time

        // Total time taken
        System.out.println("Time Taken by StringBuilder: "+ (endTime - startTime)+" ms");
    }
}

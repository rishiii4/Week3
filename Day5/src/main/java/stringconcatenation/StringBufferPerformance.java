package stringconcatenation;

public class StringBufferPerformance {
    public void stringBufferPerformance(){
        StringBuffer sbf = new StringBuffer();
        sbf.append("Hey");

        // Calculating time take by string  buffer
        long startTime = System.nanoTime(); // Start time
        for (int i = 0; i < 10_000; i++) {
            sbf.append("Hey");
        }
        long endTime = System.nanoTime(); // End time

        System.out.println("Time Taken by String Buffer: "+ (endTime - startTime)+" ms");
    }
}

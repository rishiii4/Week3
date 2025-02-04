package stringbuffer;


public class CompareStringBufferStringBuilder {
    public static void CompareStringBufferWithStringBuilder(String str){

        final int ITERATIONS = 1_000_000;
        String text = "hello";

        // Measure time for StringBuffer
        StringBuffer stringBuffer = new StringBuffer();
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            stringBuffer.append(text);
        }
        long endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;

        // Measure time for StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            stringBuilder.append(text);
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;

        // Output the results
        System.out.println("Time taken by StringBuffer: " + stringBufferTime + " ns");
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " ns");
    }


    public static void main(String[] args) {
        String str = "hello";
        CompareStringBufferStringBuilder.CompareStringBufferWithStringBuilder(str);
    }
}

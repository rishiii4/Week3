package stringconcatenation;

public class StringConcatenationPerformance {
    public static void main(String[] args) {

        // Display time taken by string
        StringPerformance stringPerformance = new StringPerformance();
        stringPerformance.stringPerformance();

        // Display time taken by string builder
        StringBuilderPerformance sb = new StringBuilderPerformance();
        sb.stringBuilderPerformance();

        // Display time taken by string buffer
        StringBufferPerformance sbf = new StringBufferPerformance();
        sbf.stringBufferPerformance();
    }
}

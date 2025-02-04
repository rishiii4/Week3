package challenges;

import java.io.*;

public class ChallengeProblem1 {

    public static void compareStringBuilderAndStringBuffer() {
        String text = "hello";
        int iterations = 1_000_000;

        // Using StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void compareFileReaderAndInputStreamReader(String filename) {
        try {
            // Using FileReader
            long startTime = System.nanoTime();
            FileReader fileReader = new FileReader(filename);
            BufferedReader br = new BufferedReader(fileReader);
            int wordCount = countWords(br);
            long endTime = System.nanoTime();
            System.out.println("FileReader word count: " + wordCount + ", time: " + (endTime - startTime) / 1_000_000 + " ms");
            br.close();

            // Using InputStreamReader
            startTime = System.nanoTime();
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filename));
            br = new BufferedReader(inputStreamReader);
            wordCount = countWords(br);
            endTime = System.nanoTime();
            System.out.println("InputStreamReader word count: " + wordCount + ", time: " + (endTime - startTime) / 1_000_000 + " ms");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countWords(BufferedReader br) throws IOException {
        int wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        return wordCount;
    }
    public static void main(String[] args) {
        compareStringBuilderAndStringBuffer();
        compareFileReaderAndInputStreamReader("largefile.txt");
    }
}

package largefilereading;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class UsingInputStreamReader {
    public static void testInputStreamReader(String filePath) {
        try {
            long start = System.nanoTime(); // Start time
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
            int c;
            while ((c = inputStreamReader.read()) != -1) { // Reads bytes and converts to characters
                // Process character
            }
            inputStreamReader.close();
            long end = System.nanoTime(); // End time
            System.out.println("InputStreamReader Time: " + (end - start) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package largefilereading;

import java.io.FileReader;
import java.io.IOException;

public class UsingFileReader {
    public static void testFileReader(String filePath) {
        try {
            long start = System.nanoTime(); // Start time
            FileReader fileReader = new FileReader(filePath);
            int c;
            while ((c = fileReader.read()) != -1) { // Reads character by character
                // Process character
            }
            fileReader.close();
            long end = System.nanoTime(); // End time
            System.out.println("FileReader Time: " + (end - start) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

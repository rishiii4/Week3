package inputstreamreader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ByteToCharStream {

    public static void readAndPrintFile(String fileName) {
        // FileInputStream object
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8);
             // BufferedReader to read characters
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        // File path
        String fileName = "myFile.txt";
        // Calling method
        readAndPrintFile(fileName);
    }
}
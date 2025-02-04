package filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurrenceUsingFileReader {

    public static int countWordOccurrences(String fileName, String targetWord) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += countWordsInLine(line, targetWord);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    private static int countWordsInLine(String line, String targetWord) {
        int count = 0;
        String[] words = line.split("\\s+"); // Split by whitespace
        for (String word : words) {
            if (word.equalsIgnoreCase(targetWord)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String fileName = "sample.txt"; // Change this to your file name
        String targetWord = "example";  // Change this to the word you want to count
        int count = countWordOccurrences(fileName, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
    }
}

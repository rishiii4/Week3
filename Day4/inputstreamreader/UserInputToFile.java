package inputstreamreader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UserInputToFile {

    public static void writeUserInputToFile(String fileName) {
        try (InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter fileWriter = new FileWriter(fileName, true); // Append mode
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            System.out.println("Enter text (type 'exit' to stop):");
            String line;
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(line);
                bufferedWriter.newLine(); // Write new line
            }
            System.out.println("User input saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String fileName = "output.txt"; // Output file name
        writeUserInputToFile(fileName);
    }
}

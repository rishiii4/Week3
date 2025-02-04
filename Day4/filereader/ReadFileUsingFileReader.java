package filereader;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFileUsingFileReader {
    public static void readFile(){
        // File path
        String file = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\JAVA\\String\\hello.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null){
                // Printing text
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
    public static void main(String[] args) {
        readFile();
    }
}

package largefilereading;

public class FileReadingEfficiency {
    public static void main(String[] args) {
        // File path
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week3\\Day5\\src\\main\\java\\largefilereading\\file.txt";


        UsingFileReader fileReader = new UsingFileReader();
        fileReader.testFileReader(filePath);

        UsingInputStreamReader inputStreamReader = new UsingInputStreamReader();
        inputStreamReader.testInputStreamReader(filePath);
    }
}

package linearsearch;

public class SearchSpecificWord {

    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence; // Return the first sentence containing the word
            }
        }
        return "Not Found"; // Return "Not Found" if the word is not present
    }
    public static void main(String[] args) {
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog.",
                "Java is a powerful programming language.",
                "Artificial intelligence is the future.",
                "Data structures and algorithms are important."
        };

        String word = "Java"; // Word to search for
        String result = findSentenceWithWord(sentences, word);
        System.out.println("Result: " + result);
    }
}

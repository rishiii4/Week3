package stringbuilder;

import java.util.HashSet;

public class RemoveDuplicatesSB {

    public static String removeDuplicateChars(String str) {
        //Initialize an empty StringBuilder and a HashSet
        HashSet<Character> set = new HashSet<>();
        StringBuilder result = new StringBuilder();

        //Iterate through the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            //If character is not already exist, then add
            if (!set.contains(ch)) {
                set.add(ch);
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "rishi";
        String output = removeDuplicateChars(input);
        System.out.println("Before: " + input);
        System.out.println("After: " + output);

    }
}

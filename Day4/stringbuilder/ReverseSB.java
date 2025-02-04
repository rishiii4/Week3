package stringbuilder;

public class ReverseSB {
    public static String reverse(String str){
        //Create stringBuilder object
        StringBuilder reverseStr = new StringBuilder();

        //Append string to stringBuilder
        reverseStr.append(str);

        //Converting StringBuilder to string and display reverse string
        return reverseStr.reverse().toString();
    }
    public static void main(String[] args) {

        String str = "hello";

        String reverse = reverse(str);
        System.out.println(reverse);
    }
}

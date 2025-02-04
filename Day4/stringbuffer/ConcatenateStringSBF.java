package stringbuffer;

public class ConcatenateStringSBF {
    public static StringBuffer concatenation(String arr[]){

        //Create a new StringBuffer object
        StringBuffer sbf = new StringBuffer();

        //Iterate through each string in the array and append it to the StringBuffer
        for (int i=0;i<arr.length;i++){
            sbf.append(arr[i]);
        }
        return sbf;
    }
    public static void main(String[] args) {
        //String array
        String string[] = {"my", "name", "is", "rishi"};

        //Calling concatenation method
        StringBuffer sbf = concatenation(string);
        System.out.println(sbf);

    }
}

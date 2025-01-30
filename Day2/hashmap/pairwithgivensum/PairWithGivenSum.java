package hashmap.pairwithgivensum;

import java.util.HashMap;

public class PairWithGivenSum {

    //Boolean function to check if pair exist
    public static boolean findTwoPair(int []nums, int n, int target) {
        HashMap<Integer , Integer> prev = new HashMap<>();

        //Loop through array
        for (int i = 0; i < n; i++) {
            // Checking if the other number is in hashmap or not
            if (prev.getOrDefault(target - nums[i], 0) != 0) {

                return true;
            }
            //Pushing the ith val in hashmap
            prev.put(nums[i], i+1);

        }
        return false;
    }

    public static void main(String[] args) {

        int size = 10;
        int nums[] = {1, 4, 3, 8, 6, 4, 2, 9, 6, 0};
        //Getting the two index from function
        boolean ans = findTwoPair(nums, size, 0);
        if (ans) {
            System.out.println("Pair found");
        }
        else  {
            System.out.println("Pair not found");
        }
    }
}





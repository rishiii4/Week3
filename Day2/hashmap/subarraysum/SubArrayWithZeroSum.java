package hashmap.subarraysum;

import java.util.HashSet;

public class SubArrayWithZeroSum {

    //Method returns count
    public static int countSubArrays(int[] nums, int n) {
        int count = 0;
        //Using hasSet instead off hash map as we only need one val to determine the sum
        HashSet<Integer> totalSum = new HashSet<>();

        //Adding zero at the start
        totalSum.add(0);

        //Cur sum var to denote the total sum upto Ith iteration
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            if (totalSum.contains(curSum)) {
                count++;
            }
            totalSum.add(curSum);
        }

        return count;
    }


    public static void main(String[] args) {

        int[] nums = {1, 4, -1, -4, -5, 9, 8, 2, -2};
        int size = 9;

        //Printing the result
        System.out.println("The number of sub array with zero sum is : "+ countSubArrays(nums, 9));

    }
}

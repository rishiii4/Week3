package hashmap.twosumproblem;

import java.util.HashMap;

public class TwoSumProblem {
    public static int[] findTwoIndex(int []nums, int n, int target) {
        HashMap<Integer , Integer> prev = new HashMap<>();

        //Looping through array
        for (int i = 0; i < n; i++) {
            //Checking if the other number is in hashmap or not
            if (prev.getOrDefault(target - nums[i], 0) != 0) {

                return new int[] {prev.get(target - nums[i]), i+1};
            }
            //Pushing the ith val in hashmap
            prev.put(nums[i], i+1);

        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int size = 10;
        int nums[] = {1, 2, 3, 15, 8, 14, 1, 9, 6, 0};

        //Getting the two index from function
        int ans[] = findTwoIndex(nums, size, 3);
        System.out.println(ans[0] +" "+ ans[1]);
    }
}

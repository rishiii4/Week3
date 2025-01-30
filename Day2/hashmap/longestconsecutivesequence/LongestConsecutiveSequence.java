package hashmap.longestconsecutivesequence;


import java.util.HashMap;


import static java.lang.Math.max;

public class LongestConsecutiveSequence {
    public static int lengthOfSequence(int nums[], int n) {
        //Length of sequence
        int maxLength = 0;

        //Hash map for integer key and boolean val
        HashMap<Integer, Boolean> numsMap = new HashMap<>();

        //Finding the max number of the nums array
        int maxNum = 0;

        //Loop on nums
        for (int i = 0; i < n; i++) {
            numsMap.put(nums[i], true);
            maxNum = max(maxNum, nums[i]);
        }

        //Loop on hash map
        int i = 0;
        while(i <= maxNum) {
            if (numsMap.getOrDefault(i, false)) {
                int curLen = 1;
                i++;
                while(numsMap.getOrDefault(i, false) && i < maxNum) {
                    curLen ++;
                    numsMap.put(i, false);
                    i++;
                }
                maxLength = max(curLen, maxLength);
            }else {
                i++;
            }

        }

        return maxLength;
    }

    public static void main(String[] args) {
        //Example array of unsorted numbers
        int nums[] = {1, 15, 3, 2, 13, 4, 8, 1, 2, 7, 8, 9, 10, 11, 12, 13, 14};
        int size = 17;
        System.out.println(lengthOfSequence(nums, size));

    }
}

package stackqueue.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {
    //Method to return maximum
    public static int[] getWindowMaximum(int nums[], int k) {
        //Checking if input is valid or not
        if (k == 0 || nums.length == 0) {
            return new int[]{};
        }
        //Answer array to store the maximum number
        int ans[] = new int[nums.length - k + 1];

        // a deque to store the k sized window
        Deque<Integer[]> dq = new ArrayDeque<Integer[]>();

        //Iterator i to traverse the nums array
        int i;
        for (i = 0; i < k; i++) {
            //Removing element in dq if they are smaller than current number
            while(!dq.isEmpty() && dq.peekLast()[0] < nums[i]) {
                dq.pollLast();
            }
            //Adding element to the que
            dq.addLast(new Integer[]{nums[i], i});
        }

        //Checking if dq is null
        assert dq.peekFirst() != null;

        //First maximum number
        ans[i-k] = dq.peekFirst()[0];
        for (; i < nums.length; i++) {
            assert dq.peekFirst() != null;
            ans[i-k] = dq.peekFirst()[0];

            //Removing element in dq if they are smaller than current number
            while((!dq.isEmpty() && dq.peekLast()[0] < nums[i])) {
                dq.pollLast();
            }

            //Adding the current number
            dq.addLast(new Integer[]{nums[i], i});
            if (dq.size() > k) {
                dq.pollFirst();
            }

            // edge case if the que is not full and peek front is out of bounds for window length k
            assert dq.peekFirst() != null;
            if (dq.peekFirst()[1] == (i-k)) {
                dq.pollFirst();
            }

            //Last maximum number
            if (i == nums.length - 1) {
                assert dq.peekFirst() != null;
                ans[i-k + 1] = dq.peekFirst()[0];
            }

        }
        return ans;
    }

        public static void main(String[] args) {

            int nums[] = {7, 8, 2, 4, 5};
            int k = 2;

            //Getting the sliding window maximum
            int[] ans = getWindowMaximum(nums, k);

            //Printing the answer array
            for (int item : ans) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
}


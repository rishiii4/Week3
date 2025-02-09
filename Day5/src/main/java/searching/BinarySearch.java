package searching;

import java.util.Arrays;

public class BinarySearch {
    public int findTarget(int[] arr, int target){


        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}

package sorting;

public class MergeSort {
    public static void merge(int arr[], int si, int mid, int ei){
        int[] temp = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                k++; i++;
            }else{
                temp[k] = arr[j];
                k++; j++;
            }
        }
        while(i <= mid){
            temp[k] = arr[i];
            k++; i++;
        }
        while(j <= ei){
            temp[k] = arr[j];
            k++; j++;
        }
        for(k=0, i=si;k< temp.length; k++,i++){
            arr[i]  = temp[k];
        }
    }
    public static void mergeSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si , mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }
}

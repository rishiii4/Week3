package sorting;

public class BubbleSort {
    public void bubbleSort(int arr[]){

        // Looping through array
        for(int i=0;i< arr.length-1;i++){
            for(int j=0;j< arr.length-1-i;j++){

                // Swapping values
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

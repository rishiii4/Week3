package sortingalgorithms.selectionsort;

public class ExamScores {
    //Method to sort the exam scores array
    public static void selectionSort(int arr[]){
        //Loop through the exam scores array
        for(int i=0;i< arr.length-1;i++){
            int min = i;
            for(int j=i+1;j< arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            //Swapping values
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        //Array of exam scores
        int arr[] = {50,40,10,30,20};

        //Calling selection sort method
        selectionSort(arr);

        //Printing output
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}

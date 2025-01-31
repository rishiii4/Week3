package sortingalgorithms.mergesort;

public class BookPrices {
    //Method to merge the array
    public static void merge(int bookPrices[], int si, int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i = si; //for left part
        int j = mid+1; //for right part
        int k = 0; //for temp
        while(i <= mid && j <= ei){
            if(bookPrices[i] < bookPrices[j]){
                temp[k] = bookPrices[i];
                k++; i++;
            }else{
                temp[k] = bookPrices[j];
                k++; j++;
            }
        }
        while (i <= mid){
            temp[k++] = bookPrices[i++];
        }

        while (j <= ei){
            temp[k++] = bookPrices[j++];
        }

        for(k=0, i=si;k< temp.length; k++,i++){
            bookPrices[i]  = temp[k];
        }

    }
    //Method to divide the array
    public static void mergeSort(int bookPrices[], int si, int ei){
        if(si >= ei){
            return;
        }
        //Calculating mid of array
        int mid = si + (ei - si) / 2;
        //Using recursion
        mergeSort(bookPrices, si , mid);
        mergeSort(bookPrices, mid+1, ei);
        merge(bookPrices, si, mid, ei);
    }
    public static void main(String[] args) {
        //Array of bookPrices
        int bookPrices[] = {12,10,16,11,18,8};

        //Calling merge sort method to sort prices
        mergeSort(bookPrices, 0, bookPrices.length-1);

        //Printing output
        for (int i=0;i<bookPrices.length;i++){
            System.out.print(bookPrices[i]+" ");
        }
    }
}

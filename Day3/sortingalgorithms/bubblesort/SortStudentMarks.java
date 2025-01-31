package sortingalgorithms.bubblesort;

public class SortStudentMarks {
    //Method to sort marks array
    public static void bubbleSort(int marks[]){
        //Loop through the array of marks
        for (int i=0;i< marks.length-1;i++){
            for(int j=0;j< marks.length-i-1;j++){
                if(marks[j] > marks[j+1]){
                    //Swapping the values
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        //Array of marks
        int marks[] = {65,86,84,92,72,};

        //Calling bubble sort method
        bubbleSort(marks);

        //Printing sorted array of marks
        for(int i=0;i< marks.length;i++){
            System.out.print(marks[i]+" ");
        }

    }

}

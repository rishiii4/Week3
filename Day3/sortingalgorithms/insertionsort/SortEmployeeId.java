package sortingalgorithms.insertionsort;

public class SortEmployeeId {
    //Method to sort employee ids
    public static void insertionSort(int employeeId[]){
        //Loop through employee id array
        for(int i=1;i< employeeId.length;i++){
            int curr = employeeId[i];
            int prev = i-1;
            while(prev >= 0 && employeeId[prev] > curr){
                employeeId[prev+1] = employeeId[prev];
                prev--;
            }
            employeeId[prev+1] = curr;
        }
    }
    public static void main(String[] args) {
        //Employee id array
        int employeeId[] = {5,4,1,3,2};
        //Calling insertion sort method to sort array
        insertionSort(employeeId);

        //Printing output
        for(int i=0;i<employeeId.length;i++){
            System.out.print(employeeId[i]+" ");
        }
    }
}

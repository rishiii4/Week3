package sortingalgorithms.countingsort;

public class StudentAges {
    //Method to sort the array of students age
    public static void countingSort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++){
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest+1];

        for(int i=0;i< arr.length;i++){
            count[arr[i]]++;
        }

        int j = 0;
        //Sorting the ages of students
        for(int i=0;i< count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        //Array or student age
        int studentAge[]= {11,14,12,13,17,13,12,17};

        //Calling counting sort method
        countingSort(studentAge);

        //Printing sorted array of marks
        for(int i=0;i< studentAge.length;i++){
            System.out.print(studentAge[i]+" ");
        }

    }
}

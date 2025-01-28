package linkedlist.studentrecord;

public class Student {
    public static StudentNode head;
    public static StudentNode tail;
    public static int size;

    public static void addFirst(StudentNode a){
        size++;
        if (head==null){
            head = tail = a;
            return;
        }
        // step-2 newNode next = head
        a.next = head;
        // step-3 head = newNode
        head = a;
    }
    public static void addLast(StudentNode b){
        if(head==null){
            head = tail = b;
            return;
        }
        // step-2 tail.next = newNode
        tail.next = b;
        // step-3 tail = newNode
        tail = b;
    }
    public static void add(int idx, StudentNode a){
        if(idx==0){
            addFirst(a);
            return;
        }
        size++;
        StudentNode temp = head;
        int i = 0;

        while(i<idx-1){
            temp = temp.next;
            i++;
        }

        a.next = temp.next;
        temp.next = a;
    }
    // Delete a student record by Roll Number
    public static void deleteStudentByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }
        StudentNode current = head;
        while (current.next != null && current.next.rollNo != rollNo) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student with Roll No " + rollNo + " not found.");
        } else {
            current.next = current.next.next;
        }
    }
    // Display all student records
    public static void displayAllStudents() {
        if (head == null) {
            System.out.println("No students in the list.");
            return;
        }
        StudentNode current = head;
        while (current != null) {
            System.out.println("Roll No: " + current.rollNo + ", Name: " + current.name +
                    ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
    // Search for a student by Roll Number
    public static StudentNode searchStudentByRollNo(int rollNo) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNo == rollNo) {
                return current;
            }
            current = current.next;
        }
        System.out.println("Student with Roll No " + rollNo + " not found.");
        return null;
    }
    // Update a student's grade by Roll Number
    public static void updateStudentGrade(int rollNo, String newGrade) {
        StudentNode student = searchStudentByRollNo(rollNo);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated for Roll No " + rollNo);
        }
    }

    public static void main(String[] args) {
        StudentNode student1 = new StudentNode(22,"Rohit",18,"A");
        StudentNode student2 = new StudentNode(24,"Rohan",18,"A");
        StudentNode student3 = new StudentNode(26,"Rishi",18,"B");
        StudentNode student4 = new StudentNode(28,"Roshan",18,"B");
        StudentNode student5 = new StudentNode(30,"Jadoo",18,"A");

        //adding student in list
        addFirst(student1);
        addLast(student2);
        addLast(student3);
        addLast(student4);
        addLast(student5);

        //displaying student's details
        displayAllStudents();

        //updating grade
        updateStudentGrade(22,"B");

        //displaying student's details after updating grade
        displayAllStudents();

        //deleting student
        deleteStudentByRollNo(30);

        //displaying student's details after deleting student
        displayAllStudents();


    }
}

package linkedlist.studentrecord;

class StudentNode {
    int rollNo;
    String name;
    int age;
    String grade;
    StudentNode next;

    //Constructor to initialize student node
    public StudentNode(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }


}

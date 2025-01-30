package stackqueue.queueusingstack;

import java.util.Stack;

public class QueueUsingStack {
    //Initializing stacks
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    //Enqueue method
    public void enqueue(int data){
        stack1.push(data);
    }
    //Dequeue method
    public void dequeue(){
        while (!stack1.isEmpty()){
            int data = stack1.pop();
            stack2.push(data);
        }
        System.out.println(stack2.pop());
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        //Storing the data in queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        //Printing data
        queue.dequeue();
        queue.dequeue();
    }

}

package stackqueue.sortstackusingrecursion;

import java.util.Stack;

public class SortStackUsingRecursion {
    //Method to insert data in stack
    public static void insertStack(Stack<Integer> stack, int data){
        if(stack.isEmpty() || stack.peek() <= data){
            stack.push(data);
        }else{
            int top = stack.pop();
            insertStack(stack, data);
            stack.push(top);
        }
    }
    //Method to arrange the data in ascending order
    public static void arrangeAscending(Stack<Integer> stack){
        if(!stack.isEmpty()) {
            int top = stack.pop();

            arrangeAscending(stack);

            insertStack(stack, top);
        }

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        //Pushing data in stack
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(2);

        System.out.println(stack);

        //Calling arrangeAscending method
        arrangeAscending(stack);
        //Printing output
        System.out.println(stack);
    }
}

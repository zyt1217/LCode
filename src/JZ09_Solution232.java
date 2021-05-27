import java.util.Stack;

public class JZ09_Solution232 {

}

class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        if(stack2.isEmpty())
            return -1;
        else return stack2.pop();
    }
}

class MyQueue {

    private static Stack<Integer> stack1;
    private static Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // while (!stack2.isEmpty())
        //     stack1.push(stack2.pop());
        stack1.push(x);
        // while (!stack1.isEmpty())
        //     stack2.push(stack1.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        int a= stack2.pop();
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        return a;
    }

    /** Get the front element. */
    public int peek() {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        int a= stack2.peek();
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        return a;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.empty() && stack1.empty();
    }
}
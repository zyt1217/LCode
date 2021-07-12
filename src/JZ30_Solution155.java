import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class JZ30_Solution155 {
}

class MinStack {

    LinkedList<Integer> stack;
    LinkedList<Integer> minstack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<Integer>();
        minstack = new LinkedList<Integer>();
        minstack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minstack.push(Math.min(val,minstack.peek()));
    }

    public void pop() {
        stack.pop();
        minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
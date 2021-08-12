package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue2Stack_Solution225 {
}
class MyStack {
    Queue<Integer> queue1, queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue2.isEmpty())
            queue1.add(x);
        else queue2.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue2.isEmpty()){
            while (queue1.size() > 1)
                queue2.add(queue1.poll());
            return queue1.poll();
        }else {
            while (queue2.size() > 1)
                queue1.add(queue2.poll());
            return queue2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if (queue2.isEmpty()) {
            while (queue1.size() > 1)
                queue2.add(queue1.poll());
            int ans = queue1.poll();
            queue2.add(ans);
            return ans;
        } else {
            while (queue2.size() > 1)
                queue1.add(queue2.poll());
            int ans = queue2.poll();
            queue1.add(ans);
            return ans;
        }
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue2.isEmpty() && queue1.isEmpty();
    }
}

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class JZ59II {
    //同剑指上一题59I 一样，用一个双端队列来保存最大值的下标，这里可以直接保存最大值
}
class MaxQueue {
    Deque<Integer> max;
    Queue<Integer> queue;
    public MaxQueue() {
        max = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        if(max.isEmpty())
            return -1;
        else return max.peekFirst();
    }

    public void push_back(int value) {
        while (!max.isEmpty() && value > max.peekLast()){
            max.pollLast();
        }
        max.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        if(max.peek().equals(queue.peek()))
            max.poll();
        int res = queue.remove();
        if(queue.isEmpty())
            max.clear();
        return res;
    }
}

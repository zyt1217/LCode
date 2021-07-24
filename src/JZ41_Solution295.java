import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class JZ41_Solution295 {
}
class MedianFinder {
    //对于有序的序列，使用排序的数据结构即可，
    //但是涉及到随时更新的序列，即插入和删除元素，要随时知道序列最大值最小值是什么
    //保持有序数组，二分查找插入位置时间复杂度logN，插入元素时间复杂度n（之后的元素移动位置）
    //堆相对于二叉树的搜索要慢，在堆中搜索不是第一优先级，
    // 因为使用堆的目的是将最大（或者最小）的节点放在最前面，从而快速的进行相关插入、删除操作，
    // 建堆的时间复杂度是O(n)(调用一次);
    // 调整堆的时间复杂度是lgn,调用了n-1次,所以堆排序的时间复杂度是O(n)+O(nlgn) ~ O(nlgn)
    /* initialize your data structure here. */

    //maxHeap (n+1)/2 median minHeap (n-1)/2
    Queue<Integer> maxHeap,minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());//构造大顶堆
        minHeap = new PriorityQueue<>();//小顶堆，存放较大的一边的数,java默认PriorityQueue是小顶堆
    }

    public void addNum(int num) {
        if(maxHeap.size()>minHeap.size()){
            if(num>maxHeap.peek())
                minHeap.offer(num);
            else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
        }else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
            return (maxHeap.peek()+minHeap.peek())/2.0;
        else return (double) maxHeap.peek();
    }
}

/*
  Your MedianFinder object will be instantiated and called as such:
  MedianFinder obj = new MedianFinder();
  obj.addNum(num);
  double param_2 = obj.findMedian();
 */
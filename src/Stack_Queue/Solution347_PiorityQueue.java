package Stack_Queue;

import java.util.*;

public class Solution347_PiorityQueue {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
        // 根据map的value值正序排列，相当于小顶堆
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(
                (o1, o2) -> o1.getValue() - o2.getValue() //返回负数表示顺序o1,o2中小的在前面
        );
        for(Map.Entry<Integer,Integer> entry : entries){
            queue.offer(entry);
            if(queue.size() > k)
                //小顶堆，小的出去了，只保留前k大
                queue.poll();
        }
        int[] ans = new int[k];
        for(int i = k - 1; i>=0; i--){
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }
}

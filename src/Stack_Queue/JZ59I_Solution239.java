package Stack_Queue;

import java.util.*;

public class JZ59I_Solution239 {
    public static void  main(String[] args){
        System.out.print(Arrays.toString(maxSlidingWindow_(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length ==0)
            return new int[0]; //new int[0] 和 null不一样！！
        if(k == 1)
            return nums;
        int[] ans = new int[nums.length - k + 1];
        Arrays.fill(ans, Integer.MIN_VALUE);
        ans[0] = nums[0];
        int maxPos = 0;
        for(int i = 0; i < k; i++){
            if(nums[i] >= ans[0]){
                ans[0] = nums[i];
                maxPos = i;
            }
        }
        for(int r = k; r < nums.length; r++){
            if(nums[r] >= ans[r-k]){
                maxPos = r;
                ans[r-(k-1)] = nums[r];
            }else {
                if(maxPos == r - k){
                    for(int i = r - k + 1; i<=r; i++){
                        if(nums[i] >= ans[r-(k-1)]){
                            ans[r-(k-1)] = nums[i];
                            maxPos = i;
                        }
                    }
                }else ans[r-(k-1)] = ans[r-k];
            }
        }
        return ans;
    }

    public static int[] maxSlidingWindow_(int[] nums, int k) {
        if(nums.length ==0 || k <=1)
            return nums;

        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        //模拟队列，队列滑动的过程也可以得到最大值
        //单调队列，只维护最大值
        //pop(value)：如果窗口移除的元素value等于单调队列的出口元素，那么队列弹出元素，否则不用任何操作
        //push(value)：如果push的元素value大于入口元素的数值，那么就将队列入口的元素弹出，直到push元素的数值小于等于队列入口元素的数值为止
        for(int i = 0; i < k; i++){
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
        }
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; ++i) {
            //对于窗口滑动后新加入的元素，保证队列的单调性，在等于时，必须不能向前移除，因为等于的元素也是最大值队列中的一个，保持等于元素的有序
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() ==i - k) {
                deque.poll();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}

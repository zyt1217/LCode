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
        for(int i = 0; i < k; i++){
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
        }
        ans[0] = nums[deque.peek()];
        for (int i = k; i < nums.length; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peek() <= i - k) {
                deque.poll();
            }
            ans[i - k + 1] = nums[deque.peek()];
        }
        return ans;
    }
}

package Array.SlidingWindow;

public class Solution209 {
    public static void main(String[] args){
        minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1});
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int res = 0;
        while (sum < target && right <nums.length){
            sum += nums[right];
            right ++;
        }
        if(sum < target)
            return 0;
        right --;

        res = right + 1;
        while (right < nums.length){
            if (sum >= target){
                res = Math.min(res, right-left+1);
                sum -= nums[left];
                left ++;
            }
            else{
                right ++;
                if(right <nums.length)
                    sum += nums[right];
            }
        }
        return res;
    }

}

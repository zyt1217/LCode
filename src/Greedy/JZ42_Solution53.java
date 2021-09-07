package Greedy;

public class JZ42_Solution53 {
    public int maxSubArray_greedy(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum);
            if(sum <= 0)
                sum = 0;
        }
        return max;
    }
}

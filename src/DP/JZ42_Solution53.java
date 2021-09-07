package DP;

public class JZ42_Solution53 {

        public int maxSubArray(int[] nums) {
//        if (nums.length == 0)
//            return Integer.MIN_VALUE;
        int sum = nums[0];
        //dp[i] 代表以元素 nums[i] 为结尾的连续子数组最大和
        //为何定义最大和 dp[i] 中必须包含元素 nums[i] ：
        // 保证 dp[i] 递推到 dp[i+1] 的正确性；
        // 如果不包含 nums[i] ，递推时则不满足题目的 连续子数组 要求。
        //

        //说明dp表示的状态优先满足题目要求，而不是去直接表示最后的结果，
        // 最后的结果可以用其他的数据结构表示
        //此处的dp数据结构已经表达了所有的结果，以任意元素结尾的子数组，
        // 而满足最大和连续两个条件写在了状态转移里。
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
//            sum = Math.max(dp[i], sum);
//        }
//        return sum;
        //为了节省空间，不用dp数组，dp数组在每轮sum得出后就丢弃了
        //只关心这一轮是谁比较大
        int max = nums[0];
        for(int i = 1; i< nums.length; i++){
            //这里是直接将大的值赋给下一轮的dp(i-1)
            max = Math.max(max + nums[i], nums[i]);
            sum = Math.max(max,sum);
        }
        return sum;
    }

}
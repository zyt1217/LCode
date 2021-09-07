package DP;

public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int prepre = cost[0];
        int pre = cost[1];
        int ans = pre;
        for(int i = 2; i < cost.length; i++){
            ans = Math.min(pre, prepre) + cost[i];
            prepre = pre;
            pre = ans;
        }
        return Math.min(ans, prepre);
    }
}

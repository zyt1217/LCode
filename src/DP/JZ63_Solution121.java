package DP;

public class JZ63_Solution121 {
    public int maxProfit(int[] prices) {
        //dp[i]表示i天的最大利润
        //dp[i] = max(dp[i-1], prices[i] - minPrice)
//        if(prices.length == 0)
//            return 0;
        int minPrice = Integer.MAX_VALUE;
        int Max = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            Max = Math.max(Max, price - minPrice);

        }
        return Max;
    }
}

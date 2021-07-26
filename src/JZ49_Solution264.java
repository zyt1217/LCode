import java.util.HashMap;

public class JZ49_Solution264 {
    public int nthUglyNumber(int n) {
        /**dp[i]应该是之前的某个丑数通过*2、*3、*5而来，且
         这三个数分别*2、3、5恰好是刚好大于dp[i-1]，取这三个的最小值即可 */
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for(int i = 1; i< n;i++){
            int n2 = dp[p2] * 2, n3 = dp[p3]*3, n5 = dp[p5]*5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            //dp[a]代表的是这个值*2之后刚好大于dp[i-1],现在这个数被使用之后，a值向右进一位才能保证新的dp[a]*2是刚好大于现在的dp[i]的，下同理
            if(dp[i] == n2)
                p2 ++;
            if(dp[i] == n3)
                p3++;
            if(dp[i] == n5)
                p5++;
        }
        return dp[n-1];
    }
}

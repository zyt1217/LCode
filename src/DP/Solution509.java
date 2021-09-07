package DP;

public class Solution509 {
    public int fib(int n) {
        if(n < 2)
            return n;
        int prepre = 0, pre = 1;
        int ans =0;
        for(int i = 2; i<=n; i++){
            ans = prepre + pre;
            prepre = pre;
            pre = ans;
        }
        return ans;
    }
}

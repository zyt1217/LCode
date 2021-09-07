package DP;

public class JZ10_Solution70 {
    public int fib(int n) {
        int n0 = 0 , n1 =1;
        for(int i = 0; i<n; i++){
            int sum = (n0 + n1)%1000000007;
            n0 = n1;
            n1 = sum;
        }
        return n0;
    }
}

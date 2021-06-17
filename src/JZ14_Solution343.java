public class JZ14_Solution343 {
    public static int cuttingRope(int n) {

        int max = 0;
        int[] ans = new int[55];
        int[] temp = new int[55];
        ans[2] = 1;
        ans[3] = 2;
        temp[2] = 2;
        temp[3] = 3;
        for(int i = 4;i<=n;i++){
            for(int small = 2;small <= i/2;small++){
                int tempmax = temp[small] * temp[i - small];
                max = Math.max(max,tempmax);
            }
            ans[i] = max;
            temp[i] = max;
        }
        return ans[n];
    }

    public static int cuttingRope2(int n) {
        if(n <= 3)
            return n-1;
        int a = n/3;
        int b = n%3;
        long ans = 1;
        for(int i = 1;i<a;i++){
            ans = ans*3%1000000007;
        }
        if(b == 0)
            return (int)(ans*3%1000000007);
        else if(b==1)
            return (int)(ans*4%1000000007);
        else return (int)(ans*6%1000000007);
    }
}

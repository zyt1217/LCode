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
}

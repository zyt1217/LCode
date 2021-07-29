public class JZ66_Solution238 {
    public int[] constructArr(int[] a) {
        /*
        从两边往中间双向dp，可以充分利用之前乘积的结果
        B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]
        = left[i]*right[i]
        left[i] = A[0]×A[1]×…×A[i-1]
        right[i] = A[i+1]×…×A[n-2]×A[n-1]
         */
        int n = a.length;
        if(n == 0)
            return new int[0];
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        for(int i = 1; i < n;i++){
            left[i] = left[i-1] * a[i-1];
        }
        for (int i = n-2; i >=0 ; i--){
            right[i] = right[i+1] * a[i+1];
        }
        for (int i = 0; i< n;i++){
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public int[] constructArr_(int[] a) {
        /*
        从两边往中间双向dp，可以充分利用之前乘积的结果
        B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]
        = left[i]*right[i]
        left[i] = A[0]×A[1]×…×A[i-1]
        right[i] = A[i+1]×…×A[n-2]×A[n-1]
         */

        /*
        合并循环后，可以理解成，先计算
        1
        1 * A[0]
        1 * A[0] * A[1]
        ...
        1 * A[0] * A[1] * ... * A[n-2]
        再从后往前将每个结果乘以右边的，此时右边的数的乘积可以迭代复用
         */
        if(a == null || a.length ==0)
            return a;
        int n = a.length;
        int[] ans = new int[n];
        ans[0] = 1;
        int right = 1;
        for(int i = 1; i < n;i++){
            ans[i] = ans[i-1] * a[i-1];
        }
        for (int i = n-2; i >=0 ; i--){
            right *= a[i + 1];
            ans[i] *= right;
        }
        return ans;
    }
}
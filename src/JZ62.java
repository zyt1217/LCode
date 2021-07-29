import java.util.LinkedList;
import java.util.List;

public class JZ62 {
    public int lastRemaining(int n, int m) {
        //递推公式 f表示最终的下标 f(n,m) = (f(n-1,m) + m) % m
        int ans = 0;//只剩一人时候，下标是0
        for(int i = 1; i < n; i++){
            ans = (ans+m) % (i + 1);
        }
        return ans;
    }
}

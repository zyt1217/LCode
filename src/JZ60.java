import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JZ60 {
    //骰子 动态规划 反推
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp,1.0/6.0);
        for(int i = 2; i<=n; i++){
            double[] newdp = new double[5*i+1];
            for (int j = 0; j < dp.length; j++){
                for (int k = 0; k < 6; k++){
                    newdp[k+j] += dp[j]/6.0;
                }
            }
            dp = newdp;
        }
        return dp;
    }
}

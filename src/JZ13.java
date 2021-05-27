import java.util.LinkedList;
import java.util.Queue;

public class JZ13 {
    public int movingCount(int m, int n, int k) {
        if(k == 0)
            return 1;

        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        Queue<int[]> queue = new LinkedList<int[]>(); //广度优先遍历使用队列
        queue.offer(new int[]{0,0});
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int i = 0; i<2; i++){
                int[] tempcell = new int[2];
                tempcell[0] = cell[0];
                tempcell[1] = cell[1];
                tempcell[i] += 1;
                int tx = tempcell[0], ty = tempcell[1];
                if(tx >= m || ty>=n || vis[tx][ty] || (get(tx)+get(ty)) >k)
                    continue;
                queue.offer(new int[]{tx,ty});
                vis[tx][ty] = true;
                ans ++;
            }
        }
        return ans;
    }


    public int get(int x){
        int res = 0;
        while(x!=0){
            res += x%10;
            x = x/10;
        }
        return res;
    }
}

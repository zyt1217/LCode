import java.lang.reflect.Array;

public class Solution64 {
    public static void main(String[] args){
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        minPathSum(grid);
        //System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid){
        //这才是动态规划，动态规划不是进行回溯，而是确认了一个找下一个
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for(int i = 0;i< grid.length;i++){
            for(int j = 0; j< grid[0].length;j++){
                if(i == 0 && j == 0)
                    continue;
                else if(i == 0)
                    grid[i][j] = grid[0][j-1]+grid[i][j];
                else if(j == 0)
                    grid[i][j] = grid[i-1][0] + grid[i][j];
                else
                    grid[i][j] = Math.min(grid[i][j-1],grid[i-1][j]) +grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }


    public static int minPathSum1(int[][] grid) {//递归方法 ，超时
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid[0].length - 1;
        int n = grid.length - 1;
        int[][] gridup;
        int[][] gridleft;
        if(m == 0 && n == 0)
            return grid[0][0];
        int sum1;

        if(m == 0){
            sum1 = 0;
            for(int i = 0; i <= n;i++)
                sum1 += grid[i][0];
            return sum1;
        }
        if(n == 0){
            sum1 = 0;
            for(int i = 0; i<=m;i++)
                sum1 += grid[0][i];
            return sum1;
        }

        gridup= new int[n][m+1];
        System.arraycopy(grid,0,gridup,0,n);

        gridleft = new int[n+1][m];
        for(int i = 0; i <=n;i++){
            System.arraycopy(grid[i],0,gridleft[i],0,m);
        }

        return Math.min(minPathSum(gridup),minPathSum(gridleft)) + grid[n][m];
    }


}

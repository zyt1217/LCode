public class JZ47 {
    public int maxValue(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 0; i < dp.length ;i++){
            for (int j = 0; j < dp[i].length; j++){
                if(i == 0 && j == 0)
                    continue;
                if(i == 0)
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                if(j == 0)
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                if(i != 0 && j != 0)
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public int maxValue_(int[][] grid){
        //原地，不适用新数据结构
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m ;i++){
            for (int j = 0; j < n; j++){
                if(i == 0 && j == 0)
                    continue;
                if(i == 0)
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                if(j == 0)
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                if(i != 0 && j != 0)
                    grid[i][j] = grid[i][j] + Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m-1][n-1];
    }
}

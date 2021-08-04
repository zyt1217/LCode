package Array.matrix;

public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        //每一边填入的数量
        int count =  n - 1;
        int index = 1;
        while (index <= n*n){
            if(count == 0){
                res[n>>1][n>>1] = index;
                break;
            }
            //(n-count-1)/2代表缩短了多少次
            int edge = (n-count-1)>>1;
            //上
            for(int i = 0; i < count; i++){
                res[edge][i + edge] = index;
                index ++;
            }
            //右
            for(int i = 0; i < count; i++){
                res[i + edge][n-1 - edge] = index;
                index ++;
            }
            //下
            for(int i = 0; i < count; i++){
                res[n-1 - edge][n-1 - edge - i] = index;
                index ++;
            }
            //左
            for(int i = 0; i < count; i++){
                res[n-1 - edge - i][edge] = index;
                index ++;
            }
            count -= 2;
        }
        return res;
    }
}

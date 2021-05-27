public class JZ04_Solution240 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0)
            return false;
        int m = matrix[0].length;
        if(m == 0)
            return false;
        int y = 0,x = m-1;
        while (true){
            if(target == matrix[y][x])
                return true;
            else if(target > matrix[y][x]){
                y = y + 1;
                if(y >= n)
                    break;
            }
            else if(target < matrix[y][x]){
                x = x - 1;
                if(x < 0)
                    break;
            }
        }
        return false;
    }
}

public class Solution304 {
    public static int[][] matrix= new int[][]{
            {-1},
};


    public static void main(String[] args){
        NumMatrix a = new NumMatrix(matrix);
        a.sumRegion(0, 0, 0, 0);
        System.out.println(a.sumRegion(0, 0, 0, 0));
    }

}

class NumMatrix {

    int[][] sums;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)
            return;
        sums = new int[matrix.length][matrix[0].length];
        sums[0][0] = matrix[0][0];
        for(int i = 1;i< matrix.length;i++){
            sums[i][0] = sums[i-1][0] + matrix[i][0];
        }
        for(int i = 1;i< matrix[0].length;i++){
            sums[0][i] = sums[0][i-1] + matrix[0][i];
        }
        for(int i = 1;i< matrix.length;i++){
            for (int j = 1;j<matrix[0].length;j++){
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1==0 &&col1 != 0)
            return sums[row2][col2] - sums[row2][col1-1];
        if(row1!=0 &&col1 == 0)
            return sums[row2][col2] - sums[row1-1][col2];
        if(row1 ==0 && col1 ==0)
            return sums[row2][col2];
        return sums[row2][col2] - sums[row2][col1-1] - sums[row1-1][col2] + sums[row1-1][col1-1];
    }
}
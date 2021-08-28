import java.util.Scanner;

public class hw1 {
}

class Main1{
    private static int row;
    private static int col;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        Main1.row = row;
        Main1.col = col;
        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        System.out.print(getMaxMatrix(map));
    }

    public static int getMaxMatrix(int[][] matrix) {
        int max=Integer.MIN_VALUE;
        int dp=0;
        int start=0;
        int[] sum=null;
        for(int i=0;i<matrix.length;i++) {
            sum=new int[matrix[0].length];
            for(int j=i;j<matrix.length;j++) {
                dp=0;start=0;
                for(int k=0;k<sum.length;k++) {
                    sum[k]+=matrix[j][k];
                    dp+=sum[k];

                    if(max<dp) {
                        max=dp;
                    }
                    if(dp<0) {
                        dp=0;start=k+1;
                    }
                }
            }
        }

        return max;
    }

}

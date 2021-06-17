public class xm1 {

    static List<Integer> beans(int[][] matrix) {
        int y = matrix.length;
        if (y == 0)
            return new int[]{};
        int x = matrix[0].length;
        int[] ans = new int[2 * (x + y) - 4];
        if (x <= 2 || y <= 2) {
            if (x == 1)
                ans = new int[y];
            else if (y == 1)
                ans = new int[x];
            if (x == 1 && y == 1)
                return new int[]{matrix[0][0]};
            else {
                System.arraycopy(matrix[0], 0, ans, 0, x);
                if (y == 1)
                    return ans;
                for (int i = x; i < y - 1 + x; i++)
                    ans[i] = matrix[i - x + 1][x - 1];
                if (x == 1)
                    return ans;
                for (int i = x + y - 1; i < 2 * x + y - 2; i++)
                    ans[i] = matrix[y - 1][x - 2 - (i - x - y + 1)];
                for (int i = 2 * x + y - 2; i < 2 * (x + y) - 4; i++)
                    ans[i] = matrix[y - 2 - (i - 2 * x - y + 2)][0];
                return ans;
            }
        }
        int[][] newMatrix = new int[y - 2][x - 2];
        for (int i = 0; i < y - 2; i++) {
            for (int j = 0; j < x - 2; j++) {
                newMatrix[i][j] = matrix[i + 1][j + 1];
            }
        }
        System.arraycopy(matrix[0], 0, ans, 0, x);
//        if (y == 1)
//            return ans;
        for (int i = x; i < y - 1 + x; i++)
            ans[i] = matrix[i - x + 1][x - 1];
//        if (x == 1)
//            return ans;
        for (int i = x + y - 1; i < 2 * x + y - 2; i++)
            ans[i] = matrix[y - 1][x - 2 - (i - x - y + 1)];
        for (int i = 2 * x + y - 2; i < 2 * (x + y) - 4; i++)
            ans[i] = matrix[y - 2 - (i - 2 * x - y + 2)][0];
        return arrayJoin(ans, spiralOrder(newMatrix));
    }
}

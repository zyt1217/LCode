package Array.matrix;

import java.util.*;

public class JZ29_Solution54 {
    public static void main(String[] args){
        int[][] s = new int[][]{{6,9,7}};
        spiralOrder(s);
        System.out.println(Arrays.toString(spiralOrder(s)));
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        int y = matrix.length;
        if (y == 0)
            return new LinkedList<Integer>(){};
        int x = matrix[0].length;
        List<Integer> ans = new ArrayList<Integer>();
        if (x <= 2 || y <= 2) {
            for (int i = 0; i < x; i++)
                ans.add(matrix[0][i]);
            if (y == 1)
                return ans;
            for (int i = x; i < y - 1 + x; i++)
                ans.add(matrix[i - x + 1][x - 1]);
            if (x == 1)
                return ans;
            for (int i = x + y - 1; i < 2 * x + y - 2; i++)
                ans.add(matrix[y - 1][x - 2 - (i - x - y + 1)]);
            for (int i = 2 * x + y - 2; i < 2 * (x + y) - 4; i++)
                ans.add(matrix[y - 2 - (i - 2 * x - y + 2)][0]);
            return ans;
        }
        int[][] newMatrix = new int[y - 2][x - 2];
        for (int i = 0; i < y - 2; i++) {
            System.arraycopy(matrix[i + 1], 1, newMatrix[i], 0, x - 2);
        }
        for (int i = 0; i < x; i++)
            ans.add(matrix[0][i]);
        for (int i = x; i < y - 1 + x; i++)
            ans.add(matrix[i - x + 1][x - 1]);
        for (int i = x + y - 1; i < 2 * x + y - 2; i++)
            ans.add(matrix[y - 1][x - 2 - (i - x - y + 1)]);
        for (int i = 2 * x + y - 2; i < 2 * (x + y) - 4; i++)
            ans.add(matrix[y - 2 - (i - 2 * x - y + 2)][0]);
        ans.addAll(spiralOrder1(newMatrix));
        return ans;
    }

    public static int[] spiralOrder(int[][] matrix) {
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

    public static int[] arrayJoin ( int[] a, int[] b){
        int[] arr = new int[a.length + b.length];//开辟新数组长度为两数组之和
        //拷贝a数组到目标数组arr
        System.arraycopy(a, 0, arr, 0, a.length);
        //拷贝b数组到目标数组arr
        System.arraycopy(b, 0, arr, a.length, b.length);
        return arr;
    }

}

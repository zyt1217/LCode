import java.util.Scanner;

public class hw2 {

}

class Main {

    private static int minTime = Integer.MAX_VALUE;
    private static boolean flag = false;
    private static int row;
    private static int col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        Main.row = r;
        Main.col = c;
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = scanner.nextInt();
            }
        }
        if (m[0][0] == 0 || m[r - 1][c - 1] < r + c - 1) {
            System.out.println(-1);
        } else {
            boolean[][] visited = new boolean[r][c];
            dfs(m, 0, visited, 0, 0);
            if (flag) {
                System.out.println(minTime);
            } else {
                System.out.println(-1);
            }
        }

    }

    private static void dfs(int[][] map, int time, boolean[][] visited, int i, int j) {
        //时间不够则返回
        if (map[i][j] <= time) {
            return;
        }
        //到达终点
        if (i == row - 1 && j == col - 1) {
            minTime = Math.min(minTime, time);
            flag = true;
        }
        //向下
        if (i != row - 1 && map[i + 1][j] > time + 1 && !visited[i + 1][j]) {
            visited[i][j] = true;
            dfs(map, time + 1, visited, i + 1, j);
        }
        //向右
        if (j != col - 1 && map[i][j + 1] > time + 1 && !visited[i][j + 1]) {
            visited[i][j] = true;
            dfs(map, time + 1, visited, i, j + 1);
        }
        //向上
        if (i != 0 && map[i - 1][j] > time + 1 && !visited[i - 1][j]) {
            visited[i][j] = true;
            dfs(map, time + 1, visited, i - 1, j);
        }
        //向左
        if (j != 0 && map[i][j - 1] > time + 1 && !visited[i][j - 1]) {
            visited[i][j] = true;
            dfs(map, time + 1, visited, i, j - 1);
        }
        visited[i][j] = false;
    }

}
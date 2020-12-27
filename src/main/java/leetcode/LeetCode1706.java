package leetcode;

public class LeetCode1706 {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        final int[] res = new int[n];
        for (int j = 0; j < n; j++) {
            res[j] = findBall(grid, m, n, 0, j);
        }
        return res;
    }

    private int findBall(final int[][] grid, final int m, final int n, final int i, final int j) {
        if (grid[i][j] == 1) {
            if (j + 1 < n && i + 1 == m && grid[i][j + 1] == 1) {
                return j + 1;
            } else if (j + 1 >= n || grid[i][j + 1] != 1 || i + 1 > m) {
                return -1;
            } else {
                return findBall(grid, m, n, i + 1, j + 1);
            }
        } else {
            if (j - 1 >= 0 && i + 1 == m && grid[i][j - 1] == -1) {
                return j - 1;
            } else if (j - 1 < 0 || grid[i][j - 1] != -1 || i + 1 > m) {
                return -1;
            } else {
                return findBall(grid, m, n, i + 1, j - 1);
            }
        }
    }
}

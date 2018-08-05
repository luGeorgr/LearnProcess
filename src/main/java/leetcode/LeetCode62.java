package leetcode;

public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] res = new int[n][m];
        res[0][0] = 1;
        for (int i = 0; i < n; i++) {
            res[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            res[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                res[i][j] =  res[i-1][j] + res[i][j-1];
            }
        }
        return res[n-1][m-1];
    }
}

package leetcode;

public class LeetCode764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] value = new int[n][n];
        for (int[] mine : mines) {
            value[mine[0]][mine[1]] = -1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, arm(i, j, n, value));
            }
        }
        return max;
    }

    private int arm(int i, int j, int n, int[][] value) {
        int k = 0;
        for (; i + k < n && i - k >= 0 && j + k < n && j - k >= 0; k++) {
            if (!(value[i][j + k] == 0 && value[i][j - k] == 0 && value[i + k][j] == 0 && value[i - k][j] == 0)) {
                break;
            }
        }
        return k;
    }
}

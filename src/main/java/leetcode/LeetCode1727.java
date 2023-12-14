package leetcode;

import java.util.Arrays;

public class LeetCode1727 {
    public int largestSubmatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < row; i++) {
            Arrays.sort(matrix[i]);
            int k = 1;
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    break;
                }
                max = Math.max(max, matrix[i][j] * k);
                k += 1;
            }
        }
        return max;
    }
}

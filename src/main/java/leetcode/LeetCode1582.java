package leetcode;

import java.util.Arrays;

public class LeetCode1582 {
    public int numSpecial(int[][] mat) {
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        Arrays.fill(row, 0);
        Arrays.fill(col, 0);

        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    res += 1;
                }
            }
        }
        return res;
    }
}

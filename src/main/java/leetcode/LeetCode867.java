package leetcode;

public class LeetCode867 {
    public int[][] transpose(int[][] A) {
        final int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = A[j][i];
            }
        }
        return res;
    }
}

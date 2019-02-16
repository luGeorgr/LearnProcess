package leetcode;

import java.util.Arrays;

public class LeetCode977 {
    public int[] sortedSquares(int[] A) {
//        for (int i = 0; i < A.length; i++) {
//            A[i] *= A[i];
//        }
//        Arrays.sort(A);
//        return A;
        int[] res = new int[A.length];
        int i = 0, j = A.length - 1;
        for (int k = j; k >= 0; k--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                res[k] = A[i] * A[i];
                i++;
            } else {
                res[k] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }
}

package leetcode;

import java.util.Arrays;

public class LeetCode1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0;
        int i = 0;
        for (; i < A.length && K > 0 && A[i] < 0; i++, K--) {
            A[i] = -A[i];
        }
        if (K % 2 != 0) {
            if (i >= A.length) {
                A[i - 1] = -A[i-1];
            } else {
                if (i > 0 && A[i] > A[i - 1]) {
                    A[i - 1] = -A[i-1];
                } else {
                    A[i] = -A[i];
                }
            }
        }
        for (int n : A) {
            sum += n;
        }

        return sum;
    }
}

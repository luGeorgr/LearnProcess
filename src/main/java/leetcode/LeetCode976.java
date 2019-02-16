package leetcode;

import java.util.Arrays;

public class LeetCode976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        if (A.length < 3) {
            return 0;
        }
        int max = 0;
        int sum = A[A.length - 1] + A[A.length - 2];
        for (int i = A.length - 3;  i >= 0; i--) {
            sum += A[i];
            if (A[i] + A[i+1] > A[i+2]) {
                max = sum;
                break;
            } else {
                sum -= A[i+2];
            }
        }
        return max;
    }
}

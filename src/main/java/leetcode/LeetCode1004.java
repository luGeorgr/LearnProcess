package leetcode;

public class LeetCode1004 {
    public int longestOnes(int[] A, int K) {
        int[] value = new int[A.length];
        int max = value[0] =  maxLength(A, 0, K);

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == 1) {
                value[i] = value[i - 1] - 1;
            } else {
                value[i] = value[i - 1] - 1 + maxLength(A, i -  1 + value[i - 1], 1);
                max = value[i] > max ? value[i] : max;
            }
        }
        return max;
    }

    private int maxLength(int[] A, int begin, int K) {
        int res = 0;
        for (;begin < A.length; begin++) {
            if (A[begin] == 0 && K > 0) {
                K--;
                res++;
            } else if (A[begin] == 0 && K == 0) {
                break;
            } else {
                res++;
            }
        }
        return res;
    }
}

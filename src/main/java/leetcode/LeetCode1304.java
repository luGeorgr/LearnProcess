package leetcode;

public class LeetCode1304 {
    public int[] sumZero(int n) {
        final int[] res = new int[n];
        int j = 0;
        for (int i = 1; i <= n / 2; i++) {
            res[j++] = i;
            res[j++] = -i;
        }
        if (n % 2 == 1) {
            res[n - 1] = 0;
        }
        return res;
    }
}

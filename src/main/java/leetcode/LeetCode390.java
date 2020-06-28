package leetcode;

public class LeetCode390 {
    public int lastRemaining(int n) {
        return helper(true, n);
    }

    private int helper(final boolean front, int n) {
        if (n == 1) {
            return 1;
        }

        if (front) {
            return helper(!front, n / 2) * 2;
        } else if (n % 2 == 0) {
            return helper(!front, n / 2) * 2 - 1;
        } else {
            return helper(!front, n / 2) * 2;
        }
    }
}

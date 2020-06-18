package leetcode;

import java.util.Arrays;

public class LeetCode1406 {
    private int[] dp;
    public String stoneGameIII(int[] stoneValue) {
        dp = new int[stoneValue.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        final int result = visit(stoneValue, 0);
        if (result == 0) {
            return "Tie";
        } else if (result > 0) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

    private int visit(int[] stoneValue, int index) {
        if (index >= stoneValue.length) {
            return 0;
        }
        if (dp[index] != Integer.MIN_VALUE) {
            return dp[index];
        }
        int sum = 0;
        for (int i = 0; i < 3 && i + index < stoneValue.length; i++) {
            sum += stoneValue[i+index];
            dp[index] = Math.max(dp[index], sum - visit(stoneValue, index + i + 1));
        }
        return dp[index];
    }
}

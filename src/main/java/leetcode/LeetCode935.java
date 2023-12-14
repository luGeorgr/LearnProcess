package leetcode;

import java.util.Arrays;

public class LeetCode935 {
    public int knightDialer(int n) {
        int[][] dp = new int[2][10];
        int mode = 1_000_000_007;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                Arrays.fill(dp[0], 1);
            } else {
                dp[(i + 1) % 2][0] = dp[i % 2][4] + dp[i % 2][6];
                dp[(i + 1) % 2][1] = dp[i % 2][6] + dp[i % 2][8];
                dp[(i + 1) % 2][2] = dp[i % 2][7] + dp[i % 2][9];
                dp[(i + 1) % 2][3] = dp[i % 2][4] + dp[i % 2][8];
                dp[(i + 1) % 2][4] = dp[i % 2][0] + dp[i % 2][3] + dp[i % 2][9];
                dp[(i + 1) % 2][5] = 0;
                dp[(i + 1) % 2][6] = dp[i % 2][0] + dp[i % 2][1] + dp[i % 2][7];
                dp[(i + 1) % 2][7] = dp[i % 2][2] + dp[i % 2][6];
                dp[(i + 1) % 2][8] = dp[i % 2][1] + dp[i % 2][3];
                dp[(i + 1) % 2][9] = dp[i % 2][2] + dp[i % 2][4];
                for (int j = 0; j < 10; j++) {
                    dp[(i + 1) % 2][j] = (dp[(i + 1) % 2][j]) % mode;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp[(n + 1) % 2][i]) % mode;
        }
        return res;
    }
}

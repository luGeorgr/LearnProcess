package leetcode;

public class LeetCode647 {
    public int countSubstrings(String s) {
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length() ; j++) {
                if (i > j) {
                    dp[i][j] = false;
                } else if (i == j) {
                    dp[i][j] = true;
                    res++;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = (i+1 > j-1) || dp[i + 1][j - 1];
                        res = dp[i][j] ? res + 1 : res;
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return res;
    }
}

package leetcode;

import java.util.Arrays;
import java.util.Map;

public class LeetCode1781 {
    public int beautySum(String s) {
        int ans = 0;
        final int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(chars, 0);
            for (int j = i; j < s.length(); j++) {
                chars[s.charAt(j) - 'a']++;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int aChar : chars) {
                    if (aChar == 0) {
                        continue;
                    }
                    max = Math.max(max, aChar);
                    min = Math.min(min, aChar);
                }
                ans += max - min;
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        final LeetCode1781 leetCode1781 = new LeetCode1781();
        leetCode1781.beautySum("aabcb");
    }

}

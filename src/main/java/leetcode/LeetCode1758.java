package leetcode;

public class LeetCode1758 {
    public int minOperations(String s) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 1; i++) {
            int ops = 0;
            int flag = i;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) - '0' != flag) {
                    ops++;
                }
                flag ^= 1;
            }
            if (ops < min) {
                min = ops;
            }
        }
        return min;
    }
}

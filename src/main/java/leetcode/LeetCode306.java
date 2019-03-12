package leetcode;

public class LeetCode306 {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length(); i++) {
            int left = valueOf(num, 0, i, i != 1);
            if (left == -1) {
                continue;
            }
            for (int j = i + 1; j < num.length(); j++) {
                int right = valueOf(num, i, j, i + 1 != j);
                if (right == -1) {
                    continue;
                }
                if (backtrack(left, right, num, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int valueOf(final String num, int begin, int end, boolean flag) {
        if (num.charAt(begin) == '0' && flag) {
            return -1;
        }
        int res = 0;
        for (int i = begin; i < end; i++) {
            res = res * 10 + num.charAt(i) - '0';
        }
        return res;
    }

    private boolean backtrack(int left, int right, String num, int begin) {
        if (begin == num.length()) {
            return true;
        }
        for (int i = begin + 1; i <= num.length(); i++) {
            int sum = valueOf(num, begin, i, i - 1 != begin);
            if (sum == -1) {
                return false;
            }
            if (left + right == sum) {
                boolean flag = backtrack(right, sum, num, i);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}

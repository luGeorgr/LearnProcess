package leetcode;

public class LeetCode1545 {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        if (k * 2 == (1 << n )) {
            return '1';
        } else if (k * 2 > (1 << n )) {
            return findKthBit(n - 1, (1 << n) - k) == '0' ? '1' : '0';
        } else {
            return findKthBit(n - 1, k);
        }
    }
}

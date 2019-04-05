package leetcode;

public class LeetCode1015 {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        int count = 1;
        int n = 1;
        while (true) {
            if (n % K == 0) {
                return count;
            } else {
                count++;
                n = n * 10 + 1;
            }
        }
    }
}

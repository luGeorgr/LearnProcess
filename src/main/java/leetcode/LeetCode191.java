package leetcode;

public class LeetCode191 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                res += 1;
            }
            n = n >>> 1;
        }
        return res;
    }
}

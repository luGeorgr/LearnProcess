package leetcode;

public class LeetCode1688 {
    public int numberOfMatches(int n) {
        int count = 0;
        while (n != 1) {
            count += n >> 1;
            n = (n >> 1) + (n & 1);
        }
        return count;
    }
}

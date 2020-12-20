package leetcode;

public class LeetCode1689 {
    public int minPartitions(String n) {
        char max = '0';
        for (final char c : n.toCharArray()) {
            if (c > max) {
                max = c;
            }
        }
        return max - '0';
    }
}

package leetcode;

public class LeetCode940 {
    public int distinctSubseqII(String s) {
        int res = 1; int mode = 1000_000_007;
        int[] end = new int[26];
        for (char c : s.toCharArray()) {
            int temp = res;
            res = (res * 2 % mode + mode - end[c - 'a']) % mode;
            end[c - 'a'] = temp;
        }
        return (res - 1 + mode) % mode;
    }
}

package leetcode;

public class LeetCode1759 {
    public int countHomogenous(String s) {
        int sum = 0;
        int i = 0;
        for (;i < s.length();) {
            int j = i + 1;
            for (; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                }
            }
            for (int k = 1; k <= j - i; k++) {
                sum = (sum + k) % 1000000007;
            }
            i = j;
        }
        return sum;
    }
}

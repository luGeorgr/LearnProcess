package leetcode;

public class LeetCode1759 {
    public int countHomogenous(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); ) {
            int j = i;
            for (; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    i = j;
                    break;
                }
                sum = (sum + j - i + 1) % 1000000007;
            }

            if (j >= s.length()) {
                i = j;
            }
        }
        return sum;
    }
}

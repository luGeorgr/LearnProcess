package leetcode;

public class LeetCode1332 {
    public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (isPalindrome(s)) {
            return 1;
        }
        return 2;
    }

    private boolean isPalindrome(final String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}

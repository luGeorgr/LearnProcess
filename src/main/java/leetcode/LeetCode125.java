package leetcode;

public class LeetCode125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && (!alphanumeric(s.charAt(i)))) {
                i++;
            }

            while (i < j && (!alphanumeric(s.charAt(j)))) {
                j--;
            }

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean alphanumeric(char c) {
        return c <= 'Z' && c >= 'A' || c <= 'z' && c >= 'a' || c <= '9' && c >= '0';
    }
}

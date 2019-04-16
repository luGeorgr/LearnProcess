package leetcode;

public class LeetCode859 {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        char a, b, c, d;
        int[] arr = new int[26];
        a = b = c = d = 0;
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            arr[A.charAt(i) - 'a']++;
            if (A.charAt(i) != B.charAt(i)) {
                count++;
                if (count == 1) {
                    a = A.charAt(i);
                    b = B.charAt(i);
                } else if (count == 2) {
                    c = A.charAt(i);
                    d = B.charAt(i);
                } else {
                    return false;
                }
            }
        }
        if (count == 0) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] >= 2) {
                    return true;
                }
            }
            return false;
        } else {
            return a == d && b == c;
        }
    }
}

package leetcode;

public class LeetCode1309 {
    public String freqAlphabets(String s) {
        final StringBuilder builder = new StringBuilder();
        int i = 0;
        for (; i + 2 < s.length();) {
            if (s.charAt(i+2) != '#') {
                builder.append((char)(s.charAt(i) - '1' + 'a'));
                i++;
            } else {
                builder.append((char)((s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '1' + 'a'));
                i += 3;
            }
        }
        while (i < s.length()) {
            builder.append((char)(s.charAt(i) - '1' + 'a'));
            i++;
        }
        return builder.toString();
    }
}

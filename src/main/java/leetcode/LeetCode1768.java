package leetcode;

public class LeetCode1768 {
    public String mergeAlternately(String word1, String word2) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0, j = 0; i < word1.length() || j < word2.length();) {
            if (i <= j && i < word1.length()) {
                builder.append(word1.charAt(i));
                i++;
                continue;
            }

            if (j < i && j < word2.length()) {
                builder.append(word2.charAt(j));
                j++;
                continue;
            }

            while (i < word1.length()) {
                builder.append(word1.charAt(i));
                i++;
            }

            while (j < word2.length()) {
                builder.append(word2.charAt(j));
                j++;
            }
        }
        return builder.toString();
    }
}

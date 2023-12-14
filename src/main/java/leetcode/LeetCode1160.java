package leetcode;

public class LeetCode1160 {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (char c : chars.toCharArray()) {
            count[c - 'a'] += 1;
        }
        int res = 0;
        for (String word : words) {
            if (canFormed(word, count)) {
                res += word.length();
            }
        }
        return res;
    }

    private boolean canFormed(String word, int[] count) {
        int[] wordCount = new int[26];
        for (char c : word.toCharArray()) {
            wordCount[c - 'a'] += 1;
            if (wordCount[c - 'a'] > count[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}

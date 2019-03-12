package leetcode;

import java.util.*;

public class LeetCode1002 {
    public List<String> commonChars(String[] A) {
        final int res[] = new int[26];
        final List<String> list = new ArrayList<>();
        Arrays.fill(res, Integer.MAX_VALUE);
        for (String s : A) {
            int[] temp = new int[26];
            for (char c : s.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                res[i] = Math.min(res[i], temp[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            if (res[i] != 0) {
                while (res[i]-- > 0) {
                    list.add(String.valueOf((char)(i + 'a')));
                }
            }
        }
        return list;
    }
}

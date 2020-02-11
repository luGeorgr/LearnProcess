package leetcode;

import java.util.Arrays;

public class LeetCode1347 {
    public int minSteps(String s, String t) {
        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (arr[t.charAt(i) - 'a'] != 0) {
                arr[t.charAt(i) - 'a']--;
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += arr[i];
        }
        return res;
    }
}

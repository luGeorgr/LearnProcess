package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode409 {
    public int longestPalindrome(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean flag = false;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                res += map.get(c) - 1;
                flag = true;
            } else {
                res += map.get(c);
            }
        }
        return flag ? res + 1 : res;
    }
}

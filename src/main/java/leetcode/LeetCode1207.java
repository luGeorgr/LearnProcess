package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1207 {
    public boolean uniqueOccurrences(int[] arr) {
        final Map<Integer, Integer> count = new HashMap<>();
        for (int i : arr) {
            count.put(i,  count.getOrDefault(i, 0) + 1);
        }
        final Map<Integer, Integer> test = new HashMap<>();
        for (final Integer key : count.keySet()) {
            if (test.containsKey(count.get(key))) {
                return false;
            }
            test.put(count.get(key), key);
        }
        return true;
    }
}

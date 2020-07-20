package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1512 {
    public int numIdenticalPairs(int[] nums) {
        final Map<Integer, Integer> countMap = new HashMap<>();
        for (final int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        for (final Integer key : countMap.keySet()) {
            int count = countMap.get(key);
            sum = sum + (count - 1 + 1) * (count - 1) / 2;
        }
        return sum;
    }
}

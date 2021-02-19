package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1726 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> mapCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                final int product = nums[i] * nums[j];
                mapCount.put(product, mapCount.getOrDefault(product, 0) + 1);
            }
        }
        int result = 0;
        for (final int value : mapCount.values()) {
            if (value <= 1) {
                continue;
            }
            int prouct = 1;
            for (int i = 0; i < 2; i++) {
                prouct *= value - i;
            }
            result += prouct / 2;
        }
        return result * 8;
    }
}

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        final int[] temp = Arrays.copyOf(nums, nums.length);;
        Arrays.sort(temp);
        final Map<Integer, Integer> map = new HashMap<>();
        int count = -1;
        for (int num : temp) {
            count++;
            if (map.containsKey(num)) {
                continue;
            }
            map.put(num, count);
        }
        final int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}
